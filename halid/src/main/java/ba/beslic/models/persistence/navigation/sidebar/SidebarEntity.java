package ba.beslic.models.persistence.navigation.sidebar;


import ba.beslic.models.persistence.IdentifiableEntity;
import ba.beslic.models.persistence.navigation.NavLinkEntity;

import javax.persistence.*;
import java.util.Set;


/**
 * Author: Admir Memić
 * Date:   12.09.2015
 */
@Entity(name = "Sidebar")
@Table(name = "sidebar")
public class SidebarEntity extends IdentifiableEntity
{
	@Column(name = "path", unique = true)
	private String path;
	@OneToMany(cascade = CascadeType.ALL)
	@JoinTable(
			name = "sidebar_2_nav_link",
			joinColumns = @JoinColumn(name = "sidebar_id", referencedColumnName = "id"),
			inverseJoinColumns = @JoinColumn(name = "nav_link_id", referencedColumnName = "id"))
	@OrderBy("display_priority")
	private Set<NavLinkEntity> links;

	public String getPath()
	{
		return path;
	}

	public void setPath(String path)
	{
		this.path = path;
	}

	public Set<NavLinkEntity> getLinks()
	{
		return links;
	}

	public void setLinks(Set<NavLinkEntity> links)
	{
		this.links = links;
	}
}
