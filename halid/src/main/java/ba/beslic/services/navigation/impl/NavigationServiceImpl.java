package ba.beslic.services.navigation.impl;

import ba.beslic.daos.navigation.NavigationDao;
import ba.beslic.models.persistence.IdentifiableEntity;
import ba.beslic.models.persistence.navigation.NavLinkEntity;
import ba.beslic.models.persistence.navigation.sidebar.SidebarEntity;
import ba.beslic.services.navigation.NavigationService;
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
	public SidebarEntity getSidebarById(Integer id)
	{
		return navigationDao.getById(SidebarEntity.class, id);
	}

	@Override
	public SidebarEntity getSidebarByPath(String path)
	{
		return navigationDao.getSidebarByPath(path);
	}

	@Override
	public NavLinkEntity getNavLinkById(Integer id)
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
