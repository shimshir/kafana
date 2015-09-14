package ba.beslic.persistence.models.navigation;

import ba.beslic.persistence.models.GenericModel;

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
@Entity
@Table(name = "nav_link")
public class NavLinkModel extends GenericModel
{
	@Column(name = "name")
	private String name;
	@Column(name = "url")
	private String url;
	@OneToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "nav_link_2_nav_link", joinColumns = {
			@JoinColumn(name = "parent_link_id", referencedColumnName = "id") }, inverseJoinColumns = {
			@JoinColumn(name = "child_link_id", referencedColumnName = "id") })
	private List<NavLinkModel> childLinks;

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

	public List<NavLinkModel> getChildLinks()
	{
		return childLinks;
	}

	public void setChildLinks(List<NavLinkModel> childLinks)
	{
		this.childLinks = childLinks;
	}

}
