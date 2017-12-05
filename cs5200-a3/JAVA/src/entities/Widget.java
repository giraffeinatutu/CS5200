package entities;


public class Widget {
	protected int id;
	protected String name;
	protected int width;
	protected int height;
	protected String cssClass;
	protected String cssStyle;
	protected String text;
	protected int order;
	protected String type;
	protected int page_id;
	
	public Widget() {
		super();
	}

	public Widget(int id, String name, int width, int height, String cclass,
			String cstyle, String text, int order, String type, int page_id) {
		super();
		this.id = id;
		this.name = name;
		this.width = width;
		this.height = height;
		this.cssClass = cclass;
		this.cssStyle = cstyle;
		this.text = text;
		this.order = order;
		this.type = type;
		this.page_id = page_id;
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

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public String getCssclass() {
		return cssClass;
	}

	public void setCssclass(String cssClass) {
		this.cssClass = cssClass;
	}

	public String getCssstyle() {
		return cssStyle;
	}

	public void setCssstyle(String cssStyle) {
		this.cssStyle = cssStyle;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public int getOrder() {
		return order;
	}

	public void setOrder(int order) {
		this.order = order;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	public int getPage_id() {
		return page_id;
	}

	public void setPage_id(int page_id) {
		this.page_id = page_id;
	}
}
