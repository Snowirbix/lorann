package model;

public class CrystalBall extends Mobile implements ITouchable {
	private Gate gate;
	
	public CrystalBall(Gate gate) {
		this.gate = gate;
	}
	
	public void onTouch(IMobile activator) {
		this.gate.open();
	}
}
