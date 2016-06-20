package contract;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Sprite implements ISprite {
	private Image image;
	
	/**
	 * Instantiates a new Sprite.
	 * 
	 * @param path
	 */
	public Sprite(String path) {
		try {
			this.image = ImageIO.read(new File("../sprite/" + path));
		} catch (final IOException e) {
			e.printStackTrace();
			try {
				this.image = ImageIO.read(new File("../sprite/earth.png"));
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	}
	
	/**
	 * To get Image of the sprite.
	 * @return Image of the sprite
	 */
	public Image getImage() {
		return this.image;
	}
}