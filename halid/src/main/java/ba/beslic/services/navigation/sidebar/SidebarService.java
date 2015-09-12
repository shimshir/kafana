package ba.beslic.services.navigation.sidebar;

import ba.beslic.persistence.models.navigation.sidebar.SidebarModel;

import ba.beslic.services.GenericService;

/**
 * Author: Admir Memić
 * Date:   12.09.2015
 */

public interface SidebarService extends GenericService<SidebarModel> {
	SidebarModel getByPath(String path);
}
