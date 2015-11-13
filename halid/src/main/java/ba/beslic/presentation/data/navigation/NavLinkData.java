package ba.beslic.presentation.data.navigation;

import ba.beslic.presentation.data.IdentifiableData;

import java.util.List;


/**
 * Author:  Admir Memic
 * Date:    17.09.2015
 * E-Mail:  admir.memic@dmc.de
 */
public class NavLinkData extends IdentifiableData
{
	private String name;
	private String url;
	private List<NavLinkData> childLinks;

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

	public List<NavLinkData> getChildLinks()
	{
		return childLinks;
	}

	public void setChildLinks(List<NavLinkData> childLinks)
	{
		this.childLinks = childLinks;
	}
}
