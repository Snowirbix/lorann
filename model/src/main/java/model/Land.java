package model;

import java.util.ArrayList;

import contract.IModel;
import contract.MotionLessElement;
import contract.Permeability;
import contract.Sprite;

public class Land extends MotionLessElement {

	/**
	 * Instantiates a new land (Black square).
	 * Element PENETRABLE.
	 * 
	 * @param model
	 * 
	 * @see IModel
	 * 
	 * @author Clément
	 */
	public Land(IModel model) {
		super(model);
		ArrayList<Sprite> sprites = new ArrayList<Sprite>();
		sprites.add(new Sprite("earth.png"));
		this.setSprites(sprites);
		this.setPermeability(Permeability.PENETRABLE);
	}
}
