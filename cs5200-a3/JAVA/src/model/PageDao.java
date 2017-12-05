package model;
import entities.*;
import java.util.*;

public interface PageDao {
	int createPageForWebsite(int websiteId, Page page);
	Collection<Page> findAllPages();
	Collection<Page> findPageById(int pageId);
	Collection<Page> findPagesForWebsite(int websiteId);
	int updatePage(int pageId, Page page);
	int deletePage(int pageId);
}
