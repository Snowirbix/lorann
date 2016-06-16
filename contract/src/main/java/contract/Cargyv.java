package contract;

import java.awt.Image;
import java.awt.Point;

public class Cargyv implements IStrategy{
	
	public Cargyv(){
		
	}

	public Point move(Point positionDemon) {
		int randomNumber = 1 + (int)((Math.random()) * (9 - 1));
		System.out.println(randomNumber);
		switch(randomNumber){
		case 1:
			positionDemon.x = positionDemon.x + 1;
			return positionDemon;
		
		case 2:
			positionDemon.x = positionDemon.x - 1;
			return positionDemon;
		
		case 3:
			positionDemon.y = positionDemon.y + 1;
			return positionDemon;
		
		case 4:
			positionDemon.y = positionDemon.y - 1;
			return positionDemon;
		case 5:
			positionDemon.x = positionDemon.x + 1;
			positionDemon.y = positionDemon.y + 1;
			return positionDemon;
		case 6:
			positionDemon.x = positionDemon.x - 1;
			positionDemon.y = positionDemon.y - 1;
		case 7:
			positionDemon.x = positionDemon.x + 1;
			positionDemon.y = positionDemon.y - 1;
		case 8:
			positionDemon.x = positionDemon.x - 1;
			positionDemon.y = positionDemon.y + 1;
		default:
			return positionDemon;
		}
	}

}
