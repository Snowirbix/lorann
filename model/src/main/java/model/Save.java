package model;

public class Save extends Entity {
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
}
