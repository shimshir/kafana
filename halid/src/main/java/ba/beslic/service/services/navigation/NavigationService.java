package ba.beslic.service.services.navigation;

import ba.beslic.persistence.entities.IdentifiableEntity;
import ba.beslic.persistence.entities.navigation.NavLinkEntity;
import ba.beslic.persistence.entities.navigation.sidebar.SidebarEntity;

import java.util.List;


/**
 * Author:  Admir Memic
 * Date:    15.09.2015
 * E-Mail:  admir.memic@dmc.de
 */
public interface NavigationService
{
	SidebarEntity getSidebarById(int id);
	SidebarEntity getSidebarByPath(String path);

	NavLinkEntity getNavLinkById(int id);
	List<NavLinkEntity> getNavLinksByUrl(String url);
	List<NavLinkEntity> getNavLinksByName(String name);

	void save(IdentifiableEntity entity);
}
