package model;

import java.util.ArrayList;

import contract.IMobile;
import contract.IModel;
import contract.ITouchable;
import contract.MotionLessElement;
import contract.Permeability;
import contract.Sprite;

public class Gate extends MotionLessElement implements ITouchable {
	private boolean state = false;
	
	public Gate(IModel model) {
		super(model, 'G');
		ArrayList<Sprite> sprites = new ArrayList<Sprite>();
		sprites.add(new Sprite("gate_closed.png"));
		sprites.add(new Sprite("gate_open.png"));
		this.setSprites(sprites);
		this.setPermeability(Permeability.PENETRABLE);
		//this.open();
	}

	public void open() {
		this.state = true;
		this.setCurrentSprite(1);
	}
	public boolean getState() {
		return this.state;
	}
	
	public boolean onTouch(IMobile activator) {
		if(activator instanceof Hero && getState()) {
			this.getModel().win();
			return true;
		} else if(activator instanceof Hero) {
			this.getModel().lose();
		}
		return false;
	}
}
