package ba.beslic.persistence.entities.navigation.sidebar;


import ba.beslic.persistence.entities.GenericEntity;
import ba.beslic.persistence.entities.navigation.NavLinkEntity;
import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.FetchProfile;
import org.hibernate.annotations.FetchProfiles;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;


/**
 * Author: Admir Memić
 * Date:   12.09.2015
 */
@Entity(name = "Sidebar")
@Table(name = "sidebar")
@FetchProfiles({ @FetchProfile(
		fetchOverrides = {
				@FetchProfile.FetchOverride(association = "links", entity = SidebarEntity.class, mode = FetchMode.JOIN) },
		name = SidebarEntity.FP_SIDEBAR_LINKS) })
public class SidebarEntity extends GenericEntity
{
	public static final String FP_SIDEBAR_LINKS = "sidebar-links";

	@Column(name = "path", unique = true)
	private String path;
	@OneToMany(cascade = CascadeType.ALL)
	@JoinTable(
			name = "sidebar_2_nav_link",
			joinColumns = @JoinColumn(name = "sidebar_id", referencedColumnName = "id"),
			inverseJoinColumns = @JoinColumn(name = "nav_link_id", referencedColumnName = "id"))
	@GenericGenerator(name = "uuid-gen", strategy = "uuid")
	@CollectionId(columns = @Column(name = "id"), type = @Type(type = "string"), generator = "uuid-gen")
	private List<NavLinkEntity> links;

	public String getPath()
	{
		return path;
	}

	public void setPath(String path)
	{
		this.path = path;
	}

	public List<NavLinkEntity> getLinks()
	{
		return links;
	}

	public void setLinks(List<NavLinkEntity> links)
	{
		this.links = links;
	}
}
