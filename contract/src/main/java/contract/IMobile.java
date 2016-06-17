package contract;

import java.awt.Image;
import java.awt.Point;

public interface IMobile {
	public Point move();
	
	public Image getImage();

	public Point getPosition();

	public Point getDirection();

	public void setDirection(int x, int y);

	public void setPosition(int x, int y);

	public Permeability getPermeability();
}
