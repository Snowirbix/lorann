package model;

import java.awt.Image;
import java.util.ArrayList;

public class Element {
	private ArrayList<Sprite> sprites;
	private Model model;
	private int currentSprite;
	
	public Element() {
		this.sprites = new ArrayList<Sprite>();
		this.model = new Model();
		this.currentSprite = 0;
	}
	
	public Model getModel() {
		return this.model;
	}
	public void setModel(Model model) {
		this.model = model;
	}
	
	public ArrayList<Sprite> getSprite() {
		return this.sprites;
	}
	public void setSprite(ArrayList<Sprite> sprites) {
		this.sprites = sprites;
	}
	
	public Image getImage() {
		return this.sprites.get(this.currentSprite).getImage();
	}
	
	public int getCurrentSprite() {
		return this.currentSprite;
	}
	public void setCurrentSprite(int currentSprite) {
		this.currentSprite = currentSprite;
	}
}
