package ba.beslic.presentation.data.navigation.sidebar;

import ba.beslic.presentation.data.PresentationData;
import ba.beslic.presentation.data.navigation.NavLinkData;

import java.util.List;


/**
 * Author:  Admir Memic
 * Date:    17.09.2015
 * E-Mail:  admir.memic@dmc.de
 */
public class SidebarData implements PresentationData
{
	private String path;
	private List<NavLinkData> links;

	public String getPath()
	{
		return path;
	}

	public void setPath(String path)
	{
		this.path = path;
	}

	public List<NavLinkData> getLinks()
	{
		return links;
	}

	public void setLinks(List<NavLinkData> links)
	{
		this.links = links;
	}
}
