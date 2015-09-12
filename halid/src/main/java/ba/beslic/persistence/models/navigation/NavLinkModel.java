package ba.beslic.persistence.models.navigation;

import ba.beslic.persistence.models.GenericModel;

/**
 * Author: Admir Memić
 * Date:   12.09.2015
 */
public class NavLinkModel extends GenericModel {
	private String name;
	private String url;
	private int parentId;
	private String sidebarPath;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public int getParentId() {
		return parentId;
	}

	public void setParentId(int parentId) {
		this.parentId = parentId;
	}

	public String getSidebarPath() {
		return sidebarPath;
	}

	public void setSidebarPath(String sidebarPath) {
		this.sidebarPath = sidebarPath;
	}
}
