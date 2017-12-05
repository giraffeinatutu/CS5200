package model;

import java.sql.SQLException;

import utils.ConnectMe;

public class RoleDaoImp implements RoleDao 
{
	public void assignWebsiteRole(int developerId, int websiteId, String roleId){
		try {
			String ASSIGN_WEB_ROLE = "INSERT INTO WebsiteRole (developer_id, website_id, "
					+ "role) VALUES (?,?,?)";
			ConnectMe m = ConnectMe.getThing();
			m.pstmt = m.conn.prepareStatement(ASSIGN_WEB_ROLE);
			m.pstmt.setInt(1, developerId);
			m.pstmt.setInt(2, websiteId);
			m.pstmt.setString(3, roleId);
			m.pstmt.executeUpdate();
			m.pstmt.close();
			m.conn.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void assignPageRole(int developerId, int pageId, String roleId) {
		try {
			String ASSIGN_PAGE_ROLE = "INSERT INTO PageRole (developer_id, page_id, role) "
					+ "VALUES (?,?,?)";
			ConnectMe m = ConnectMe.getThing();
			m.pstmt = m.conn.prepareStatement(ASSIGN_PAGE_ROLE);
			m.pstmt.setInt(1, developerId);
			m.pstmt.setInt(2, pageId);
			m.pstmt.setString(3, roleId);
			m.pstmt.executeUpdate();
			m.pstmt.close();
			m.conn.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}		
	}
	
	public void deleteWebsiteRole(int developerId, int websiteId, String roleId) {
		try {
			String DELETE_WEB_ROLE = "DELETE FROM WebsiteRole where developer_id = ?, "
					+ "website_id = ?, role = ?";
			ConnectMe m = ConnectMe.getThing();
			m.pstmt = m.conn.prepareStatement(DELETE_WEB_ROLE);
			m.pstmt.setInt(1, developerId);
			m.pstmt.setInt(2, websiteId);
			m.pstmt.setString(3, roleId);		 
			int rowsDeleted = m.pstmt.executeUpdate();
			if (rowsDeleted > 0) {
			    System.out.println("A user was deleted successfully!");
			m.pstmt.close();
			m.conn.close();
			}			
		} catch (SQLException e) {
			e.printStackTrace();
			}
		}
	
	
	public void deletePageRole(int developerId, int pageId, String roleId) {
		try {
			String DELETE_PAGE_ROLE = "DELETE FROM PageRole where developer_id = ?, "
					+ "page_id = ?, role = ?";
			ConnectMe m = ConnectMe.getThing();
			m.pstmt = m.conn.prepareStatement(DELETE_PAGE_ROLE);
			m.pstmt.setInt(1, developerId);
			m.pstmt.setInt(2, pageId);
			m.pstmt.setString(3, roleId);		 
			int rowsDeleted = m.pstmt.executeUpdate();
			if (rowsDeleted > 0) {
			    System.out.println("A user was deleted successfully!");
			m.pstmt.close();
			m.conn.close();
			}			
		} catch (SQLException e) {
			e.printStackTrace();
			}	
	}
}
