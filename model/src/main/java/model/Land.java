package model;

import java.util.ArrayList;

public class Land extends MotionLessElement {

	public Land() {
		super('E');
		ArrayList<Sprite> sprites = new ArrayList<Sprite>();
		sprites.add(new Sprite("earth.png"));
		this.setSprites(sprites);
	}
}
