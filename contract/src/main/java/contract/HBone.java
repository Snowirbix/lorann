package contract;

import java.util.ArrayList;

public class HBone extends MotionLessElement {

	public HBone(IModel model) {
		super(model, 'H');
		ArrayList<Sprite> sprites = new ArrayList<Sprite>();
		sprites.add(new Sprite("horizontal_bone.png"));
		this.setSprites(sprites);
	}

}
