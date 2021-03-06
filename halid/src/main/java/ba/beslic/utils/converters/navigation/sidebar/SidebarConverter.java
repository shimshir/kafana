package ba.beslic.utils.converters.navigation.sidebar;

import ba.beslic.models.persistence.navigation.NavLinkEntity;
import ba.beslic.models.persistence.navigation.sidebar.SidebarEntity;
import ba.beslic.utils.converters.IdentifiableConverter;
import ba.beslic.utils.converters.navigation.NavLinkConverter;
import ba.beslic.models.presentation.navigation.NavLinkData;
import ba.beslic.models.presentation.navigation.sidebar.SidebarData;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


/**
 * Author:  Admir Memic
 * Date:    17.09.2015
 * E-Mail:  admir.memic@dmc.de
 */
@Component("sidebarConverter")
public class SidebarConverter extends IdentifiableConverter<SidebarEntity, SidebarData> {
	@Autowired
	private NavLinkConverter navLinkConverter;

	@Override
	public SidebarData convertToData(SidebarEntity entity, SidebarData data) {
		if (entity == null)
			return null;
		super.convertToData(entity, data);
		data.setPath(entity.getPath());
		if (CollectionUtils.isNotEmpty(entity.getLinks())) {
			data.setLinks(entity.getLinks().stream().map(linkEntity ->
					navLinkConverter.convertToData(linkEntity, new NavLinkData())).collect(Collectors.toList()));
		}
		return data;
	}

	@Override
	public SidebarEntity convertToEntity(SidebarData data, SidebarEntity entity) {
		if (data == null)
			return null;
		super.convertToEntity(data, entity);
		entity.setPath(data.getPath());
		if (CollectionUtils.isNotEmpty(data.getLinks())) {
			entity.setLinks(data.getLinks().stream().map(linkData ->
					navLinkConverter.convertToEntity(linkData, new NavLinkEntity())).collect(Collectors.toSet()));
		}
		return entity;
	}


}
