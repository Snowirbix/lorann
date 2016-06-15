package contract;

import java.util.ArrayList;

public class Land extends MotionLessElement {

	public Land(IModel model) {
		super(model, 'E');
		ArrayList<Sprite> sprites = new ArrayList<Sprite>();
		sprites.add(new Sprite("earth.png"));
		this.setSprites(sprites);
		this.setPermeability(Permeability.PENETRABLE);
	}
}
