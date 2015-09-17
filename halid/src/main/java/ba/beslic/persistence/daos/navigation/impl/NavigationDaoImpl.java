package ba.beslic.persistence.daos.navigation.impl;

import ba.beslic.persistence.daos.impl.DaoImpl;
import ba.beslic.persistence.daos.navigation.NavigationDao;
import ba.beslic.persistence.entities.navigation.NavLinkEntity;
import ba.beslic.persistence.entities.navigation.sidebar.SidebarEntity;
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
	public List<NavLinkEntity> getNavLinkByUrl(String url, String... fetchProfiles)
	{
		Map<String, Object> params = new HashMap<>();
		params.put("url", url);
		return find(NavLinkEntity.class, params, fetchProfiles);
	}

	@Override
	public List<NavLinkEntity> getNavLinkByName(String name, String... fetchProfiles)
	{
		Map<String, Object> params = new HashMap<>();
		params.put("name", name);
		return find(NavLinkEntity.class, params, fetchProfiles);
	}

	@Override
	public SidebarEntity getSidebarByPath(String path, String... fetchProfiles)
	{
		Map<String, Object> params = new HashMap<>();
		params.put("path", path);
		return findUnique(SidebarEntity.class, params, fetchProfiles);
	}
}
