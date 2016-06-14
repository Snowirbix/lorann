package model;

public class Hero extends Mobile {
	private FireBall fireBall;
	
	public void attack() {
		this.fireBall = new FireBall();
	}
}
