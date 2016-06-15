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
	}
	
	public void attack() {
		this.fireBall = new FireBall(this.getModel(), this.getPosition().x, this.getPosition().y);
	}
	
	public void onTouch(IMobile activator) {
		//
	}
	public void addOrder(ControllerOrder order) {
		this.orders.add(order);
	}

	public void removeOrder(ControllerOrder order) {
		int index = this.orders.indexOf(order);
		if(index != -1) {
			this.orders.remove(index);
		}
	}
}
