package model;

public class Demons {
	private IMobile movementStrat;
	
	public Demons() {
		this.movementStrat = new Movement1();
	}
}
