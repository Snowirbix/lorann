package model;

import java.util.ArrayList;

import contract.IModel;
import contract.MotionLessElement;
import contract.Permeability;
import contract.Sprite;

public class Bone extends MotionLessElement {

	/**
	 * this constructor create a bone, it load the bone's sprite 
	 * 
	 * @param model
	 */
	public Bone(IModel model) {
		super(model);
		ArrayList<Sprite> sprites = new ArrayList<Sprite>();
		sprites.add(new Sprite("bone.png"));
		this.setSprites(sprites);
		this.setPermeability(Permeability.BLOCKING);
	}
}
