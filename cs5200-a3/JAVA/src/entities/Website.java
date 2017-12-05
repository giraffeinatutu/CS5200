package entities;
import java.util.Collection;

public class Website {
	private int id;
	private String name;
	private String description;
	private String created;
	private String updated;
	private int visits;
	Collection<Page> pages;

	// use optional boolean to give result if succeed
	boolean addPage(Page p) {
		return pages.add(p);	
	}

	// use optional boolean to give result if succeed
	boolean removePage(Page p) {
		return pages.remove(p);
	}

	public Website () {
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public int getVisits() {
		return visits;
	}

	public void setVisits(int visits) {
		this.visits = visits;
	}
	
	public String toString() {
//		return this.id+","+this.name+","+this.description;
		return this.name;
	}
}