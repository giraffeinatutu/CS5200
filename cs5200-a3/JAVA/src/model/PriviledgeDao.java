package model;

public interface PriviledgeDao {
	
	public void assignWebsitePriviledge(int developerId, int websiteId, String priviledgeId);
	public void assignPagePriviledge(int developerId, int pageId, String priviledgeId);
	public void deleteWebsitePriviledge(int developerId, int websiteId, String priviledgeId);
	public void deletePagePriviledge(int developerId, int pageId, String priviledgeId);

}
