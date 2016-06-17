package model;

import java.awt.Point;
import java.util.ArrayList;

import contract.IMobile;
import contract.IModel;
import contract.ITouchable;
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
	}
	public boolean onTouch(IMobile activator) {
		if(activator instanceof Hero) {
			((Hero) activator).setFireBall(null);
			return true;
		} else if(activator instanceof Demons) {
			this.getModel().getMobiles().remove(activator);
		}
		return false;
	}
	public Point move() {
		super.move();
		if(!this.isMovePossible()) {
			this.direction = new Point(this.getDirection().x*-1, this.getDirection().y*-1); // bounce on walls
		}
		this.setCurrentSprite((this.getCurrentSprite()+1)%5); // change the sprite
		return this.getPosition();
	}
}
