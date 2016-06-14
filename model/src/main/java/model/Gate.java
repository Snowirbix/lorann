package model;

public class Gate extends MotionLessElement implements ITouchable {
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
	
	public void onTouch(IMobile activator) {
		if(getState()) {
			System.out.println("win");
		} else {
			System.out.println("try again");
		}
	}
}
