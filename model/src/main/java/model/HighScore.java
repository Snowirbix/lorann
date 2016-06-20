package model;

import contract.IHighScore;

public class HighScore extends Entity implements IHighScore {
	private int score;

	public HighScore(int score) {
		this.score = score;
	}
	
	public HighScore() {
		this(0);
	}
	
	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}
}
