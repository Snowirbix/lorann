package model;

import java.awt.Point;
import java.util.ArrayList;

import contract.IMobile;
import contract.IModel;
import contract.ITouchable;
import contract.MotionLessElement;
import contract.Permeability;
import contract.Sprite;

public class CrystalBall extends MotionLessElement implements ITouchable {
	private Gate gate;
	
	public CrystalBall(IModel model, Gate gate) {
		super(model);
		ArrayList<Sprite> sprites = new ArrayList<Sprite>();
		sprites.add(new Sprite("crystal_ball.png"));
		sprites.add(new Sprite("earth.png"));
		this.setSprites(sprites);
		this.setPermeability(Permeability.PENETRABLE);
		this.gate = gate; // composition
	}
	
	public boolean onTouch(IMobile activator) {
		if(activator instanceof Hero) { // check that the mobile is the hero
			this.gate.open(); // when the hero get this ball, he opens the gate
			this.setCurrentSprite(1);
		}
		return false;
	}
}
