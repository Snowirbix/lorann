package contract;

public class Demons implements ITouchable {
	private IMobile movementStrat;
	
	public Demons() {
		this.movementStrat = new Movement1();
	}
	
	public void onTouch(IMobile activator) {
		//
	}
}
