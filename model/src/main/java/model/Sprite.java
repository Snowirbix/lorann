package model;

import java.awt.Image;

public class Sprite implements ISprite {
	private Image image;
	
	public Sprite(String path) {
		// load the image
	}
	public Image getImage() {
		return this.image;
	}
}
