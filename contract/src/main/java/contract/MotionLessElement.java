package contract;


public class MotionLessElement extends Element {
	private char fileSymbol;
	
	public MotionLessElement(IModel model, char fileSymbol) {
		super(model);
		this.fileSymbol = fileSymbol;
	}

	public char getFileSymbol() {
		return fileSymbol;
	}

	public void setFileSymbol(char fileSymbol) {
		this.fileSymbol = fileSymbol;
	}
}
