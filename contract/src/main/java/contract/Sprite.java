package contract;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Sprite implements ISprite {
	private Image image;
	
	public Sprite(String path) {
		try {
			this.image = ImageIO.read(new File("../sprite/" + path));
		} catch (final IOException e) {
			e.printStackTrace();
		}
	}
	public Image getImage() {
		return this.image;
	}
}
