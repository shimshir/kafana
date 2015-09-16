package ba.beslic.controllers.navigation;

import ba.beslic.persistence.daos.navigation.sidebar.SidebarDao;
import ba.beslic.persistence.entities.navigation.NavLinkEntity;
import ba.beslic.persistence.entities.navigation.sidebar.SidebarEntity;
import ba.beslic.services.navigation.NavigationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


/**
 * Author: Admir Memić
 * Date:   12.09.2015
 */
@RestController
@RequestMapping("/sidebar")
public class SidebarController {
	@Autowired
	private NavigationService navigationService;
	@Autowired
	private SidebarDao sidebarDao;

	@RequestMapping
	public SidebarEntity getNoSidebar() {
		SidebarEntity entity = new SidebarEntity();
		entity.setPath("/social");
		List<NavLinkEntity> links = new ArrayList<>();
		NavLinkEntity events = new NavLinkEntity();
		events.setUrl("/social/events");
		events.setName("Events");
		NavLinkEntity discussions = new NavLinkEntity();
		discussions.setUrl("/social/discussions");
		discussions.setName("Discussions");
		NavLinkEntity chat = new NavLinkEntity();
		chat.setUrl("/social/chat");
		chat.setName("Chat");
		links.add(events);
		links.add(discussions);
		links.add(chat);
		entity.setLinks(links);

		sidebarDao.save(entity);
		return null;
	}

	@RequestMapping(value = "/{path}")
	public SidebarEntity getSidebarByPath(@PathVariable String path) {
		return navigationService.getSidebarByPath("/" + path);
	}
}
