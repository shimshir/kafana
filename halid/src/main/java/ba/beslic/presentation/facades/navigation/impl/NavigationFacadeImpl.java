package ba.beslic.presentation.facades.navigation.impl;

import ba.beslic.presentation.data.navigation.sidebar.SidebarData;
import ba.beslic.presentation.facades.navigation.NavigationFacade;
import ba.beslic.persistence.entities.navigation.sidebar.SidebarEntity;
import ba.beslic.service.converters.navigation.sidebar.SidebarConverter;
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
public class NavigationFacadeImpl implements NavigationFacade
{
	@Autowired
	private NavigationService navigationService;
	@Autowired
	private SidebarConverter sidebarConverter;

	@Override
	public SidebarData getSidebarByEncPath(String encodedPath)
	{
		String decodedPath = encodedPath.replace("_", "/");
		SidebarEntity sidebarEntity = null;
		while(decodedPath.length() > 0 && sidebarEntity == null)
		{
			sidebarEntity = navigationService.getSidebarByPathDeep(decodedPath);
			decodedPath = decodedPath.substring(0, decodedPath.lastIndexOf("/"));
		}
		return sidebarConverter.convertToData(sidebarEntity);
	}
}
