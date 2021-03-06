package view;

import java.awt.event.KeyEvent;

import javax.swing.SwingUtilities;

import contract.ControllerOrder;
import contract.IController;
import contract.IModel;
import contract.IView;

/**
 * The Class View.
 *
 * @author Jean-Aymeric Diet
 */
public class View implements IView, Runnable {

	/** The frame. */
	private final ViewFrame viewFrame;

	/**
	 * Instantiates a new view.
	 *
	 * @param model
	 *          the model
	 */
	public View(final IModel model) {
		this.viewFrame = new ViewFrame(model);
		SwingUtilities.invokeLater(this);
	}

	/**
	 * Key code to controller order.
	 *
	 * @param keyCode
	 *          the key code
	 *          
	 * @param tap
	 *			Is true is the key is push
	 *			Is true is the key is not push
	 *          
	 * @return the controller order
	 */
	protected static ControllerOrder keyCodeToControllerOrder(final int keyCode, boolean tap) {
		switch (keyCode) {
			case KeyEvent.VK_UP:
				if(tap) {
					return ControllerOrder.UP;
				} else {
					return ControllerOrder._UP;
				}
			case KeyEvent.VK_LEFT:
				if(tap) {
					return ControllerOrder.LEFT;
				} else {
					return ControllerOrder._LEFT;
				}
			case KeyEvent.VK_RIGHT:
				if(tap) {
					return ControllerOrder.RIGHT;
				} else {
					return ControllerOrder._RIGHT;
				}
			case KeyEvent.VK_DOWN:
				if(tap) {
					return ControllerOrder.DOWN;
				} else {
					return ControllerOrder._DOWN;
				}
			case KeyEvent.VK_SPACE:
				if(tap) {
					return ControllerOrder.ATTACK;
				} else {
					return ControllerOrder._ATTACK;
				}
			default:
				return ControllerOrder.NOOP;
		}
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see contract.IView#printMessage(java.lang.String)
	 */
	public void printMessage(final String message) {
		this.viewFrame.printMessage(message);
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see java.lang.Runnable#run()
	 */
	public void run() {
		this.viewFrame.setVisible(true);
	}

	/**
	 * Sets the controller.
	 *
	 * @param controller
	 *          the new controller
	 */
	public void setController(final IController controller) {
		this.viewFrame.setController(controller);
	}
}
