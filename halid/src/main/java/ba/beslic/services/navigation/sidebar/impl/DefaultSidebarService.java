package ba.beslic.services.navigation.sidebar.impl;

import ba.beslic.persistence.mappers.sidebar.SidebarMapper;
import ba.beslic.persistence.models.navigation.sidebar.SidebarModel;
import ba.beslic.services.navigation.sidebar.SidebarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.Collection;

/**
 * Author: Admir Memić
 * Date:   12.09.2015
 */
@ComponentScan
@Service("sidebarService")
public class DefaultSidebarService implements SidebarService {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public Collection<SidebarModel> query() {
		return null;
	}

	@Override
	public SidebarModel getById(Object id) {
		String sql = "SELECT * FROM sidebar WHERE id = ?";
		return jdbcTemplate.queryForObject(sql, new Object[] {id}, new SidebarMapper());
	}

	@Override
	public SidebarModel getByPath(String path) {
		String sql = "SELECT * FROM sidebar WHERE path = ?";
		return jdbcTemplate.queryForObject(sql, new Object[] {path}, new SidebarMapper());
	}

	@Override
	public void create(SidebarModel sidebarModel) {

	}

	@Override
	public void update(SidebarModel sidebarModel) {

	}

	@Override
	public void delete(Object id) {

	}
}
