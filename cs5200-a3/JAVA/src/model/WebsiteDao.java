package model;
import entities.*;
import java.util.*;

public interface WebsiteDao {

	int createWebsiteForDeveloper(int developerId, Website website);
	Collection<Website> findAllWebsites();
	Collection<Website> findWebsitesForDeveloper(int developerId);
	Website findWebsiteById(int websiteId);
	int updateWebsite(int websiteId, Website website);
	int deleteWebsite(int websiteId);
}