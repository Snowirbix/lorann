package model;

public class Gate extends MotionLessElement {
	private boolean state = false;
	
	public Gate(char fileSymbol) {
		super(fileSymbol);
	}

	public void open() {
		this.state = true;
	}
	public boolean getState() {
		return this.state;
	}
}
