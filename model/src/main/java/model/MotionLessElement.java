package model;

public class MotionLessElement extends Element {
	private char fileSymbol;
	private Permeability permeability;
	
	public MotionLessElement(char fileSymbol) {
		this.fileSymbol = fileSymbol;
	}

	public char getFileSymbol() {
		return fileSymbol;
	}

	public void setFileSymbol(char fileSymbol) {
		this.fileSymbol = fileSymbol;
	}

	public Permeability getPermeability() {
		return permeability;
	}

	public void setPermeability(Permeability permeability) {
		this.permeability = permeability;
	}
}
