package ba.beslic.facades.navigation.impl;

import ba.beslic.models.presentation.navigation.sidebar.SidebarData;
import ba.beslic.facades.navigation.NavigationFacade;
import ba.beslic.models.persistence.navigation.sidebar.SidebarEntity;
import ba.beslic.utils.converters.navigation.sidebar.SidebarConverter;
import ba.beslic.utils.resolver.SidebarLinksPathResolver;
import ba.beslic.services.navigation.NavigationService;
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

	@Override
	public SidebarData createSidebar(SidebarData sidebarData) {
		SidebarEntity sidebarEntity = new SidebarEntity();
		sidebarConverter.convertToEntity(sidebarData, sidebarEntity);
		navigationService.createSidebar(sidebarEntity);
		return sidebarConverter.convertToData(sidebarEntity, new SidebarData());
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
