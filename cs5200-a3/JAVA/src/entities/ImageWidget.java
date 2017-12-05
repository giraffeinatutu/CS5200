package entities;
public class ImageWidget extends Widget {
	private int id;
	private String src;
	
	public ImageWidget() {
	
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSrc() {
		return src;
	}

	public void setSrc( String src ) {
		this.src = src;
	}

}
