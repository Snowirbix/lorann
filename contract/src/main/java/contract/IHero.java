package contract;

import java.awt.Point;

public interface IHero {
	public void addOrder(ControllerOrder order);
	public void removeOrder(ControllerOrder order);
	public boolean isOrder(ControllerOrder order);
	public void setDirection(int x, int y);
	public void attack();
	public int getScore();
	public Point getPosition();
	public Point getDirection();
	public void setPreviousPosition(Point v);
}
