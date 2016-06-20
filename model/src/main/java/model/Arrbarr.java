package model;

import java.awt.Point;

import contract.IHero;
import contract.IStrategy;

public class Arrbarr implements IStrategy {
	
	public Arrbarr(){
		
	}

	/**
	 * this method check if the hero is moving, and move the demon Arrbarr in consequence.
	 * 
	 * @return the new position of the Demon
	 */
	public Point move(Point positionDemon, IHero hero) {
		
		Point heroIsMoving = new Point(hero.getDirection().x, hero.getDirection().y);
		
		if(heroIsMoving.x != 0 || heroIsMoving.y != 0) {
			
			Point diff;
			Point dir;
			if(hero.getFireBall() != null) {
				diff = new Point(hero.getFireBall().getPosition().x-positionDemon.x, hero.getFireBall().getPosition().y-positionDemon.y);
				dir = hero.getFireBall().getDirection();
			} else {
				diff = new Point(0, 0);
				dir = new Point(0, 0); // avoid the dodge
			}
			
			if(diff.x < 3 && diff.x > 0 && dir.x == -1) {
				positionDemon.y++;
			} else if(diff.x > -3 && diff.x < 0 && dir.x == 1) {
				positionDemon.y--;
			} else if(diff.y < 3 && diff.y > 0 && dir.y == -1) {
				positionDemon.x++;
			} else if(diff.y > -3 && diff.y < 0 && dir.y == 1) {
				positionDemon.x--;
			} else {
				diff = new Point(hero.getPosition().x-positionDemon.x, hero.getPosition().y-positionDemon.y);
				
				if(Math.abs(diff.x) > Math.abs(diff.y)) {
					if(diff.x > 0) {
						positionDemon.x++;
					} else {
						positionDemon.x--;
					}
					if(diff.y > 0) {
						positionDemon.y++;
					} else if(diff.y < 0) {
						positionDemon.y--;
					}
				} else {
					if(diff.y > 0) {
						positionDemon.y++;
					} else {
						positionDemon.y--;
					}
					if(diff.x > 0) {
						positionDemon.x++;
					} else if(diff.x < 0) {
						positionDemon.x--;
					}
				}
			}
		}
		return positionDemon;
	}


}
