package model;

import java.util.ArrayList;

import contract.IMobile;
import contract.IModel;
import contract.ITouchable;
import contract.MotionLessElement;
import contract.Permeability;
import contract.Sprite;

public class CrystalBall extends MotionLessElement implements ITouchable {
	/**
	 * this attribute is a gate, we need it for open the gate
	 * @see Gate
	 */
	private Gate gate;
	
	/**
	 * this constructor build a new CrystalBall, it adds 2 sprites because the CrystalBall is on earth, it initializes the permability at penetrable
	 * @param model
	 * @param gate
	 */
	public CrystalBall(IModel model, Gate gate) {
		super(model);
		ArrayList<Sprite> sprites = new ArrayList<Sprite>();
		sprites.add(new Sprite("crystal_ball.png"));
		sprites.add(new Sprite("earth.png"));
		this.setSprites(sprites);
		this.setPermeability(Permeability.PENETRABLE);
		this.gate = gate; // composition
	}
	
	/**
	 * this method check if the mobile is the hero, when the hero get this ball, he opens the gate
	 * @param activator
	 * @return false when it doesn't delete the CrystalBall
	 */
	public boolean onTouch(IMobile activator) {
		if(activator instanceof Hero) { // check that the mobile is the hero
			this.gate.open(); // when the hero get this ball, he opens the gate
			this.setCurrentSprite(1);
		}
		return false;
	}
}
