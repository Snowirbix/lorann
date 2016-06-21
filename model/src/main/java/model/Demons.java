package model;

import java.awt.Point;
import java.util.ArrayList;

import contract.IMobile;
import contract.IModel;
import contract.IStrategy;
import contract.ITouchable;
import contract.Permeability;
import contract.Sprite;

public class Demons extends Mobile implements ITouchable {
	
	/**
	 * this attribute is used for call the different method move for demons
	 * @see IStrategy
	 */
	private IStrategy movementStrat;
	
	/**
	 * This constructor create the different sprites of different demons
	 * @param model
	 * @param x
	 * @param y
	 * @param strat
	 */
	public Demons(IModel model, int x, int y,IStrategy strat) {
		super(model, x, y);
		this.movementStrat = strat;
		ArrayList<Sprite> sprites = new ArrayList<Sprite>();
		sprites.add(new Sprite("monster_1.png"));
		sprites.add(new Sprite("monster_2.png"));
		sprites.add(new Sprite("monster_3.png"));
		sprites.add(new Sprite("monster_4.png"));
		this.setSprites(sprites);
		this.setPermeability(Permeability.BLOCKING);
		
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
	
	/**
	 * method use when a demon is touch (or not) by a Fireball
	 *@param activator
	 *@return false if a demon is alive, true if he die 
	 */
	public boolean onTouch(IMobile activator) {
		if(activator instanceof FireBall) {
			Hero hero = Hero.getInstance(this.getModel());
			hero.setScore(20);
			hero.disengage();
			return true;
		} else if(activator instanceof Hero) {
			this.getModel().getMobiles().remove(activator);
			//this.getModel().lose();
		}
		return false;
	}
	
	/**
	 * this method call the method move of different demons with some parameters 
	 * @return the current position of a demon
	 */
	public Point move(){
		Point newPosition = this.movementStrat.move(new Point(position.x, position.y), Hero.getInstance(this.getModel()));
		if(this.isMovePossible(newPosition.x, newPosition.y)){
			this.setPosition(newPosition);
		} else if(this.isMovePossible(newPosition.x, getPosition().y)) {
			this.position.x = newPosition.x;
		} else if(this.isMovePossible(getPosition().x, newPosition.y)) {
			this.position.y = newPosition.y;
		}
		return this.getPosition();
	}
}
