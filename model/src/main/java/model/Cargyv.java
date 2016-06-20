package model;

import java.awt.Point;

import contract.IHero;
import contract.IStrategy;

public class Cargyv implements IStrategy{
	
	/**
	 * it's a vector use for give a direction
	 */
	private Point direction;
	
	/**
	 * it's a vector use for give the last position
	 */
	private Point lastPos;
	
	/**
	 * this constructor initialize the direction at (1,1) and the last position at (0,0)
	 */
	public Cargyv(){
		direction = new Point(1, 1);
		lastPos = new Point(0, 0);
	}

	/**
	 * 
	 * this method move the demon
	 * @param positionDemon
	 * @param hero
	 * @return the new position of the demon
	 */
	public Point move(Point positionDemon, IHero hero) {
		if(lastPos.x == positionDemon.x-direction.x && lastPos.y == positionDemon.y-direction.y) { // if moved
			//
		} else if(lastPos.x == positionDemon.x-direction.x) {
			direction.y *= -1;
		} else {
			direction.x *= -1;
		}
		lastPos = new Point(positionDemon.x, positionDemon.y);
		return new Point(positionDemon.x+direction.x, positionDemon.y+direction.y);
	}

}
