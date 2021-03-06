package contract;

import java.util.ArrayList;
import java.util.Observable;

import contract.MotionLessElement;



/**
 * The Interface IModel.
 *
 * @author Jean-Aymeric Diet
 */
public interface IModel {

	/**
	 * Gets the observable.
	 *
	 * @return the observable
	 */
	Observable getObservable();

	MotionLessElement[][] getMap();

	ArrayList<IMobile> getMobiles();

	void win();

	void lose();

	void setChange();

	ISave getSave();

	IHighScore getHighScore();

	void loadMap(int i);
	
	public IHero getHero();

	String getMessage();

	void setMessage(String message);
	
}
