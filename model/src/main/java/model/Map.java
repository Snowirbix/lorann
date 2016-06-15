package model;

import java.util.ArrayList;

public class Map extends Entity {
	private int width;
	private int height;
	private String map;
	private ArrayList<IMobile> mobiles;
	
	public Map(int width, int height, String map) {
		this.setWidth(width);
		this.setHeight(height);
		this.setMap(map);
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

	public MotionLessElement[][] getMapArray() {
		MotionLessElement[][] mapArray =  new MotionLessElement[this.getWidth()][this.getHeight()];

		for(int y = 0; y < this.getHeight(); y++) {
    	  for(int x = 0; x < this.getWidth(); x++) {
    		  switch(this.getMap().toCharArray()[x+this.getHeight()*y]) {
    		  	case 'L':
    		  		this.mobiles.add(new Hero());
    		  		mapArray[x][y] = new Land();
    		  		break;
    		  	default:
    		  		mapArray[x][y] = new Land();
    		  }
    	  }
      }
		return mapArray;
	}
	public ArrayList<IMobile> getMobiles() {
		return this.mobiles;
	}
}
