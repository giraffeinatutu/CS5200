package model;

public interface RoleDao {
	public void assignWebsiteRole(int developerId, int websiteId, String roleId);
	public void assignPageRole(int developerId, int pageId, String roleId);
	public void deleteWebsiteRole(int developerId, int websiteId, String roleId);
	public void deletePageRole(int developerId, int pageId, String roleId);
}
