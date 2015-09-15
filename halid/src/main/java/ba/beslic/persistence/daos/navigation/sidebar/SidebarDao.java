package ba.beslic.persistence.daos.navigation.sidebar;

import ba.beslic.persistence.daos.GenericDao;
import ba.beslic.persistence.entities.navigation.sidebar.SidebarEntity;


/**
 * Author:  Admir Memic
 * Date:    15.09.2015
 * E-Mail:  admir.memic@dmc.de
 */
public interface SidebarDao extends GenericDao<SidebarEntity>
{
	SidebarEntity getByPath(String path);
}
