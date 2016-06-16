package contract;

import java.util.ArrayList;

public class Hero extends Mobile implements ITouchable {
	private FireBall fireBall;
	private ArrayList<ControllerOrder> orders;
	
	public Hero(IModel model) {
		super(model, 0, 0);
		ArrayList<Sprite> sprites = new ArrayList<Sprite>();
		sprites.add(new Sprite("lorann_b.png"));
		this.setSprites(sprites);
		this.orders = new ArrayList<ControllerOrder>();
	}
	
	public void attack() {
		this.fireBall = new FireBall(this.getModel(), this.getPosition().x, this.getPosition().y);
		this.getModel().getMobiles().add(this.fireBall);
	}
	public void disengage() {
		this.getModel().getMobiles().remove(this.getModel().getMobiles().indexOf(this.fireBall));
		this.fireBall = null;
	}
	public void onTouch(IMobile activator) {
		//
	}
	public void addOrder(ControllerOrder order) {
		this.orders.add(order);
	}

	public void removeOrder(ControllerOrder order) {
		this.orders.remove(this.orders.indexOf(order));
	}
	public boolean isOrder(ControllerOrder order) {
		return this.orders.contains(order);
	}
}
