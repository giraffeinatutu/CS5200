package entities;

public class YouTubeWidget extends Widget {
	private int id;
	private String url;
	private boolean shareable;
	private boolean expandable;
	
	public YouTubeWidget() {
		
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public boolean getShareable() {
		return shareable;
	}

	public void setShareable( boolean shareable ) {
		this.shareable = shareable;
	}

	public boolean getExpandable() {
		return expandable;
	}

	public void setExpandable( boolean expandable ) {
		this.expandable = expandable;
	}

}
