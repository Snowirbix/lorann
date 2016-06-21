package model;

import java.awt.Point;
import java.util.ArrayList;

import contract.ControllerOrder;
import contract.IHero;
import contract.IMobile;
import contract.IModel;
import contract.ITouchable;
import contract.Permeability;
import contract.Sprite;

public class Hero extends Mobile implements ITouchable, IHero {
	
	private static Hero	INSTANCE	= null;
	/**
	 * @see FireBall
	 */
	private FireBall fireBall;
	/**
	 * 
	 */
	private ArrayList<ControllerOrder> orders;
	private int score;
	/**
	 * @see Point
	 */
	protected Point previousPosition;

	/**
	 * 
	 * @return ArrayList of orders
	 */
	public ArrayList<ControllerOrder> getOrders() {
		return orders;
	}

	/**
	 * 
	 * @param orders
	 * Order to set.
	 */
	public void setOrders(ArrayList<ControllerOrder> orders) {
		this.orders = orders;
	}

	
	/**
	 * Instantiates a new Hero.
	 * It contains 8 sprites storage in a ArrayList.
	 * 
	 * @param model
	 * 
	 * @author Clément
	 */
	public Hero(IModel model) {
		super(model, 0, 0);
		this.previousPosition = new Point(0, 0);
		ArrayList<Sprite> sprites = new ArrayList<Sprite>();
		sprites.add(new Sprite("lorann_br.png"));
		sprites.add(new Sprite("lorann_b.png"));
		sprites.add(new Sprite("lorann_bl.png"));
		sprites.add(new Sprite("lorann_l.png"));
		sprites.add(new Sprite("lorann_ul.png"));
		sprites.add(new Sprite("lorann_u.png"));
		sprites.add(new Sprite("lorann_ur.png"));
		sprites.add(new Sprite("lorann_r.png"));
		this.setSprites(sprites);
		this.orders = new ArrayList<ControllerOrder>();
		this.fireBall = null;
		this.score = 0;
		this.setPermeability(Permeability.PENETRABLE);
	}
	
	public static Hero getInstance(IModel model) {
		if (Hero.INSTANCE == null) {
			Hero.INSTANCE = new Hero(model);
		}
		return Hero.INSTANCE;
	}
	/**
	 * To move the Hero
	 * 
	 * @return the new position of the hero.
	 * 
	 * @author Clément
	 */
	public Point move() {
		
		if(this.getDirection().x != 0 || this.getDirection().y != 0) {
			
			Point previousPosition = new Point(this.previousPosition.x, this.previousPosition.y); // clone
			this.previousPosition = new Point(this.getPosition().x, this.getPosition().y); // clone
			
			if(this.isMovePossible(getPosition().x+getDirection().x, getPosition().y+getDirection().y)) {
				this.position.x += this.direction.x;
				this.position.y += this.direction.y;
			} else if(this.isMovePossible(getPosition().x+getDirection().x, getPosition().y) && getDirection().x != 0) {
				this.position.x += this.direction.x;
			} else if(this.isMovePossible(getPosition().x, getPosition().y+getDirection().y) && getDirection().y != 0) {
				this.position.y += this.direction.y;
			} else {
				this.previousPosition = previousPosition;
			}
			
			switch(this.getDirection().x) {
				case -1:
					switch(this.getDirection().y) {
						case -1:
							this.setCurrentSprite(4);
							break;
						case 0:
							this.setCurrentSprite(3);
							break;
						case 1:
							this.setCurrentSprite(2);
					}
					break;
				case 0:
					switch(this.getDirection().y) {
						case -1:
							this.setCurrentSprite(5);
							break;
						case 1:
							this.setCurrentSprite(1);
							break;
					}
					break;
				case 1:
					switch(this.getDirection().y) {
						case -1:
							this.setCurrentSprite(6);
							break;
						case 0:
							this.setCurrentSprite(7);
							break;
						case 1:
							this.setCurrentSprite(0);
							break;
					}
					break;
			}
		} else {
			this.setCurrentSprite((this.getCurrentSprite()+1)%8);
		}
		
		return this.getPosition();
	}
	
	/**
	 * To throw (cast) a fireball
	 * 
	 * @author Clément
	 */
	public void attack() {
		if(this.fireBall == null) {
			this.fireBall = new FireBall(this.getModel(), this.getPosition().x, this.getPosition().y, this.getPreviousPosition().x, this.getPreviousPosition().y);
			this.getModel().getMobiles().add(this.fireBall);
		}
	}
	
	/**
	 * To recover the fireball
	 * 
	 * @author Clément
	 */
	public void disengage() {
		this.getModel().getMobiles().remove(this.fireBall);
		this.fireBall = null;
	}
	
	/**
	 * When something touches the hero
	 * 
	 * @param activator
	 * 
	 * @return if is not a Demons or Fireball return false
	 * else is a demons the game stop (your lose)
	 * else if a fireball you recover the fireball
	 *  
	 * @author Clément
	 */
	public boolean onTouch(IMobile activator) {
		if(activator instanceof Demons) {
			this.getModel().lose();
		} else if(activator instanceof FireBall) {
			this.disengage();
		}
		return false;
	}
	
	/**
	 * Add a order
	 * @param order
	 * Order by users
	 */
	public void addOrder(ControllerOrder order) {
		this.orders.add(order);
	}

	/**
	 * Remove a order
	 * @param order
	 * Order by users
	 */
	public void removeOrder(ControllerOrder order) {
		this.orders.remove(order);
	}
	
	
	public boolean isOrder(ControllerOrder order) {
		return this.orders.contains(order);
	}
	
	/**
	 * Get the FireBall
	 */
	public FireBall getFireBall() {
		return this.fireBall;
	}

	/**
	 * Set a FireBall
	 * @param fireBall
	 */
	public void setFireBall(FireBall fireBall) {
		this.fireBall = fireBall;
	}
	
	/**
	 * To recover the position before action
	 */
	public Point getPreviousPosition() {
		return this.previousPosition;
	}
	
	/**
	 * Position before
	 * @param previousPosition
	 * The coordinate point before action
	 */
	public void setPreviousPosition(Point previousPosition) {
		this.previousPosition = previousPosition;
	}
	
	/**
	 * @return the score actual (int)
	 */
	public int getScore() {
		return score;
	}

	/**
	 * Add a score
	 * @param score
	 * Number of the score to add
	 */
	public void setScore(int score) {
		this.score += score;
	}
}
