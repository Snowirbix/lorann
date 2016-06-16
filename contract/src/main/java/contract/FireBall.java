package contract;

import java.awt.Point;
import java.util.ArrayList;

public class FireBall extends Mobile implements ITouchable {
	public FireBall(IModel model, int x, int y, int _x, int _y) {
		super(model, x, y);
		ArrayList<Sprite> sprites = new ArrayList<Sprite>();
		sprites.add(new Sprite("fireball_1.png"));
		sprites.add(new Sprite("fireball_2.png"));
		sprites.add(new Sprite("fireball_3.png"));
		sprites.add(new Sprite("fireball_4.png"));
		sprites.add(new Sprite("fireball_5.png"));
		this.setSprites(sprites);
		this.setDirection(_x - x, _y - y);
	}
	public void onTouch(IMobile activator) {
		//
	}
	public Point move() {
		super.move();
		if(!this.isMovePossible()) {
			this.direction = new Point(this.getDirection().x*-1, this.getDirection().y*-1); // bounce on walls
		}
		this.setCurrentSprite((this.getCurrentSprite()+1)%5); // change the sprite
		return this.getPosition();
	}
}
