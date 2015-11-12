package ba.beslic.service.services.navigation.impl;

import ba.beslic.persistence.daos.navigation.NavigationDao;
import ba.beslic.persistence.entities.IdentifiableEntity;
import ba.beslic.persistence.entities.navigation.NavLinkEntity;
import ba.beslic.persistence.entities.navigation.sidebar.SidebarEntity;
import ba.beslic.service.services.navigation.NavigationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * Author:  Admir Memic
 * Date:    15.09.2015
 * E-Mail:  admir.memic@dmc.de
 */
@Service("navigationService")
public class NavigationServiceImpl implements NavigationService
{
	@Autowired
	private NavigationDao navigationDao;

	@Override
	public SidebarEntity getSidebarById(int id)
	{
		return navigationDao.getById(SidebarEntity.class, id);
	}

	@Override
	public SidebarEntity getSidebarByPath(String path)
	{
		return navigationDao.getSidebarByPath(path);
	}

	@Override
	public NavLinkEntity getNavLinkById(int id)
	{
		return navigationDao.getById(NavLinkEntity.class, id);
	}

	@Override
	public List<NavLinkEntity> getNavLinksByUrl(String url)
	{
		return navigationDao.getNavLinkByUrl(url);
	}

	@Override
	public List<NavLinkEntity> getNavLinksByName(String name)
	{
		return navigationDao.getNavLinkByName(name);
	}

	@Override
	public void save(IdentifiableEntity entity) {
		navigationDao.create(entity);
	}
}
