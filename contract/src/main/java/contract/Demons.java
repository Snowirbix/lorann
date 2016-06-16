package contract;

import java.awt.Point;
import java.util.ArrayList;

public class Demons extends Mobile implements ITouchable {
	
	private IMobile movementStrat;
	
	public Demons(IModel model, int x, int y,IMobile strat) {
		super(model, x, y);
		this.movementStrat = strat;
		ArrayList<Sprite> sprites = new ArrayList<Sprite>();
		sprites.add(new Sprite("monster_4.png"));
		this.setSprites(sprites);
	}
	public void onTouch(IMobile activator) {
		//
	}
	public Point move(){
		return this.movementStrat.move();
	}
}
