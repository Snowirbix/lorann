package model;

import java.awt.Point;

import contract.Element;
import contract.IMobile;
import contract.IModel;
import contract.Permeability;

public abstract class Mobile extends Element implements IMobile {
	protected Point position;
	protected Point direction;
	
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
		for(int i = this.getModel().getMobiles().size()-1; i >= 0; i--) {
			IMobile mobile = this.getModel().getMobiles().get(i);
			if(mobile.getPosition().distance(newPosition) == 0.0 && mobile.getPermeability() == Permeability.BLOCKING) {
				return false;
			}
		}
		return (this.getModel().getMap()[newPosition.x][newPosition.y].getPermeability() != Permeability.BLOCKING);
	}

	/*public boolean isMovePossibleX() {
		Point newPosition = new Point(this.getPosition().x+this.getDirection().x, this.getPosition().y);
		return (this.getModel().getMap()[newPosition.x][newPosition.y].getPermeability() != Permeability.BLOCKING);
	}
	
	public boolean isMovePossibleY() {
		Point newPosition = new Point(this.getPosition().x, this.getPosition().y+this.getDirection().y);
		return (this.getModel().getMap()[newPosition.x][newPosition.y].getPermeability() != Permeability.BLOCKING);
	}*/
	
	public abstract Point move();

	public void setPosition(int x, int y) {
		this.position = new Point(x, y);
	}
}
