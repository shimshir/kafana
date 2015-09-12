package ba.beslic.persistence.mappers.sidebar;

import ba.beslic.persistence.models.navigation.sidebar.SidebarNavLinkModel;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Author: Admir Memić
 * Date:   12.09.2015
 */
public class SidebarNavLinkMapper implements RowMapper<SidebarNavLinkModel> {
	@Override
	public SidebarNavLinkModel mapRow(ResultSet rs, int rowNum) throws SQLException {
		SidebarNavLinkModel sidebarNavLinkModel = new SidebarNavLinkModel();
		sidebarNavLinkModel.setId(rs.getInt("id"));
		sidebarNavLinkModel.setName(rs.getString("name"));
		sidebarNavLinkModel.setUrl(rs.getString("url"));
		sidebarNavLinkModel.setParentId(rs.getInt("parent_id"));
		sidebarNavLinkModel.setSidebarPath(rs.getString("sidebar_path"));
		return sidebarNavLinkModel;
	}
}