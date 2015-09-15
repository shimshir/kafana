package ba.beslic.persistence.entities.navigation.sidebar;


import ba.beslic.persistence.entities.GenericEntity;
import ba.beslic.persistence.entities.navigation.NavLinkEntity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
public class SidebarEntity extends GenericEntity
{
	@Column(name = "path", unique = true)
	private String path;
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name = "sidebar_2_nav_link", joinColumns = {
			@JoinColumn(name = "sidebar_id", referencedColumnName = "id") }, inverseJoinColumns = {
			@JoinColumn(name = "nav_link_id", referencedColumnName = "id") })
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
