package ba.beslic.daos.navigation;

import ba.beslic.daos.Dao;
import ba.beslic.models.persistence.navigation.NavLinkEntity;
import ba.beslic.models.persistence.navigation.sidebar.SidebarEntity;

import java.util.List;


/**
 * Author:  Admir Memic
 * Date:    17.09.2015
 * E-Mail:  admir.memic@dmc.de
 */
public interface NavigationDao extends Dao
{
	List<NavLinkEntity> getNavLinkByUrl(String url);
	List<NavLinkEntity> getNavLinkByName(String name);

	SidebarEntity getSidebarByPath(String path);
}
