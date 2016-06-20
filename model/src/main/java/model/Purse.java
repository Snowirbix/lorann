package model;

import java.awt.Point;
import java.util.ArrayList;

import contract.IMobile;
import contract.IModel;
import contract.ITouchable;
import contract.Sprite;

public class Purse extends Mobile implements ITouchable {

	/**
	 * Instantiates a new Purse.
	 * @param model
	 * @see IModel
	 * @param x 
	 * coordinate x of the purse (int)
	 * @param y
	 * coordinate y of the purse (int)
	 */
	public Purse(IModel model, int x, int y) {
		super(model, x, y);
		ArrayList<Sprite> sprites = new ArrayList<Sprite>();
		sprites.add(new Sprite("purse.png"));
		this.setSprites(sprites);
	}

	/**
	 * If the purse is touch
	 * @return if is touch by hero it earn 10 points and return true
	 * else return false
	 */
	public boolean onTouch(IMobile activator) {
		if(activator instanceof Hero) {
			((Hero) activator).setScore(10);
			return true;
		}
		return false;
	}


	public Point move() {
		return getPosition();
	}
}
