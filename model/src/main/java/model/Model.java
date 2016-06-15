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
			this.setMapAndMobiles(daoMap.find(id));
		} catch (final SQLException e) {
			e.printStackTrace();
		}
	}

	public void setMapAndMobiles(Map map) {
		this.map = map.getMapArray();
		this.setMobiles(map.getMobiles());
		this.setChanged();
		this.notifyObservers();
	}
	
	public void setMap(MotionLessElement[][] map) {
		this.map = map;
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
