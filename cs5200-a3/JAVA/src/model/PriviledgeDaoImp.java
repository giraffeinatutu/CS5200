package model;

import java.sql.SQLException;

import utils.ConnectMe;

public class PriviledgeDaoImp implements PriviledgeDao {

	public void assignWebsitePriviledge(int developerId, int websiteId, String priviledgeId) {
		try {
			String ASSIGN_WEB_PRIVILEDGE = "INSERT INTO WebsitePriviledge (developer_id, website_id, priviledge) VALUES (?,?,?)";
			ConnectMe m = ConnectMe.getThing();
			m.pstmt = m.conn.prepareStatement(ASSIGN_WEB_PRIVILEDGE);
			m.pstmt.setInt(1, developerId);
			m.pstmt.setInt(2, websiteId);
			m.pstmt.setString(3, priviledgeId);
			int rowsAdded = m.pstmt.executeUpdate();
			if (rowsAdded > 0) {
				System.out.println("Priviledge was added successfully!");
				m.pstmt.close();
				m.conn.close();
				m.conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void assignPagePriviledge(int developerId, int pageId, String priviledgeId) {
		try {
			String ASSIGN_PAGE_PRIVILEDGE = "INSERT INTO PagePriviledge (developer_id, page_id, priviledge) VALUES (?,?,?)";
			ConnectMe m = ConnectMe.getThing();
			m.pstmt = m.conn.prepareStatement(ASSIGN_PAGE_PRIVILEDGE);
			m.pstmt.setInt(1, developerId);
			m.pstmt.setInt(2, pageId);
			m.pstmt.setString(3, priviledgeId);
			int rowsAdded = m.pstmt.executeUpdate();
			if (rowsAdded > 0) {
				System.out.println("Priviledge was added successfully!");
				m.pstmt.close();
				m.conn.close();
				m.conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void deleteWebsitePriviledge(int developerId, int websiteId, String priviledgeId) {
		try {
			String DELETE_WEB_PRIVILEDGE = "DELETE FROM WebsitePriviledge where developer_id = ?, website_id = ?, priviledge = ?";
			ConnectMe m = ConnectMe.getThing();
			m.pstmt = m.conn.prepareStatement(DELETE_WEB_PRIVILEDGE);
			m.pstmt.setInt(1, developerId);
			m.pstmt.setInt(2, websiteId);
			m.pstmt.setString(3, priviledgeId);
			int rowsDeleted = m.pstmt.executeUpdate();
			if (rowsDeleted > 0) {
				System.out.println("Priviledge was deleted successfully!");
				m.pstmt.close();
				m.conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void deletePagePriviledge(int developerId, int pageId, String priviledgeId) {
		try {
			String DELETE_PAGE_PRIVILEDGE = "DELETE FROM PagePriviledge where developer_id = ?, page_id = ?, priviledge = ?";
			ConnectMe m = ConnectMe.getThing();
			m.pstmt = m.conn.prepareStatement(DELETE_PAGE_PRIVILEDGE);
			m.pstmt.setInt(1, developerId);
			m.pstmt.setInt(2, pageId);
			m.pstmt.setString(3, priviledgeId);
			int rowsDeleted = m.pstmt.executeUpdate();
			if (rowsDeleted > 0) {
				System.out.println("Priviledge was deleted successfully!");
				m.pstmt.close();
				m.conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
