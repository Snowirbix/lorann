package model;

import java.awt.Point;
import java.util.ArrayList;

import contract.*;

public class Map extends Entity {
	private int width;
	private int height;
	private String map;
	private ArrayList<IMobile> mobiles;
	
	/**
	 * Instantiates a new map.
	 * 
	 * @param width
	 * The width of the map.
	 * 
	 * @param height
	 * The height of the map.
	 * 
	 * @param map
	 * The map in String (TEXT).
	 * 
	 * @author Clément
	 */
	public Map(int width, int height, String map) {
		this.setWidth(width);
		this.setHeight(height);
		this.setMap(map);
		this.mobiles = new ArrayList<IMobile>();
	}
	
	/**
	 * Instantiates a new map with no parameter
	 */
	public Map() {
		this(0, 0, "");
	}

	/**
	 * To get the map
	 * @return the map
	 */
	public String getMap() {
		return map;
	}
	
	/**
	 * To set the map
	 * @param map
	 */
	public void setMap(String map) {
		this.map = map;
	}

	/**
	 * To get the width of the map
	 * @return the width (int)
	 */
	public int getWidth() {
		return width;
	}
	
	/**
	 * To set the width of the map
	 * @param width (int)
	 */
	public void setWidth(int width) {
		this.width = width;
	}

	/**
	 * To get the height of the map
	 * @return the height (int)
	 */
	public int getHeight() {
		return height;
	}
	
	/**
	 * To set the height of the map
	 * @param height (int)
	 */
	public void setHeight(int height) {
		this.height = height;
	}

	/**
	 * To draw the map
	 * @param model
	 * @see IModel
	 * @see MotionLessElement
	 * @return the map
	 */
	public MotionLessElement[][] getMapArray(IModel model) {
		MotionLessElement[][] mapArray =  new MotionLessElement[this.getWidth()][this.getHeight()];
		Gate gate = new Gate(model);
		for(int y = 0; y < this.getHeight(); y++) {
    	  for(int x = 0; x < this.getWidth(); x++) {
    		  switch(this.getMap().toCharArray()[x+(this.getWidth()+1)*y]) {
    		  	case 'L':
    		  		Hero hero = Hero.getInstance(model);
    		  		this.mobiles.add(hero);
    		  		hero.setPosition(x, y);
    		  		hero.setPreviousPosition(new Point(x-1, y));
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
