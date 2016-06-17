package model;

import contract.ISave;

public class Save extends Entity implements ISave {
	private int life;
	private int score;

	public Save(int life, int score) {
		this.life = life;
		this.score = score;
	}

	public Save() {
		this.life = 0;
		this.score = 0;
	}
	
	public int getLife() {
		return life;
	}

	public void setLife(int life) {
		this.life += life;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score += score;
	}
}
