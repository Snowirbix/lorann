package model;

import java.awt.Point;

public class Mobile extends Element implements IMobile {
	private Point position;
	private Point direction;
	
	public Mobile() {
		this.position = new Point(0,0);
		this.direction = new Point(0,0);
	}

	public Point getPosition() {
		return position;
	}
	public void setPosition(Point position) {
		this.position = position;
	}

	public Point getDirection() {
		return direction;
	}
	public void setDirection(Point direction) {
		this.direction = direction;
	}
	
	public Point move() {
		return this.position;
	}
}
