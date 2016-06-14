package model;

public class Hero extends Mobile implements ITouchable {
	private FireBall fireBall;
	
	public void attack() {
		this.fireBall = new FireBall();
	}
	
	public void onTouch(IMobile activator) {
		//
	}
}
