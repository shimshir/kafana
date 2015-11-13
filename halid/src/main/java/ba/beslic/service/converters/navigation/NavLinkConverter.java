package ba.beslic.service.converters.navigation;

import ba.beslic.persistence.entities.navigation.NavLinkEntity;
import ba.beslic.service.converters.IdentifiableConverter;
import ba.beslic.presentation.data.navigation.NavLinkData;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;


/**
 * Author:  Admir Memic
 * Date:    17.09.2015
 * E-Mail:  admir.memic@dmc.de
 */
@Component("navLinkConverter")
public class NavLinkConverter extends IdentifiableConverter<NavLinkEntity, NavLinkData>
{
	@Override
	public NavLinkData convertToData(NavLinkEntity entity, NavLinkData data)
	{
		if (entity == null)
			return null;
		super.convertToData(entity, data);
		data.setUrl(entity.getUrl());
		data.setName(entity.getName());
		List<NavLinkData> dataChildLinks = entity.getChildLinks().stream().map
				(linkEntity -> convertToData(linkEntity, new NavLinkData())).collect(Collectors.toList());
		data.setChildLinks(dataChildLinks);
		return data;
	}

	@Override
	public NavLinkEntity convertToEntity(NavLinkData data, NavLinkEntity entity)
	{
		if (data == null)
			return null;
		entity.setUrl(data.getUrl());
		entity.setName(data.getName());
		List<NavLinkEntity> entityChildLinks = data.getChildLinks().stream().map
				(linkData -> convertToEntity(linkData, new NavLinkEntity())).collect(Collectors.toList());
		entity.setChildLinks(entityChildLinks);
		return entity;
	}
}
