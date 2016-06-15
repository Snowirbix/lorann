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
	
	public Point move() {
		return this.position;
	}

	public void setPosition(int x, int y) {
		this.position = new Point(x, y);
	}
}
