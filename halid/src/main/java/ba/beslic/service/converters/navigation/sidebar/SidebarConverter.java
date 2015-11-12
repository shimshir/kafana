package ba.beslic.service.converters.navigation.sidebar;

import ba.beslic.persistence.entities.navigation.NavLinkEntity;
import ba.beslic.persistence.entities.navigation.sidebar.SidebarEntity;
import ba.beslic.service.converters.Converter;
import ba.beslic.service.converters.navigation.NavLinkConverter;
import ba.beslic.presentation.data.navigation.NavLinkData;
import ba.beslic.presentation.data.navigation.sidebar.SidebarData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


/**
 * Author:  Admir Memic
 * Date:    17.09.2015
 * E-Mail:  admir.memic@dmc.de
 */
@Component("sidebarConverter")
public class SidebarConverter implements Converter<SidebarEntity, SidebarData> {
	@Autowired
	private NavLinkConverter navLinkConverter;

	@Override
	public SidebarData convertToData(SidebarEntity entity, SidebarData data) {
		if (entity != null) {
			data.setPath(entity.getPath());
			List<NavLinkData> dataLinks = entity.getLinks().stream().map(linkEntity -> navLinkConverter.convertToData
					(linkEntity, new NavLinkData())).collect(Collectors.toList());
			data.setLinks(dataLinks);
			return data;
		} else {
			return null;
		}
	}

	@Override
	public SidebarEntity convertToEntity(SidebarData data, SidebarEntity entity) {
		entity.setPath(data.getPath());
		Set<NavLinkEntity> entityLinks = data.getLinks().stream().map(linkData -> navLinkConverter.convertToEntity
				(linkData, new NavLinkEntity())).collect(Collectors.toSet());
		entity.setLinks(entityLinks);
		return entity;
	}


}
