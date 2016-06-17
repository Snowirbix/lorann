package model;

import java.awt.Point;

import contract.IHero;
import contract.IStrategy;

public class Kyracj implements IStrategy{
	
	private int lastCase;
	private boolean state;

	public Kyracj(){
		this.lastCase = 0;
		this.state = true;
	}

	public Point move(Point positionDemon, IHero hero) {
		int randomNumber;
		if(this.state) {
			randomNumber = this.lastCase;
		} else {
			randomNumber = 1 + (int)(Math.random() * (5 - 1));
			this.lastCase = randomNumber;
		}
		this.state = !state;
		
		switch(randomNumber){
		case 1:
			positionDemon.x = positionDemon.x + 1;
			positionDemon.y = positionDemon.y + 1;
			return positionDemon;
		case 2:
			positionDemon.x = positionDemon.x + 1;
			positionDemon.y = positionDemon.y - 1;
			return positionDemon;
		case 3:
			positionDemon.x = positionDemon.x - 1;
			positionDemon.y = positionDemon.y + 1;
			return positionDemon;
		case 4: 
			positionDemon.x = positionDemon.x - 1;
			positionDemon.y = positionDemon.y - 1;
			return positionDemon;
		default:
			return positionDemon;
		}
	}
	

}
