package ba.beslic.controllers.navigation;

import ba.beslic.models.presentation.navigation.sidebar.SidebarData;
import ba.beslic.facades.navigation.NavigationFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * Author: Admir Memić
 * Date:   12.09.2015
 */
@RestController
@RequestMapping("/navigation")
public class NavigationController {
	@Autowired
	private NavigationFacade navigationFacade;

	@RequestMapping(path = "/sidebar")
	public SidebarData getNoSidebar() {
		return null;
	}

	@RequestMapping(path = "/sidebar/{encodedPath}")
	public SidebarData getSidebarByPath(@PathVariable String encodedPath) {
		return navigationFacade.getSidebarByEncPath(encodedPath);
	}

	@RequestMapping(path = "/sidebar", method = RequestMethod.POST)
	public SidebarData createSidebar(@RequestBody SidebarData sidebarData) {
		return navigationFacade.createSidebar(sidebarData);
	}
}
