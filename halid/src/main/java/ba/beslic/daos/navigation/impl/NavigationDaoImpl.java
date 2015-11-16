package ba.beslic.daos.navigation.impl;

import ba.beslic.daos.navigation.NavigationDao;
import ba.beslic.daos.impl.DaoImpl;
import ba.beslic.models.persistence.navigation.NavLinkEntity;
import ba.beslic.models.persistence.navigation.sidebar.SidebarEntity;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Author:  Admir Memic
 * Date:    17.09.2015
 * E-Mail:  admir.memic@dmc.de
 */
@Repository("navigationDao")
public class NavigationDaoImpl extends DaoImpl implements NavigationDao
{
	@Override
	public List<NavLinkEntity> getNavLinkByUrl(String url)
	{
		Map<String, Object> params = new HashMap<>();
		params.put("url", url);
		return find(NavLinkEntity.class, params);
	}

	@Override
	public List<NavLinkEntity> getNavLinkByName(String name)
	{
		Map<String, Object> params = new HashMap<>();
		params.put("name", name);
		return find(NavLinkEntity.class, params);
	}

	@Override
	public SidebarEntity getSidebarByPath(String path)
	{
		Map<String, Object> params = new HashMap<>();
		params.put("path", path);
		return findUnique(SidebarEntity.class, params);
	}
}
