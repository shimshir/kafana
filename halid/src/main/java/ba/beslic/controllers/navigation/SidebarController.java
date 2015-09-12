package ba.beslic.controllers.navigation;

import ba.beslic.persistence.models.navigation.sidebar.SidebarModel;
import ba.beslic.services.navigation.sidebar.SidebarService;
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
	private SidebarService sidebarService;

	@RequestMapping(value = "/{path}")
	public SidebarModel getSidebarLinks(@PathVariable String path) {
		return sidebarService.getByPath("/" + path);
	}
}
