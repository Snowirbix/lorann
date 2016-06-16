package model;

import java.util.ArrayList;

import contract.IMobile;
import contract.IModel;
import contract.ITouchable;
import contract.Mobile;
import contract.Sprite;

public class Purse extends Mobile implements ITouchable {

	public Purse(IModel model, int x, int y) {
		super(model, x, y);
		ArrayList<Sprite> sprites = new ArrayList<Sprite>();
		sprites.add(new Sprite("purse.png"));
		this.setSprites(sprites);
	}

	public boolean onTouch(IMobile activator) {
		if(activator instanceof Hero) {
			((Hero) activator).setScore(10);
		}
		return false;
	}
}
