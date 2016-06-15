package model;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Observable;

import contract.IModel;

/**
 * The Class Model.
 *
 * @author Jean-Aymeric Diet
 */
public class Model extends Observable implements IModel {

	private MotionLessElement[][] map;
	private ArrayList<IMobile> mobiles;


	/**
	 * Instantiates a new model.
	 */
	public Model() {
		this.mobiles = new ArrayList<IMobile>();
	}

	public void loadMap(int id) {
		try {
			final DAOMap daoMap = new DAOMap(DBConnection.getInstance().getConnection());
			this.setMap(daoMap.find(id).getMapArray());
		} catch (final SQLException e) {
			e.printStackTrace();
		}
	}
	public void setMap(MotionLessElement[][] map) {
		this.map = map;
		this.setChanged();
		this.notifyObservers();
	}
	public MotionLessElement[][] getMap() {
		return this.map;
	}

	public ArrayList<IMobile> getMobiles() {
		return mobiles;
	}
	public void setMobiles(ArrayList<IMobile> mobiles) {
		this.mobiles = mobiles;
	}
	/*
	 * (non-Javadoc)
	 *
	 * @see contract.IModel#getObservable()
	 */
	public Observable getObservable() {
		return this;
	}
}
