package ba.beslic.services.navigation.impl;

import ba.beslic.persistence.daos.navigation.NavLinkDao;
import ba.beslic.persistence.daos.navigation.sidebar.SidebarDao;
import ba.beslic.persistence.entities.GenericEntity;
import ba.beslic.persistence.entities.navigation.NavLinkEntity;
import ba.beslic.persistence.entities.navigation.sidebar.SidebarEntity;
import ba.beslic.services.navigation.NavigationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


/**
 * Author:  Admir Memic
 * Date:    15.09.2015
 * E-Mail:  admir.memic@dmc.de
 */
@Service("navigationService")
@Transactional
public class NavigationServiceImpl implements NavigationService
{
	@Autowired
	private SidebarDao sidebarDao;
	@Autowired
	private NavLinkDao navLinkDao;

	@Override
	public SidebarEntity getSidebarById(int id)
	{
		return sidebarDao.getById(id);
	}

	@Override
	public SidebarEntity getSidebarByPath(String path)
	{
		return sidebarDao.getByPath(path);
	}

	@Override
	public NavLinkEntity getNavLinkById(int id)
	{
		return navLinkDao.getById(id);
	}

	@Override
	public List<NavLinkEntity> getNavLinksByUrl(String url)
	{
		return navLinkDao.getByUrl(url);
	}

	@Override
	public List<NavLinkEntity> getNavLinksByName(String name)
	{
		return navLinkDao.getByName(name);
	}

	@Override
	public void save(GenericEntity entity) {
		sidebarDao.save(entity);
	}
}
