package contract;

import java.util.ArrayList;

public class Gate extends MotionLessElement implements ITouchable {
	private boolean state = false;
	
	public Gate(IModel model) {
		super(model, 'G');
		ArrayList<Sprite> sprites = new ArrayList<Sprite>();
		sprites.add(new Sprite("gate_closed.png"));
		sprites.add(new Sprite("gate_open.png"));
		this.setSprites(sprites);
		this.setPermeability(Permeability.PENETRABLE);
		//this.open();
	}

	public void open() {
		this.state = true;
		this.setCurrentSprite(1);
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
