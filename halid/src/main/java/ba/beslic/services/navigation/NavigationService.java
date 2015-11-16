package ba.beslic.services.navigation;

import ba.beslic.models.persistence.IdentifiableEntity;
import ba.beslic.models.persistence.navigation.NavLinkEntity;
import ba.beslic.models.persistence.navigation.sidebar.SidebarEntity;

import java.util.List;


/**
 * Author:  Admir Memic
 * Date:    15.09.2015
 * E-Mail:  admir.memic@dmc.de
 */
public interface NavigationService
{
	SidebarEntity getSidebarById(Integer id);
	SidebarEntity getSidebarByPath(String path);

	NavLinkEntity getNavLinkById(Integer id);
	List<NavLinkEntity> getNavLinksByUrl(String url);
	List<NavLinkEntity> getNavLinksByName(String name);

	void save(IdentifiableEntity entity);
}
