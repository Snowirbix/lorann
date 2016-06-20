package model;

import java.util.ArrayList;

import contract.IModel;
import contract.MotionLessElement;
import contract.Permeability;
import contract.Sprite;

public class HBone extends MotionLessElement {

	
	/**
	 * Instantiates a new bone horizontal.
	 * Element Blocking.
	 * 
	 * @param model
	 * 
	 * @author Clément
	 */
	public HBone(IModel model) {
		super(model);
		ArrayList<Sprite> sprites = new ArrayList<Sprite>();
		sprites.add(new Sprite("horizontal_bone.png"));
		this.setSprites(sprites);
		this.setPermeability(Permeability.BLOCKING);
	}

}
