package model;

import java.awt.Point;
import java.util.ArrayList;

import contract.IMobile;
import contract.IModel;
import contract.ITouchable;
import contract.Permeability;
import contract.Sprite;

public class FireBall extends Mobile implements ITouchable {
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
	public boolean onTouch(IMobile activator) {
		if(activator instanceof Hero) {
			((Hero) activator).setFireBall(null);
			return true;
		}
		return false;
	}
	public Point move() {
		if(this.getDirection().x != 0 || this.getDirection().y != 0) {
			if(!this.isMovePossible(getPosition().x+getDirection().x, getPosition().y+getDirection().y)) {
				this.direction = new Point(this.getDirection().x*-1, this.getDirection().y*-1); // bounce on walls
			}
			this.position.x += this.direction.x;
			this.position.y += this.direction.y;
		}
		this.setCurrentSprite((this.getCurrentSprite()+1)%5); // change the sprite
		return this.getPosition();
	}
}
