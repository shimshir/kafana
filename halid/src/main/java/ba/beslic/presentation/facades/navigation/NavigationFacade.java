package ba.beslic.presentation.facades.navigation;

import ba.beslic.presentation.data.navigation.sidebar.SidebarData;


/**
 * Author:  Admir Memic
 * Date:    17.09.2015
 * E-Mail:  admir.memic@dmc.de
 */
public interface NavigationFacade
{
	SidebarData getSidebarByEncPath(String encodedPath);
}
