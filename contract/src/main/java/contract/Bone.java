package contract;

import java.util.ArrayList;

public class Bone extends MotionLessElement {

	public Bone(IModel model) {
		super(model, 'V');
		ArrayList<Sprite> sprites = new ArrayList<Sprite>();
		sprites.add(new Sprite("bone.png"));
		this.setSprites(sprites);
		this.setPermeability(Permeability.BLOCKING);
	}

}
