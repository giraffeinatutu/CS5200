package entities;
import java.util.Collection;

import entities.Widget;

public class Page {
	protected int id;
	protected String title;
	protected String description;
	protected String created;
	protected String updated;
	protected int views;
	protected int website_id;

	public Page() {
		
	}
	
	
	Collection<Widget> widgets;
	
	boolean addWidget(Widget w) {
		return widgets.add(w);	
	}
	
	boolean removeWidget(Widget w) {
		return widgets.remove(w);
	}

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCreated() {
		return created;
	}

	public void setCreated(String created) {
		this.created = created;
	}

	public String getUpdated() {
		return updated;
	}

	public void setUpdated(String updated) {
		this.updated = updated;
	}

	public int getViews() {
		return views;
	}

	public void setViews(int views) {
		this.views = views;
	}

	public int getWebsite_id() {
		return website_id;
	}

	public void setWebsite_id(int website_id) {
		this.website_id = website_id;
	}
}
