package model;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Observable;

import contract.IMobile;
import contract.IModel;
import contract.ISave;
import contract.MotionLessElement;

/**
 * The Class Model.
 *
 * @author Jean-Aymeric Diet
 */
public class Model extends Observable implements IModel {

	private MotionLessElement[][] map;
	private ArrayList<IMobile> mobiles;
	private ISave save;


	/**
	 * Instantiates a new model.
	 */
	public Model() {
		this.mobiles = new ArrayList<IMobile>();
		this.save = (ISave) new Save();
	}

	public void loadSave() {
		try {
			DAOSave daoSave = new DAOSave(DBConnection.getInstance().getConnection());
			this.setSave((ISave) daoSave.find(0));
		} catch (final SQLException e) {
			e.printStackTrace();
		}
	}
	public void loadMap(int id) {
		try {
			final DAOMap daoMap = new DAOMap(DBConnection.getInstance().getConnection());
			this.setMapAndMobiles(daoMap.find(id));
		} catch (final SQLException e) {
			e.printStackTrace();
		}
		this.loadSave();
	}

	public void setMapAndMobiles(Map map) {
		this.map = map.getMapArray(this);
		this.setMobiles(map.getMobiles());
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

	public ISave getSave() {
		return save;
	}

	public void setSave(ISave save) {
		this.save = save;
	}
	
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
	public void lose() {
		this.getSave().setLife(-1);
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
	public void setChange() {
		this.setChanged();
		this.notifyObservers();
	}
	
	public Observable getObservable() {
		return this;
	}
}
