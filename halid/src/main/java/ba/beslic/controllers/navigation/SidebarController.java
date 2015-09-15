package ba.beslic.controllers.navigation;

import ba.beslic.persistence.entities.navigation.sidebar.SidebarEntity;
import ba.beslic.services.navigation.NavigationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Author: Admir Memić
 * Date:   12.09.2015
 */
@RestController
@RequestMapping("/sidebar")
public class SidebarController {
	@Autowired
	private NavigationService navigationService;

	@RequestMapping
	public SidebarEntity getNoSidebar() {
		return null;
	}

	@RequestMapping(value = "/{path}")
	public SidebarEntity getSidebarByPath(@PathVariable String path) {
		return navigationService.getSidebarByPath("/" + path);
	}
}
