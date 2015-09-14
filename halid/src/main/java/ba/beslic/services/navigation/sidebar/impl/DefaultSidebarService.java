package ba.beslic.services.navigation.sidebar.impl;

import ba.beslic.persistence.models.navigation.NavLinkModel;
import ba.beslic.persistence.models.navigation.sidebar.SidebarModel;
import ba.beslic.services.navigation.sidebar.SidebarService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


/**
 * Author: Admir Memić
 * Date:   12.09.2015
 */
@ComponentScan
@Service("sidebarService")
public class DefaultSidebarService implements SidebarService {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Collection<SidebarModel> query() {
		return null;
	}

	@Override
	public SidebarModel getById(Object id) {
		return null;
	}

	@Override
	public SidebarModel getByPath(String path) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		SidebarModel sidebar = new SidebarModel();
		sidebar.setPath(path);
		List<NavLinkModel> links = new ArrayList<>();
		NavLinkModel link1 = new NavLinkModel();
		link1.setName("Home");
		link1.setUrl("www.google.com");
		links.add(link1);

		NavLinkModel link2 = new NavLinkModel();
		link2.setName("Home");
		link2.setUrl("www.google.com");
		links.add(link2);

		sidebar.setLinks(links);
		session.save(sidebar);
		tx.commit();
		session.close();
		return null;
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
