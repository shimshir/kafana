package ba.beslic.persistence.models.navigation.sidebar;


import ba.beslic.persistence.models.GenericModel;
import ba.beslic.persistence.models.navigation.NavLinkModel;

import java.util.List;

/**
 * Author: Admir Memić
 * Date:   12.09.2015
 */
public class SidebarModel extends GenericModel {
	private String path;

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}
}
