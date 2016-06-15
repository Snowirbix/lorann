package contract;

public class Hero extends Mobile implements ITouchable {
	private FireBall fireBall;
	
	public Hero(IModel model) {
		super(model);
	}
	
	public void attack() {
		this.fireBall = new FireBall(this.getModel());
	}
	
	public void onTouch(IMobile activator) {
		//
	}
}
