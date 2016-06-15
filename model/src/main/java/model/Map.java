package model;

public class Map extends Entity {
	private int width;
	private int height;
	private String map;
	
	public Map(int width, int height, String map) {
		this.width = width;
		this.height = height;
		this.map = map;
	}
	
	public Map() {
		this(0, 0, "");
	}

	public String getMap() {
		return map;
	}
	public void setMap(String map) {
		this.map = map;
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

}
