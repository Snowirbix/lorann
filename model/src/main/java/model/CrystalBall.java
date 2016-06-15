package model;

public class CrystalBall extends Mobile implements ITouchable {
	private Gate gate;
	
	public CrystalBall(Gate gate) {
		this.gate = gate; // composition
	}
	
	public void onTouch(IMobile activator) { // fire when a mobile is on
		if(activator instanceof Hero) { // check that the mobile is the hero
			this.gate.open(); // when the hero get this ball, he opens the gate
			// remove the ball
		}
	}
}
