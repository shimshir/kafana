package ba.beslic.persistence.daos.navigation.sidebar.impl;

import ba.beslic.persistence.daos.impl.GenericDaoImpl;
import ba.beslic.persistence.daos.navigation.sidebar.SidebarDao;
import ba.beslic.persistence.entities.navigation.NavLinkEntity;
import ba.beslic.persistence.entities.navigation.sidebar.SidebarEntity;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;


/**
 * Author:  Admir Memic
 * Date:    15.09.2015
 * E-Mail:  admir.memic@dmc.de
 */
@Repository("sidebarDao")
public class SidebarDaoImpl extends GenericDaoImpl<SidebarEntity> implements SidebarDao
{
	@Override
	public void init()
	{
		this.clazz = SidebarEntity.class;
	}

	@Override
	public SidebarEntity getByPath(String path)
	{
		Map<String, Object> params = new HashMap<>();
		params.put("path", path);
		return find(params, SidebarEntity.FP_SIDEBAR_LINKS, NavLinkEntity.FP_NAVLINK_CHILDLINKS).get(0);
	}
}
