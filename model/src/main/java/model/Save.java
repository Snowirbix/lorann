package model;

import contract.IModel;
import contract.ISave;

public class Save extends Entity implements ISave {
	private int life;
	private int score;
	private IModel model;

	/**
	 * Instantiates a new Save.
	 * @param life
	 * Number of life
	 * @param score
	 * Number of score
	 */
	public Save(int life, int score) {
		this.life = life;
		this.score = score;
	}

	/**
	 * Instantiates a new Save with no parameter
	 */
	public Save() {
		this.life = 0;
		this.score = 0;
	}
	
	/**
	 * To get the number of life
	 */
	public int getLife() {
		return life;
	}

	/**
	 * To set the number of life
	 * @param life
	 * Number of life to ADD.
	 */
	public void setLife(int life) {
		this.life += life;
	}

	/**
	 * To get the model
	 * @return IModel, the model
	 */
	public IModel getModel() {
		return model;
	}

	/**
	 * To set the model
	 */
	public void setModel(IModel model) {
		this.model = model;
	}

	/**
	 * To get the number of score
	 */
	public int getScore() {
		return score;
	}

	/**
	 * To set the number of score
	 * @param score
	 * Number of score to ADD.
	 */
	public void setScore(int score) {
		this.score += score;
	}
}
