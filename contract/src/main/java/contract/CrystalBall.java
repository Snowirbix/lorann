package contract;

import java.util.ArrayList;

public class CrystalBall extends Mobile implements ITouchable {
	private Gate gate;
	
	public CrystalBall(IModel model, Gate gate, int x, int y) {
		super(model, x, y);
		ArrayList<Sprite> sprites = new ArrayList<Sprite>();
		sprites.add(new Sprite("crystal_ball.png"));
		this.setSprites(sprites);
		this.gate = gate; // composition
	}
	
	public void onTouch(IMobile activator) {
		if(activator instanceof Hero) { // check that the mobile is the hero
			this.gate.open(); // when the hero get this ball, he opens the gate
			//this.getModel().getMobiles().remove(this);// remove the ball
		}
	}
}
