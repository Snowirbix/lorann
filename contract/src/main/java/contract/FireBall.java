package contract;

public class FireBall extends Mobile implements ITouchable {
	public FireBall(IModel model, int x, int y) {
		super(model, x, y);
	}
	public void onTouch(IMobile activator) {
		//
	}
}
