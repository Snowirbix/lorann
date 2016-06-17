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
	private FireBall fireBall;
	private ArrayList<ControllerOrder> orders;
	private Point previousPosition;
	private int score;

	public ArrayList<ControllerOrder> getOrders() {
		return orders;
	}

	public void setOrders(ArrayList<ControllerOrder> orders) {
		this.orders = orders;
	}

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
	public void attack() {
		if(this.fireBall == null) {
			this.fireBall = new FireBall(this.getModel(), this.getPosition().x, this.getPosition().y, this.getPreviousPosition().x, this.getPreviousPosition().y);
			this.getModel().getMobiles().add(this.fireBall);
		} else {
			this.disengage();
		}
	}
	public void disengage() {
		this.getModel().getMobiles().remove(this.fireBall);
		this.fireBall = null;
	}
	public boolean onTouch(IMobile activator) {
		if(activator instanceof Demons) {
			this.getModel().lose();
		}
		return false;
	}
	public void addOrder(ControllerOrder order) {
		this.orders.add(order);
	}

	public void removeOrder(ControllerOrder order) {
		this.orders.remove(order);
	}
	public boolean isOrder(ControllerOrder order) {
		return this.orders.contains(order);
	}

	public FireBall getFireBall() {
		return this.fireBall;
	}

	public void setFireBall(FireBall fireBall) {
		this.fireBall = fireBall;
	}

	public Point getPreviousPosition() {
		return this.previousPosition;
	}

	public void setPreviousPosition(Point previousPosition) {
		this.previousPosition = previousPosition;
	}
	
	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score += score;
	}
}
