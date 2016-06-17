package model;

import java.awt.Point;
import java.util.ArrayList;

import contract.IHero;
import contract.IMobile;
import contract.IModel;
import contract.IStrategy;
import contract.ITouchable;
import contract.Mobile;
import contract.Permeability;
import contract.Sprite;

public class Demons extends Mobile implements ITouchable {
	
	private IStrategy movementStrat;
	
	public Demons(IModel model, int x, int y,IStrategy strat) {
		super(model, x, y);
		this.movementStrat = strat;
		ArrayList<Sprite> sprites = new ArrayList<Sprite>();
		sprites.add(new Sprite("monster_1.png"));
		sprites.add(new Sprite("monster_2.png"));
		sprites.add(new Sprite("monster_3.png"));
		sprites.add(new Sprite("monster_4.png"));
		this.setSprites(sprites);
		
		if(strat instanceof Kyracj) {
			this.setCurrentSprite(0);	
		} else if(strat instanceof Maarcg) {
			this.setCurrentSprite(1);				
		} else if(strat instanceof Arrbarr) {
			this.setCurrentSprite(2);				
		} else if(strat instanceof Cargyv) {
			this.setCurrentSprite(3);				
		}
	}
	public boolean onTouch(IMobile activator) {
		if(activator instanceof FireBall) {
			((Hero) this.getModel().getMobiles().get(0)).setScore(20);
			return true;
		}
		return false;
	}
	public Point move(){
		Point newPosition = this.movementStrat.move(new Point(position.x, position.y), ((IHero) this.getModel().getMobiles().get(0)));
		if(this.getModel().getMap()[newPosition.x][newPosition.y].getPermeability() != Permeability.BLOCKING){
			this.setPosition(newPosition);
		}
	return this.getPosition();
	}
	
}
