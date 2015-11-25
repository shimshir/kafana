package ba.beslic.utils.converters.navigation;

import ba.beslic.models.persistence.navigation.NavLinkEntity;
import ba.beslic.utils.converters.IdentifiableConverter;
import ba.beslic.models.presentation.navigation.NavLinkData;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;


/**
 * Author:  Admir Memic
 * Date:    17.09.2015
 * E-Mail:  admir.memic@dmc.de
 */
@Component("navLinkConverter")
public class NavLinkConverter extends IdentifiableConverter<NavLinkEntity, NavLinkData> {
	@Override
	public NavLinkData convertToData(NavLinkEntity entity, NavLinkData data) {
		if (entity == null)
			return null;
		super.convertToData(entity, data);
		data.setUrl(entity.getUrl());
		data.setName(entity.getName());
		if (CollectionUtils.isNotEmpty(entity.getChildLinks())) {
			data.setChildLinks(entity.getChildLinks().stream().map(linkEntity ->
					convertToData(linkEntity, new NavLinkData())).collect(Collectors.toList()));
		}
		return data;
	}

	@Override
	public NavLinkEntity convertToEntity(NavLinkData data, NavLinkEntity entity) {
		if (data == null)
			return null;
		super.convertToEntity(data, entity);
		entity.setUrl(data.getUrl());
		entity.setName(data.getName());
		if (CollectionUtils.isNotEmpty(data.getChildLinks())) {
			entity.setChildLinks(data.getChildLinks().stream().map(linkData ->
					convertToEntity(linkData, new NavLinkEntity())).collect(Collectors.toList()));
		}
		return entity;
	}
}
