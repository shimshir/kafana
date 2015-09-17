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
	SidebarEntity getSidebarByIdDeep(int id);
	SidebarEntity getSidebarByPathDeep(String path);

	NavLinkEntity getNavLinkByIdDeep(int id);
	List<NavLinkEntity> getNavLinksByUrlDeep(String url);
	List<NavLinkEntity> getNavLinksByNameDeep(String name);

	SidebarEntity getSidebarByIdShallow(int id);
	SidebarEntity getSidebarByPathShallow(String path);

	NavLinkEntity getNavLinkByIdShallow(int id);
	List<NavLinkEntity> getNavLinksByUrlShallow(String url);
	List<NavLinkEntity> getNavLinksByNameShallow(String name);

	void save(IdentifiableEntity entity);
}
