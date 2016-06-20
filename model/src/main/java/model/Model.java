package model;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Observable;

import contract.IHighScore;
import contract.IMobile;
import contract.IModel;
import contract.ISave;
import contract.MotionLessElement;

/**
 * The Class Model is the storage of all data.
 *
 *
 * @author Alban , Alexandre, Clément
 */
public class Model extends Observable implements IModel {
	
	/**
	 * it allows us to stock the map that we receive from the database
	 * 
	 * @see MotionLessElement
	 */
	private MotionLessElement[][] map;
	
	/**
	 * 
	 * it is a list of mobile elements of the current map
	 * 
	 */
	
	private ArrayList<IMobile> mobiles;
	
	/**
	 * 
	 * 
	 * @see ISave
	 */
	
	private ISave save;
	
	/**
	 *
	 * @see IHighScore
	 */
	private IHighScore highScore;


	/**
	 * Instantiates a new model.
	 */
	public Model() {
		this.mobiles = new ArrayList<IMobile>();
		this.save = (ISave) new Save();
		this.highScore = (IHighScore) new HighScore();
		this.loadHighScore();
	}
	
	/**
	 *	this method allows us to load the save stock in the database 
	 */
	public void loadSave() {
		try {
			DAOSave daoSave = new DAOSave(DBConnection.getInstance().getConnection());
			this.setSave((ISave) daoSave.find(0));
		} catch (final SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * this method allows us to load the HighScore stock in the database
	 */
	public void loadHighScore() {
		try {
			DAOHighScore daoHighScore = new DAOHighScore(DBConnection.getInstance().getConnection());
			this.setHighScore((IHighScore) daoHighScore.find(0));
		} catch (final SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * this method load the map
	 * @param id
	 */
	public void loadMap(int id) {
		try {
			final DAOMap daoMap = new DAOMap(DBConnection.getInstance().getConnection());
			this.setMapAndMobiles(daoMap.find(id));
		} catch (final SQLException e) {
			e.printStackTrace();
		}
		this.loadSave();
	}

	/**
	 * this method set the map and the mobile elements, it takes map and elements mobile from the object map 
	 * @param map
	 */
	public void setMapAndMobiles(Map map) {
		this.map = map.getMapArray(this);
		this.setMobiles(map.getMobiles());
	}
	/**
	 * this method set the map and eat some spaghetti
	 * @param map
	 */
	public void setMap(MotionLessElement[][] map) {
		this.map = map;
	}
	
	/**
	 *
	 *@return  the current map
	 */
	public MotionLessElement[][] getMap() {
		return this.map;
	}
	
	/**
	 * 
	 * @return the list of mobile elements
	 */
	public ArrayList<IMobile> getMobiles() {
		return mobiles;
	}
	
	/**
	 * add an element mobile in the list of mobile elements
	 * @param mobiles
	 */
	public void setMobiles(ArrayList<IMobile> mobiles) {
		this.mobiles = mobiles;
	}

	/**
	 * @return the current save
	 */
	public ISave getSave() {
		return save;
	}
	
	/**
	 * Set the current save
	 * @param save
	 */
	public void setSave(ISave save) {
		this.save = save;
		save.setModel(this);
	}

	/**
	 * @return the current HighScore
	 */
	public IHighScore getHighScore() {
		return highScore;
	}

	/**
	 * this method set the HighScore
	 * @param highScore
	 */
	public void setHighScore(IHighScore highScore) {
		this.highScore = highScore;
	}

	/**
	 * this method get the save with the score of the hero and send it into the database, after this it exit the program
	 */
	public void win() {
		this.getSave().setScore(((Hero) this.getMobiles().get(0)).getScore());
		DAOSave daoSave;
		try {
			daoSave = new DAOSave(DBConnection.getInstance().getConnection());
			daoSave.update((Save) this.getSave());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.exit(0);
	}
	
	/**
	 * this method remove one life and check if the life isn't at 0 otherwise it save the score in the HighScore table 
	 */
	public void lose() {
		this.getSave().setLife(-1);
		if(this.getSave().getLife() <= 0) {
			DAOHighScore daoHighScore;
			try {
				daoHighScore = new DAOHighScore(DBConnection.getInstance().getConnection());
				daoHighScore.update(this.getSave().getScore());
			} catch (SQLException e) {
				e.printStackTrace();
			}
			this.setSave(new Save(10, 0)); // reset
		}
		
		DAOSave daoSave;
		try {
			daoSave = new DAOSave(DBConnection.getInstance().getConnection());
			daoSave.update((Save) this.getSave());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.exit(0);
	}
	/*
	 * (non-Javadoc)
	 *
	 * @see contract.IModel#getObservable()
	 */
	
	/**
	 * this method call setChanged and notifyObservers
	 */
	public void setChange() {
		this.setChanged();
		this.notifyObservers();
	}
	
	/**
	 * @return this model
	 */
	public Observable getObservable() {
		return this;
	}
}
