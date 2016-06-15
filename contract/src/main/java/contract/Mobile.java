package contract;

import java.awt.Point;

public class Mobile extends Element implements IMobile {
	private Point position;
	private Point direction;
	
	public Mobile(IModel model, int x, int y) {
		super(model);
		this.position = new Point(x, y);
		this.direction = new Point(0, 0);
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
	public void setDirection(int x, int y) {
		this.direction.x += x;
		this.direction.y += y;
	}
	
	public boolean isMovePossible() {
		Point newPosition = new Point(this.getPosition().x+this.getDirection().x, this.getPosition().y+this.getDirection().y);
		return (this.getModel().getMap()[newPosition.x][newPosition.y].getPermeability() != Permeability.BLOCKING);
	}
	
	public Point move() {
		if(this.isMovePossible()) {
			this.position.x += this.direction.x;
			this.position.y += this.direction.y;
		}
		
		return this.position;
	}

	public void setPosition(int x, int y) {
		this.position = new Point(x, y);
	}
}
