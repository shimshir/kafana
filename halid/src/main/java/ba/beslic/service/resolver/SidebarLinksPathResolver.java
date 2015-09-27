package ba.beslic.service.resolver;

import ba.beslic.presentation.data.navigation.NavLinkData;
import ba.beslic.presentation.data.navigation.sidebar.SidebarData;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Author:  Admir Memic
 * Date:    27.09.15
 * E-Mail:  admir.memic@dmc.de
 */
public class SidebarLinksPathResolver {

	public static void resolve(SidebarData sidebar, String path, String itemName) {
		Integer itemId = parsePathForId(path, "/" + itemName + "/");
		for (NavLinkData link : sidebar.getLinks()) {
			link.setUrl(link.getUrl().replace("{" + itemName + "Id}", String.valueOf(itemId)));
		}
	}

	private static Integer parsePathForId(String path, String itemRootPath) {
		Pattern pattern = Pattern.compile(itemRootPath + "\\d+");
		Matcher matcher = pattern.matcher(path);
		if (matcher.find()) {
			String matchedString = matcher.group(0);
			return Integer.valueOf(matchedString.substring(itemRootPath.length(), matchedString.length()));
		} else {
			// TODO: Log or handle
			return null;
		}
	}
}
