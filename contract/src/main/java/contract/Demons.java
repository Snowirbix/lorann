package contract;

public class Demons extends Mobile implements ITouchable {
	
	private IMobile movementStrat;
	
	public Demons(IModel model, int x, int y) {
		super(model, x, y);
		
	}
	public void onTouch(IMobile activator) {
		//
	}
}
