package model;

import java.awt.Image;
import java.awt.Point;

import contract.IHero;
import contract.IMobile;
import contract.IStrategy;
import contract.Mobile;

public class Maarcg implements IStrategy{
	
	public Maarcg(){
		
		
	}

	public Point move(Point positionDemon, Model model) {
		//Point positionHero = this.getModel().getMobiles().get(0);
		
		return positionDemon;
	}

	public Point move(Point positionDemon, IHero hero) {
		return positionDemon;
	}


}
