package ba.beslic.persistence.mappers.sidebar;

import ba.beslic.persistence.models.navigation.sidebar.SidebarModel;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Author: Admir Memić
 * Date:   12.09.2015
 */
public class SidebarMapper implements RowMapper<SidebarModel> {
	@Override
	public SidebarModel mapRow(ResultSet rs, int rowNum) throws SQLException {
		SidebarModel sidebarModel = new SidebarModel();
		sidebarModel.setId(rs.getInt("id"));
		sidebarModel.setPath(rs.getString("path"));
		return sidebarModel;
	}
}
