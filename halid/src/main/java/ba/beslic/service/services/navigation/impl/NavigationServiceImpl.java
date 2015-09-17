package ba.beslic.service.services.navigation.impl;

import ba.beslic.persistence.daos.navigation.NavigationDao;
import ba.beslic.persistence.entities.IdentifiableEntity;
import ba.beslic.persistence.entities.navigation.NavLinkEntity;
import ba.beslic.persistence.entities.navigation.sidebar.SidebarEntity;
import ba.beslic.service.services.navigation.NavigationService;
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
public class NavigationServiceImpl implements NavigationService
{
	@Autowired
	private NavigationDao navigationDao;

	@Override
	public SidebarEntity getSidebarByIdDeep(int id)
	{
		return navigationDao.getById(SidebarEntity.class, id, SidebarEntity.FP_SIDEBAR_LINKS, NavLinkEntity.FP_NAVLINK_CHILDLINKS);
	}

	@Override
	public SidebarEntity getSidebarByPathDeep(String path)
	{
		return navigationDao.getSidebarByPath(path, SidebarEntity.FP_SIDEBAR_LINKS, NavLinkEntity.FP_NAVLINK_CHILDLINKS);
	}

	@Override
	public NavLinkEntity getNavLinkByIdDeep(int id)
	{
		return navigationDao.getById(NavLinkEntity.class, id, NavLinkEntity.FP_NAVLINK_CHILDLINKS);
	}

	@Override
	public List<NavLinkEntity> getNavLinksByUrlDeep(String url)
	{
		return navigationDao.getNavLinkByUrl(url, NavLinkEntity.FP_NAVLINK_CHILDLINKS);
	}

	@Override
	public List<NavLinkEntity> getNavLinksByNameDeep(String name)
	{
		return navigationDao.getNavLinkByName(name, NavLinkEntity.FP_NAVLINK_CHILDLINKS);
	}

	@Override
	public SidebarEntity getSidebarByIdShallow(int id)
	{
		return navigationDao.getById(SidebarEntity.class, id);
	}

	@Override
	public SidebarEntity getSidebarByPathShallow(String path)
	{
		return navigationDao.getSidebarByPath(path);
	}

	@Override
	public NavLinkEntity getNavLinkByIdShallow(int id)
	{
		return navigationDao.getById(NavLinkEntity.class, id);
	}

	@Override
	public List<NavLinkEntity> getNavLinksByUrlShallow(String url)
	{
		return navigationDao.getNavLinkByUrl(url);
	}

	@Override
	public List<NavLinkEntity> getNavLinksByNameShallow(String name)
	{
		return navigationDao.getNavLinkByName(name);
	}

	@Override
	public void save(IdentifiableEntity entity) {
		navigationDao.save(entity);
	}
}
