package contract;

import java.awt.Point;
import java.util.ArrayList;

public class Demons extends Mobile implements ITouchable {
	
	private IStrategy movementStrat;
	
	public Demons(IModel model, int x, int y,IStrategy strat) {
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
		Point newPosition = this.movementStrat.move(new Point(position.x, position.y));
		if(this.getModel().getMap()[newPosition.x][newPosition.y].getPermeability() != Permeability.BLOCKING){
			this.setPosition(newPosition);
		}
	return this.getPosition();
	}
	
}
