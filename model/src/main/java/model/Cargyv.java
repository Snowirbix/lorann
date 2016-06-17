package model;

import java.awt.Point;

import contract.IHero;
import contract.IStrategy;

public class Cargyv implements IStrategy{
	
	public Cargyv(){
		
	}

	public Point move(Point positionDemon, IHero hero) {
		int randomNumber = 1 + (int)((Math.random()) * (9 - 1));
		switch(randomNumber){
		case 1:
			positionDemon.x = positionDemon.x + 2;
			break;
		
		case 2:
			positionDemon.x = positionDemon.x - 2;
			break;
		
		case 3:
			positionDemon.y = positionDemon.y + 2;
			break;
		
		case 4:
			positionDemon.y = positionDemon.y - 2;
			break;
		case 5:
			positionDemon.x = positionDemon.x + 1;
			positionDemon.y = positionDemon.y + 1;
			break;
		case 6:
			positionDemon.x = positionDemon.x - 1;
			positionDemon.y = positionDemon.y - 1;
			break;
		case 7:
			positionDemon.x = positionDemon.x + 1;
			positionDemon.y = positionDemon.y - 1;
			break;
		case 8:
			positionDemon.x = positionDemon.x - 1;
			positionDemon.y = positionDemon.y + 1;
			break;
		default:
		}
		return positionDemon;
	}

}
