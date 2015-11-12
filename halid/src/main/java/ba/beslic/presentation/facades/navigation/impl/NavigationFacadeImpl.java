package ba.beslic.presentation.facades.navigation.impl;

import ba.beslic.presentation.data.navigation.sidebar.SidebarData;
import ba.beslic.presentation.facades.navigation.NavigationFacade;
import ba.beslic.persistence.entities.navigation.sidebar.SidebarEntity;
import ba.beslic.service.converters.navigation.sidebar.SidebarConverter;
import ba.beslic.service.resolver.SidebarLinksPathResolver;
import ba.beslic.service.services.navigation.NavigationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;


/**
 * Author:  Admir Memic
 * Date:    17.09.2015
 * E-Mail:  admir.memic@dmc.de
 */
@Component("navigationFacade")
@Transactional
public class NavigationFacadeImpl implements NavigationFacade {
	@Autowired
	private NavigationService navigationService;
	@Autowired
	private SidebarConverter sidebarConverter;

	@Override
	public SidebarData getSidebarByEncPath(String encodedPath) {
		String decodedPath = encodedPath.replace("~", "/");
		SidebarEntity sidebarEntity = null;
		while (decodedPath.length() > 0) {
			sidebarEntity = navigationService.getSidebarByPath(decodedPath);
			if (sidebarEntity != null)
				break;
			decodedPath = decodedPath.substring(0, decodedPath.lastIndexOf("/"));
		}
		SidebarData sidebarData = sidebarConverter.convertToData(sidebarEntity, new SidebarData());
		resolveItemIdsInLinkPaths(sidebarData, encodedPath.replace("~", "/"));
		return sidebarData;
	}

	private void resolveItemIdsInLinkPaths(SidebarData sidebarData, String decodedPath) {
		if (decodedPath.startsWith("/academic/course/"))
			SidebarLinksPathResolver.resolve(sidebarData, decodedPath, "course");
		else if (decodedPath.startsWith("/academic/exam/"))
			SidebarLinksPathResolver.resolve(sidebarData, decodedPath, "exam");
		else if (decodedPath.startsWith("/academic/staff/"))
			SidebarLinksPathResolver.resolve(sidebarData, decodedPath, "staff");
		else if (decodedPath.startsWith("/academic/student/"))
			SidebarLinksPathResolver.resolve(sidebarData, decodedPath, "student");
		else if (decodedPath.startsWith("/academic/group/"))
			SidebarLinksPathResolver.resolve(sidebarData, decodedPath, "group");
	}
}
