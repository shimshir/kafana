package ba.beslic.persistence.daos.navigation;

import ba.beslic.persistence.daos.GenericDao;
import ba.beslic.persistence.entities.navigation.NavLinkEntity;

import java.util.List;


/**
 * Author:  Admir Memic
 * Date:    15.09.2015
 * E-Mail:  admir.memic@dmc.de
 */
public interface NavLinkDao extends GenericDao<NavLinkEntity>
{
	List<NavLinkEntity> getByUrl(String url);
	List<NavLinkEntity> getByName(String name);
}
