package ba.beslic.persistence.daos.navigation.sidebar.impl;

import ba.beslic.persistence.daos.impl.GenericDaoImpl;
import ba.beslic.persistence.daos.navigation.sidebar.SidebarDao;
import ba.beslic.persistence.entities.navigation.sidebar.SidebarEntity;
import org.springframework.stereotype.Repository;


/**
 * Author:  Admir Memic
 * Date:    15.09.2015
 * E-Mail:  admir.memic@dmc.de
 */
@Repository("sidebarDao")
public class SidebarDaoImpl extends GenericDaoImpl<SidebarEntity> implements SidebarDao
{
	@Override
	public SidebarEntity getByPath(String path)
	{
		return (SidebarEntity) hibernateTemplate.find("from Sidebar where path = ?", path).get(0);
	}
}
