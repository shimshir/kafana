package ba.beslic.persistence.entities.navigation.sidebar;


import ba.beslic.persistence.entities.IdentifiableEntity;
import ba.beslic.persistence.entities.navigation.NavLinkEntity;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.FetchProfile;
import org.hibernate.annotations.FetchProfiles;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;
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
