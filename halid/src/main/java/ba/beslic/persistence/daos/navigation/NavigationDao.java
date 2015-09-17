package ba.beslic.persistence.daos.navigation;

import ba.beslic.persistence.daos.Dao;
import ba.beslic.persistence.entities.navigation.NavLinkEntity;
import ba.beslic.persistence.entities.navigation.sidebar.SidebarEntity;

import java.util.List;


/**
 * Author:  Admir Memic
 * Date:    17.09.2015
 * E-Mail:  admir.memic@dmc.de
 */
public interface NavigationDao extends Dao
{
	List<NavLinkEntity> getNavLinkByUrl(String url, String... fetchProfiles);
	List<NavLinkEntity> getNavLinkByName(String name, String... fetchProfiles);

	SidebarEntity getSidebarByPath(String path, String... fetchProfiles);
}
