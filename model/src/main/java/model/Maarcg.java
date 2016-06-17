package model;

import java.awt.Point;

import contract.IHero;
import contract.IStrategy;

public class Maarcg implements IStrategy{
	
	public Maarcg(){
		
		
	}

	public Point move(Point positionDemon, IHero hero) {
		Point heroIsMoving = new Point(hero.getDirection().x, hero.getDirection().y);
		
		if(heroIsMoving.x != 0 || heroIsMoving.y != 0){
			
			double random = Math.random();
			double dist = (int) positionDemon.distance(hero.getPosition());
			
			if(random > 1/dist) {
				Point diff = new Point(hero.getPosition().x-positionDemon.x, hero.getPosition().y-positionDemon.y);
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
			} else {
				int randomNumber = 1 + (int)((Math.random()) * (9 - 1));
				switch(randomNumber){
				case 1:
					positionDemon.x = positionDemon.x + 1;
					break;
				
				case 2:
					positionDemon.x = positionDemon.x - 1;
					break;
				
				case 3:
					positionDemon.y = positionDemon.y + 1;
					break;
				
				case 4:
					positionDemon.y = positionDemon.y - 1;
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
			}
		}
		
		return positionDemon;
	}


}
