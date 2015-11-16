package ba.beslic.controllers.navigation;

import ba.beslic.models.presentation.navigation.sidebar.SidebarData;
import ba.beslic.facades.navigation.NavigationFacade;
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
	private NavigationFacade navigationFacade;

	@RequestMapping
	public SidebarData getNoSidebar() {
		return null;
	}

	@RequestMapping(path = "/{encodedPath}")
	public SidebarData getSidebarByPath(@PathVariable String encodedPath) {
		return navigationFacade.getSidebarByEncPath(encodedPath);
	}
}
