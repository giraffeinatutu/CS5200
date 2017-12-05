package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.LinkedList;

import entities.Page;
import utils.*;


public class PageDaoImp implements PageDao {

	// ENCONTRAR-WEB
	// SQL:
	// SELECT * FROM Website;
	//
	public int createPageForWebsite(int websiteId, Page page) {

		final String CREATE_PAGE = "INSERT INTO Page (id = ?, title = ?, description = ?,"
				+ " created= ? updated = ?, views = ?, website_id = ?;";
		Collection<Page> pages = new LinkedList<Page>();
		try {
			ConnectMe m = ConnectMe.getThing();
			m.pstmt = m.conn.prepareStatement(CREATE_PAGE);
			ResultSet rs = m.pstmt.executeQuery();
			Page p = new Page();
			p.setId(rs.getInt("id"));
			p.setTitle(rs.getString("title"));
			p.setDescription(rs.getString("description"));
			p.setCreated(rs.getString("created"));
			p.setUpdated(rs.getString("updated"));
			p.setViews(rs.getInt("views"));
			p.setWebsite_id(rs.getInt("website_id"));
			pages.add(p);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	// ENCONTRAR-PAGE
	// SQL:
	// SELECT * FROM Page;
	//
	public Collection<Page> findAllPages() {
		final String FIND_ALL_PAGE = "SELECT * FROM Page;";
		Collection<Page> pages = new LinkedList<Page>();
		try {
			ConnectMe m = ConnectMe.getThing();
			m.pstmt = m.conn.prepareStatement(FIND_ALL_PAGE);
			ResultSet rs = m.pstmt.executeQuery();
			Page p = new Page();
			p.setId(rs.getInt("id"));
			p.setTitle(rs.getString("title"));
			p.setDescription(rs.getString("description"));
			p.setCreated(rs.getString("created"));
			p.setUpdated(rs.getString("updated"));
			p.setViews(rs.getInt("views"));
			p.setWebsite_id(rs.getInt("website_id"));
			pages.add(p);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pages;
	}

	// ENCONTRAR-PAGE-ID
	// SQL:
	// SELECT * FROM Page WHERE id = ?;
	//
	public Collection<Page> findPageById(int pageId) {
		int i = pageId;
		final String FIND_ALL_PAGE = "SELECT * FROM Page WHERE id = ?;";
		Collection<Page> pages = new LinkedList<Page>();
		try {
			ConnectMe m = ConnectMe.getThing();
			m.pstmt = m.conn.prepareStatement(FIND_ALL_PAGE);
			m.pstmt.setInt(1, i);
			ResultSet rs = m.pstmt.executeQuery();
			Page p = new Page();
			p.setId(rs.getInt("id"));
			p.setTitle(rs.getString("title"));
			p.setDescription(rs.getString("description"));
			p.setCreated(rs.getString("created"));
			p.setUpdated(rs.getString("updated"));
			p.setViews(rs.getInt("views"));
			p.setWebsite_id(rs.getInt("website_id"));
			pages.add(p);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pages;
	}

	// ENCONTRAR-PAGE-WEB
	// SQL:
	// SELECT * FROM Page WHERE id = ?;
	//
	public Collection<Page> findPagesForWebsite(int websiteId) {
		int i = websiteId;
		final String FIND_ALL_PAGE = "SELECT * FROM Page WHERE website_id = ?;";
		Collection<Page> pages = new LinkedList<Page>();
		try {
			ConnectMe m = ConnectMe.getThing();
			m.pstmt = m.conn.prepareStatement(FIND_ALL_PAGE);
			m.pstmt.setInt(1, i);
			ResultSet rs = m.pstmt.executeQuery();
			Page p = new Page();
			p.setId(rs.getInt("id"));
			p.setTitle(rs.getString("title"));
			p.setDescription(rs.getString("description"));
			p.setCreated(rs.getString("created"));
			p.setUpdated(rs.getString("updated"));
			p.setViews(rs.getInt("views"));
			p.setWebsite_id(rs.getInt("website_id"));
			pages.add(p);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pages;
	}

	
	// ACTUALIZAR-PAGE
	// SQL:
	// UPDATE `hw2_riley_caitlin_fall_2017`.`Page` SET
	// id = 1, title = riley, description = null, created = null, updated = null,
	// website_id = 1 WHERE id = 1;
	//
	public int updatePage(int pageId, Page page) {
		int i = pageId;
		Page p = new Page();
		
		try {
			String UPDATE_WEB = "UPDATE Page SET id = ?, title = ?, description = ?,"
					+ "created = ?, updated = ?, visits = ?) WHERE id = ?";
			ConnectMe m = ConnectMe.getThing();
			m.pstmt = m.conn.prepareStatement(UPDATE_WEB);
			m.pstmt.setInt(1, i);
			m.pstmt.setObject(2, p);
			m.pstmt.executeQuery();
			m.pstmt.close();
			m.conn.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	

	// BORRAR-PAGE
	// SQL:
	// DELETE FROM Page WHERE id=1
	//
	public int deletePage(int pageId) {
		try {
			String DELETE_PAGE = "DELETE FROM Page where id=?";
			ConnectMe m = ConnectMe.getThing();
			m.pstmt = m.conn.prepareStatement(DELETE_PAGE);
			m.pstmt.setInt(1, pageId);

			int rowsDeleted = m.pstmt.executeUpdate();
			if (rowsDeleted > 0) {
				System.out.println("A page was deleted successfully!");

				m.pstmt.close();
				m.conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
}
