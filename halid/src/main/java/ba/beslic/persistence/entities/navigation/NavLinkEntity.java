package ba.beslic.persistence.entities.navigation;

import ba.beslic.persistence.entities.IdentifiableEntity;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.FetchProfile;
import org.hibernate.annotations.FetchProfiles;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;


/**
 * Author: Admir Memić
 * Date:   12.09.2015
 */
@Entity(name = "NavLink")
@Table(name = "nav_link")
@FetchProfiles({ @FetchProfile(
		fetchOverrides = {
				@FetchProfile.FetchOverride(association = "childLinks", entity = NavLinkEntity.class, mode = FetchMode.JOIN) },
		name = NavLinkEntity.FP_NAVLINK_CHILDLINKS) })
public class NavLinkEntity extends IdentifiableEntity
{
	public static final String FP_NAVLINK_CHILDLINKS = "navLink-childLinks";

	@Column(name = "name")
	private String name;
	@Column(name = "url")
	private String url;
	@Column(name = "display_priority")
	private int displayPriority;
	@OneToMany(cascade = CascadeType.ALL)
	@JoinTable(
			name = "nav_link_2_nav_link",
			joinColumns = @JoinColumn(name = "parent_link_id", referencedColumnName = "id"),
			inverseJoinColumns = @JoinColumn(name = "child_link_id", referencedColumnName = "id"))
	private Set<NavLinkEntity> childLinks;

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getUrl()
	{
		return url;
	}

	public void setUrl(String url)
	{
		this.url = url;
	}

	public int getDisplayPriority()
	{
		return displayPriority;
	}

	public void setDisplayPriority(int displayPriority)
	{
		this.displayPriority = displayPriority;
	}

	public Set<NavLinkEntity> getChildLinks()
	{
		return childLinks;
	}

	public void setChildLinks(Set<NavLinkEntity> childLinks)
	{
		this.childLinks = childLinks;
	}

}
