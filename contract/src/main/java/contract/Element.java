package contract;

import java.awt.Image;
import java.util.ArrayList;

public class Element {
	private ArrayList<Sprite> sprites;
	private IModel model;
	private int currentSprite;
	
	public Element(IModel model) {
		this.sprites = new ArrayList<Sprite>();
		this.model = model;
		this.currentSprite = 0;
	}
	
	public IModel getModel() {
		return this.model;
	}
	public void setModel(IModel model) {
		this.model = model;
	}
	
	public ArrayList<Sprite> getSprites() {
		return this.sprites;
	}
	public void setSprites(ArrayList<Sprite> sprites) {
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
