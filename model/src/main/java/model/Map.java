package model;

import java.awt.Point;
import java.util.ArrayList;

import contract.*;

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
		Gate gate = new Gate(model);
		this.mobiles.add(new Hero(model));
		for(int y = 0; y < this.getHeight(); y++) {
    	  for(int x = 0; x < this.getWidth(); x++) {
    		  switch(this.getMap().toCharArray()[x+(this.getWidth()+1)*y]) {
    		  	case 'L':
    		  		this.mobiles.get(0).setPosition(x, y);
    		  		((Hero) this.mobiles.get(0)).setPreviousPosition(new Point(x-1, y));
    		  		mapArray[x][y] = new Land(model);
    		  		break;
    		  	case 'H':
    		  		mapArray[x][y] = new HBone(model);
    		  		break;
    		  	case 'V':
    		  		mapArray[x][y] = new VBone(model);
    		  		break;
    		  	case 'B':
    		  		mapArray[x][y] = new Bone(model);
    		  		break;
    		  	case 'G':
    		  		mapArray[x][y] = gate;
    		  		break;
    		  	case 'C':
    		  		mapArray[x][y] = new CrystalBall(model, gate);
    		  		break;
    		  	case 'P':
    		  		this.mobiles.add(new Purse(model, x, y));
    		  		mapArray[x][y] = new Land(model);
    		  		break;
    		  	case 'W':
    		  		this.mobiles.add(new Demons(model,x,y,(IStrategy)new Cargyv()));
    		  		mapArray[x][y] = new Land(model);
    		  		break;
    		  	case 'Z':
    		  		this.mobiles.add(new Demons(model,x,y,(IStrategy)new Arrbarr()));
    		  		mapArray[x][y] = new Land(model);
    		  		break;
    		  	case 'M':
    		  		this.mobiles.add(new Demons(model, x, y, (IStrategy)new Maarcg()));
    		  		mapArray[x][y] = new Land(model);
    		  		break;
    		  	case 'K':
    		  		this.mobiles.add(new Demons(model, x, y, (IStrategy) new Kyracj()));
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
