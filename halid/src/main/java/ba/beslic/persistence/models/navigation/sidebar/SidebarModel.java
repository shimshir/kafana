package ba.beslic.persistence.models.navigation.sidebar;


import ba.beslic.persistence.models.GenericModel;
import ba.beslic.persistence.models.navigation.NavLinkModel;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.util.List;


/**
 * Author: Admir Memić
 * Date:   12.09.2015
 */
@Entity
@Table(name = "sidebar")
public class SidebarModel extends GenericModel
{
	@Column(name = "path")
	private String path;
	@OneToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "sidebar_2_nav_link", joinColumns = {
			@JoinColumn(name = "sidebar_id", referencedColumnName = "id") }, inverseJoinColumns = {
			@JoinColumn(name = "nav_link_id", referencedColumnName = "id") })
	private List<NavLinkModel> links;

	public String getPath()
	{
		return path;
	}

	public void setPath(String path)
	{
		this.path = path;
	}

	public List<NavLinkModel> getLinks()
	{
		return links;
	}

	public void setLinks(List<NavLinkModel> links)
	{
		this.links = links;
	}
}
