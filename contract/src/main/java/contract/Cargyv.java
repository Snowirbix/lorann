package contract;

import java.awt.Image;
import java.awt.Point;

public class Cargyv extends Mobile implements IMobile{
	
	public Cargyv(){
		
	}

	public Point move() {
		int nombreAleatoire = 1 + (int)((Math.random()) * (9 - 1));
		System.out.println(nombreAleatoire);
		return null;
	}

	public Image getImage() {
		// TODO Auto-generated method stub
		return null;
	}

	public Point getPosition() {
		// TODO Auto-generated method stub
		return null;
	}

	public Point getDirection() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setDirection(int x, int y) {
		// TODO Auto-generated method stub
		
	}

	public void setPosition(int x, int y) {
		// TODO Auto-generated method stub
		
	}

}
