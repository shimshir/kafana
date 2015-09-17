package ba.beslic.service.converters.navigation;

import ba.beslic.persistence.entities.navigation.NavLinkEntity;
import ba.beslic.service.converters.Converter;
import ba.beslic.presentation.data.navigation.NavLinkData;
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
@Component("navLinkConverter")
public class NavLinkConverter implements Converter<NavLinkEntity, NavLinkData>
{
	@Override
	public NavLinkData convertToData(NavLinkEntity entity)
	{
		NavLinkData data = new NavLinkData();
		data.setUrl(entity.getUrl());
		data.setName(entity.getName());
		List<NavLinkEntity> sortedEntityChildLinks = new ArrayList<>();
		sortedEntityChildLinks.addAll(entity.getChildLinks());
		Collections.sort(sortedEntityChildLinks,
				(childLink1, childLink2) -> childLink1.getDisplayPriority() - childLink2.getDisplayPriority());
		List<NavLinkData> dataChildLinks = sortedEntityChildLinks.stream().map(this::convertToData).collect(Collectors.toList());
		data.setChildLinks(dataChildLinks);
		return data;
	}

	@Override
	public NavLinkEntity convertToEntity(NavLinkData data)
	{
		NavLinkEntity entity = new NavLinkEntity();
		entity.setUrl(data.getUrl());
		entity.setName(data.getName());
		Set<NavLinkEntity> entityChildLinks = data.getChildLinks().stream().map(this::convertToEntity).collect(Collectors.toSet());
		entity.setChildLinks(entityChildLinks);
		return entity;
	}
}
