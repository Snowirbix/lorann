package contract;

import java.util.ArrayList;

public class VBone extends MotionLessElement {

	public VBone(IModel model) {
		super(model, 'V');
		ArrayList<Sprite> sprites = new ArrayList<Sprite>();
		sprites.add(new Sprite("vertical_bone.png"));
		this.setSprites(sprites);
	}

}
