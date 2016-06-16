package model;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Observable;

import contract.IMobile;
import contract.IModel;
import contract.MotionLessElement;

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
		this.map = map.getMapArray(this);
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
	
	public void win() {
		//
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
