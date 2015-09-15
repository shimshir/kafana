package ba.beslic.persistence.daos.navigation.impl;

import ba.beslic.persistence.daos.impl.GenericDaoImpl;
import ba.beslic.persistence.daos.navigation.NavLinkDao;
import ba.beslic.persistence.entities.navigation.NavLinkEntity;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * Author:  Admir Memic
 * Date:    15.09.2015
 * E-Mail:  admir.memic@dmc.de
 */
@Repository("navLinkDao")
public class NavLinkDaoImpl extends GenericDaoImpl<NavLinkEntity> implements NavLinkDao
{
	@Override
	public List<NavLinkEntity> getByUrl(String url)
	{
		return (List<NavLinkEntity>) hibernateTemplate.find("from NavLink where url = ?", url);
	}

	@Override
	public List<NavLinkEntity> getByName(String name)
	{
		return (List<NavLinkEntity>) hibernateTemplate.find("from NavLink where name = ?", name);
	}
}
