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
	
	
	/**
	 * Instantiates a new Gate.
	 * 
	 * @param model
	 * 
	 * @author Clément
	 */
	public Gate(IModel model) {
		super(model);
		ArrayList<Sprite> sprites = new ArrayList<Sprite>();
		sprites.add(new Sprite("gate_closed.png"));
		sprites.add(new Sprite("gate_open.png"));
		this.setSprites(sprites);
		this.setPermeability(Permeability.PENETRABLE);
		//this.open();
	}

	/**
	 * To open the gate, is the gate is open the hero can win
	 *  
	 * @author Clément
	 */
	
	public void open() {
		this.state = true;
		this.setCurrentSprite(1);
	}
	
	/**
	 * To get the state of the gate
	 *  
	 * @return the state of the gate (Open or close)
	 *  
	 * @author Clément
	 */
	public boolean getState() {
		return this.state;
	}
	
	
	/**
	 * When someone touch the gate
	 *  
	 * @return false if the gate is touch by other thing that hero 
	 * if the hero touch the gate and it open he win else it lose.
	 *  
	 * @author Clément
	 */
	public boolean onTouch(IMobile activator) {
		if(activator instanceof Hero && getState()) {
			this.getModel().win();
		} else if(activator instanceof Hero) {
			this.getModel().lose();
		}
		return false;
	}
}
