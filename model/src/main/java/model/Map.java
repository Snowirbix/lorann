package model;

import java.util.ArrayList;

import contract.Hero;
import contract.IMobile;
import contract.IModel;
import contract.Land;
import contract.MotionLessElement;

public class Map extends Entity {
	private int width;
	private int height;
	private String map;
	private ArrayList<IMobile> mobiles;
	
	public Map(int width, int height, String map) {
		this.setWidth(width);
		this.setHeight(height);
		this.setMap(map);
		this.mobiles = new ArrayList<IMobile>();
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

	public MotionLessElement[][] getMapArray(IModel model) {
		MotionLessElement[][] mapArray =  new MotionLessElement[this.getWidth()][this.getHeight()];
		for(int y = 0; y < this.getHeight(); y++) {
    	  for(int x = 0; x < this.getWidth(); x++) {
    		  switch(this.getMap().toCharArray()[x+(this.getWidth()+1)*y]) {
    		  	case 'X':
    		  		this.mobiles.add(new Hero(model));
    		  		mapArray[x][y] = new Land(model);
    		  		break;
    		  	default:
    		  		mapArray[x][y] = new Land(model);
    		  }
    	  }
      }
		return mapArray;
	}
	public ArrayList<IMobile> getMobiles() {
		return this.mobiles;
	}
}
