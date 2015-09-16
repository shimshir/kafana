package ba.beslic.persistence.daos.navigation.impl;

import ba.beslic.persistence.daos.impl.GenericDaoImpl;
import ba.beslic.persistence.daos.navigation.NavLinkDao;
import ba.beslic.persistence.entities.navigation.NavLinkEntity;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Author:  Admir Memic
 * Date:    15.09.2015
 * E-Mail:  admir.memic@dmc.de
 */
@Repository("navLinkDao")
public class NavLinkDaoImpl extends GenericDaoImpl<NavLinkEntity> implements NavLinkDao
{
	@Override
	protected void init()
	{
		this.clazz = NavLinkEntity.class;
	}

	@Override
	public List<NavLinkEntity> getByUrl(String url)
	{
		Map<String, Object> params = new HashMap<>();
		params.put("url", url);
		return find(params, NavLinkEntity.FP_NAVLINK_CHILDLINKS);
	}

	@Override
	public List<NavLinkEntity> getByName(String name)
	{
		Map<String, Object> params = new HashMap<>();
		params.put("name", name);
		return find(params, NavLinkEntity.FP_NAVLINK_CHILDLINKS);
	}
}
