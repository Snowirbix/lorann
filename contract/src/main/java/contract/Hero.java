package contract;

import java.util.ArrayList;

public class Hero extends Mobile implements ITouchable {
	private FireBall fireBall;
	
	public Hero(IModel model, int x, int y) {
		super(model, x, y);
		ArrayList<Sprite> sprites = new ArrayList<Sprite>();
		sprites.add(new Sprite("lorann_b.png"));
		this.setSprites(sprites);
	}
	
	public void attack() {
		this.fireBall = new FireBall(this.getModel(), this.getPosition().x, this.getPosition().y);
	}
	
	public void onTouch(IMobile activator) {
		//
	}
}
