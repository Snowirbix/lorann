package model;

import java.util.ArrayList;

import contract.IModel;
import contract.MotionLessElement;
import contract.Permeability;
import contract.Sprite;

public class VBone extends MotionLessElement {

	public VBone(IModel model) {
		super(model, 'V');
		ArrayList<Sprite> sprites = new ArrayList<Sprite>();
		sprites.add(new Sprite("vertical_bone.png"));
		this.setSprites(sprites);
		this.setPermeability(Permeability.BLOCKING);
	}

}
