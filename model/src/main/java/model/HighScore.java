package model;

import contract.IHighScore;

public class HighScore extends Entity implements IHighScore {
	/**
	 * Number of score
	 */
	private int score;

	/**
	 * Instantiates a new HighScore.
	 * @param score
	 * the number of score to beging
	 */
	public HighScore(int score) {
		this.score = score;
	}
	
	/**
	 * Instantiates a new HighScore.
	 */
	public HighScore() {
		this(0);
	}
	
	/**
	 * Recover the score actual.
	 */
	public int getScore() {
		return score;
	}

	/**
	 * To set a new Score
	 * 
	 * @param score
	 * new score to apply
	 */
	public void setScore(int score) {
		this.score = score;
	}
}
