package model;

import java.util.ArrayList;

import contract.IModel;
import contract.MotionLessElement;
import contract.Permeability;
import contract.Sprite;

public class VBone extends MotionLessElement {
	
	/**
	 * Instantiates a new bone vertical.
	 * Element Blocking.
	 * 
	 * @param model
	 * 
	 * @author Clément
	 */

	public VBone(IModel model) {
		super(model);
		ArrayList<Sprite> sprites = new ArrayList<Sprite>();
		sprites.add(new Sprite("vertical_bone.png"));
		this.setSprites(sprites);
		this.setPermeability(Permeability.BLOCKING);
	}

}
