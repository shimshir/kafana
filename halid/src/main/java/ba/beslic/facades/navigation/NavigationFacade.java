package ba.beslic.facades.navigation;

import ba.beslic.models.presentation.navigation.sidebar.SidebarData;


/**
 * Author:  Admir Memic
 * Date:    17.09.2015
 * E-Mail:  admir.memic@dmc.de
 */
public interface NavigationFacade
{
	SidebarData getSidebarByEncPath(String encodedPath);

	SidebarData createSidebar(SidebarData sidebarData);
}
