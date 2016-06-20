package model;

import java.awt.Point;
import java.util.ArrayList;

import contract.IHero;
import contract.IMobile;
import contract.IModel;
import contract.ITouchable;
import contract.Permeability;
import contract.Sprite;

public class FireBall extends Mobile implements ITouchable {
	/**
	 * This Constructor adds the different sprites of the fireball in a list and set the direction of the fireball
	 * @param model
	 * @param x
	 * @param y
	 * @param _x
	 * @param _y
	 */
	public FireBall(IModel model, int x, int y, int _x, int _y) {
		super(model, x, y);
		ArrayList<Sprite> sprites = new ArrayList<Sprite>();
		sprites.add(new Sprite("fireball_1.png"));
		sprites.add(new Sprite("fireball_2.png"));
		sprites.add(new Sprite("fireball_3.png"));
		sprites.add(new Sprite("fireball_4.png"));
		sprites.add(new Sprite("fireball_5.png"));
		this.setSprites(sprites);
		this.setDirection(_x - x, _y - y);
		this.setPermeability(Permeability.PENETRABLE);
	}
	
	/**
	 * this method check if the fireball touch something
	 * @param activator
	 * @return false if the fireball touch nothing, true if the fireball is on the hero
	 */
	public boolean onTouch(IMobile activator) {
		if(activator instanceof Hero) {
			((Hero) activator).setFireBall(null);
			return true;
		} else if(activator instanceof Demons) {
			this.getModel().getMobiles().remove(activator);
			((IHero) this.getModel().getMobiles().get(0)).setScore(20);
			((IHero) this.getModel().getMobiles().get(0)).disengage();
		}
		return false;
	}
	
	/**
	 * this method move the firaball according to the direction
	 * @return the position of the fireball
	 */
	public Point move() {
		if(this.getDirection().x != 0 || this.getDirection().y != 0) {
			if(!this.isMovePossible(getPosition().x+getDirection().x, getPosition().y+getDirection().y)) {
				this.direction.x *= -1;
				this.direction.y *= -1;
			}
			this.position.x += this.direction.x;
			this.position.y += this.direction.y;
		}
		this.setCurrentSprite((this.getCurrentSprite()+1)%5); // change the sprite
		return this.getPosition();
	}
}
