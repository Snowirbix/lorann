package model;

import contract.IModel;
import contract.ISave;

public class Save extends Entity implements ISave {
	private int life;
	private int score;
	private IModel model;

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

	public IModel getModel() {
		return model;
	}

	public void setModel(IModel model) {
		this.model = model;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score += score;
	}
}
