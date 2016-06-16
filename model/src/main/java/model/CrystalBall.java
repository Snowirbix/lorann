package model;

import java.util.ArrayList;

import contract.IMobile;
import contract.IModel;
import contract.ITouchable;
import contract.Mobile;
import contract.Sprite;

public class CrystalBall extends Mobile implements ITouchable {
	private Gate gate;
	
	public CrystalBall(IModel model, Gate gate, int x, int y) {
		super(model, x, y);
		ArrayList<Sprite> sprites = new ArrayList<Sprite>();
		sprites.add(new Sprite("crystal_ball.png"));
		this.setSprites(sprites);
		this.gate = gate; // composition
	}
	
	public boolean onTouch(IMobile activator) {
		if(activator instanceof Hero) { // check that the mobile is the hero
			this.gate.open(); // when the hero get this ball, he opens the gate
			return true; // remove the ball
		}
		return false;
	}
}
