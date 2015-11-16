package ba.beslic.models.presentation.navigation.sidebar;

import ba.beslic.models.presentation.IdentifiableData;
import ba.beslic.models.presentation.navigation.NavLinkData;

import java.util.List;


/**
 * Author:  Admir Memic
 * Date:    17.09.2015
 * E-Mail:  admir.memic@dmc.de
 */
public class SidebarData extends IdentifiableData
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
