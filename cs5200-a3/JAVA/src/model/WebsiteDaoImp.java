package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.LinkedList;

import entities.Website;
import utils.ConnectMe;

public class WebsiteDaoImp implements WebsiteDao {

	
	public int createWebsiteForDeveloper(int developerId, Website website) {
		int i = developerId;
		Website site = new Website();

		try {
			String ADD_WEB = "INSERT into Website (name, description, created, updated, "
					+ "visits) VALUES (?,?,?,?,?)";
			ConnectMe m = ConnectMe.getThing();
			m.pstmt = m.conn.prepareStatement(ADD_WEB);
			m.pstmt.setString(1, site.getName());
			m.pstmt.setString(2, site.getDescription());
			m.pstmt.setString(3, site.getCreated());
			m.pstmt.setString(4, site.getUpdated());			
			m.pstmt.setInt(5, site.getVisits());
			m.pstmt.executeUpdate();
			
			String SITE_NAME = "SELECT id FROM Website WHERE name = ?";
			PreparedStatement pst = m.conn.prepareStatement(SITE_NAME);
			pst.setString(1, site.getName());
			
			ResultSet rs = pst.executeQuery();
			System.out.println(rs);
			int ID = 0;
			while(rs.next()) {
				 ID = rs.getInt(1);
				System.out.println(ID);
			}

			RoleDaoImp p = new model.RoleDaoImp();
			p.assignWebsiteRole(i, ID, "owner");
			m.pstmt.executeUpdate();
			m.pstmt.close();
			m.conn.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public int createWebsite(Website site) {
		Website w = new Website();

		try {
			String ADD_WEB = "INSERT into Website (name, description, created, updated, "
					+ "visits) VALUES (?,?,?,?,?)";
			ConnectMe m = ConnectMe.getThing();
			m.pstmt = m.conn.prepareStatement(ADD_WEB);
			m.pstmt.setString(1, site.getName());
			m.pstmt.setString(2, site.getDescription());
			m.pstmt.setString(3, site.getCreated());
			m.pstmt.setString(4, site.getUpdated());			
			m.pstmt.setInt(5, site.getVisits());
			m.pstmt.executeQuery();
			m.pstmt.close();
			m.conn.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return 0;
	}

	// ENCONTRAR-WEB
	// SQL:
	// SELECT * FROM Website;
	//
	public Collection<Website> findAllWebsites() {
		final String FIND_ALL_WEB = "SELECT * FROM Website;";
		Collection<Website> sites = new LinkedList<Website>();
		try {
			ConnectMe m = ConnectMe.getThing();
			m.pstmt = m.conn.prepareStatement(FIND_ALL_WEB);
			ResultSet rs = m.pstmt.executeQuery();
			while (rs.next()) {
				Website w = new Website();
				w.setId(rs.getInt("id"));
				w.setName(rs.getString("name"));
				w.setDescription(rs.getString("description"));
				w.setCreated(rs.getString("created"));
				w.setUpdated(rs.getString("updated"));
				w.setVisits(rs.getInt("visits"));
				sites.add(w);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return sites;
	}

	// ENCONTRAR-WEB-DEV
	// SQL:
	// SELECT * FROM Website w JOIN WebsiteRole r
	// WHERE r.website_id = w.id AND r.developer_Id = 12;
	//
	public Collection<Website> findWebsitesForDeveloper(int developerId) {
		int i = developerId;
		final String FIND_ALL_WEBDEV = "SELECT * FROM Website w " + "JOIN WebsiteRole r  WHERE r.website_id = w.id "
				+ "AND r.developer_Id = ?;";
		Collection<Website> sites = new LinkedList<Website>();
		try {
			ConnectMe m = ConnectMe.getThing();
			m.pstmt = m.conn.prepareStatement(FIND_ALL_WEBDEV);
			m.pstmt.setInt(1, i);
			ResultSet rs = m.pstmt.executeQuery();
			Website w = new Website();
			w.setId(rs.getInt("id"));
			w.setName(rs.getString("name"));
			w.setDescription(rs.getString("description"));
			w.setCreated(rs.getString("created"));
			w.setUpdated(rs.getString("updated"));
			w.setVisits(rs.getInt("visits"));
			sites.add(w);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return sites;
	}

	// ENCONTRAR-WEB-ID
	// SQL:
	// SELECT * FROM Website WHERE id = 12;
	//
	public Website findWebsiteById(int websiteId) {
		int i = websiteId;
		Website w = new Website();
		final String FIND_ALL_WEBID = "SELECT * FROM Website WHERE website_id = ?";
		try {
			ConnectMe m = ConnectMe.getThing();
			m.pstmt = m.conn.prepareStatement(FIND_ALL_WEBID);
			m.pstmt.setInt(1, i);
			ResultSet rs = m.pstmt.executeQuery();
			w.setId(rs.getInt("id"));
			w.setName(rs.getString("name"));
			w.setDescription(rs.getString("description"));
			w.setCreated(rs.getString("created"));
			w.setUpdated(rs.getString("updated"));
			w.setVisits(rs.getInt("visits"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return w;
	}

	// ENCONTRAR-WEB-ID
	// SQL:
	// SELECT * FROM Website WHERE id = 12;
	//
	public int updateWebsite(int websiteId, Website website) {
		int i = websiteId;
		Website w = new Website();

		try {
			String UPDATE_WEB = "UPDATE Website SET id = ?, name = ?, description = ?,"
					+ "created = ?, updated = ?, visits = ?) WHERE id = ?";
			ConnectMe m = ConnectMe.getThing();
			m.pstmt = m.conn.prepareStatement(UPDATE_WEB);
			m.pstmt.setInt(1, i);
			m.pstmt.setObject(2, w);
			m.pstmt.executeQuery();
			m.pstmt.close();
			m.conn.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;

	}

	// BORRAR-WEB
	// SQL:
	// DELETE FROM Website WHERE id=1
	//
	public int deleteWebsite(int websiteId) {
		try {
			String DELETE_WEB = "DELETE FROM Website where id=?";
			ConnectMe m = ConnectMe.getThing();
			m.pstmt = m.conn.prepareStatement(DELETE_WEB);
			m.pstmt.setInt(1, websiteId);

			int rowsDeleted = m.pstmt.executeUpdate();
			if (rowsDeleted > 0) {
				System.out.println("A website was deleted successfully!");

				m.pstmt.close();
				m.conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

}
