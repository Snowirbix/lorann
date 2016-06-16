package contract;

import java.util.ArrayList;
import java.util.Observable;



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
	
}
