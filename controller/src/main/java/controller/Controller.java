package controller;

import contract.ControllerOrder;
import contract.IController;
import contract.IHero;
import contract.IModel;
import contract.IView;

// TODO: Auto-generated Javadoc
/**
 * The Class Controller.
 */
public class Controller implements IController {

	/** The view. */
	private IView		view;

	/** The model. */
	private IModel	model;

	/**
	 * Instantiates a new controller.
	 *
	 * @param view
	 *          the view
	 * @param model
	 *          the model
	 */
	public Controller(final IView view, final IModel model) {
		this.setView(view);
		this.setModel(model);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see contract.IController#control()
	 */
	public void control() {
		//
	}

	/**
	 * Sets the view.
	 *
	 * @param view
	 *          the new view
	 */
	private void setView(final IView view) {
		this.view = view;
	}

	/**
	 * Sets the model.
	 *
	 * @param model
	 *          the new model
	 */
	private void setModel(final IModel model) {
		this.model = model;
	}

	private IModel getModel() {
		return this.model;
	}
	/*
	 * (non-Javadoc)
	 *
	 * @see contract.IController#orderPerform(contract.ControllerOrder)
	 */
	public void run() {
		while(true) {
			this.getModel().setChange();
			try {
				Thread.sleep(130);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void orderPerform(final ControllerOrder controllerOrder) {
		if(!this.model.getMobiles().isEmpty()) {
			IHero hero = this.model.getHero();
			switch (controllerOrder) {
				case UP:
					if(!hero.isOrder(controllerOrder)) {
						hero.setDirection(0, -1);
						hero.addOrder(controllerOrder);
					}
					break;
				case _UP:
					hero.setDirection(0, 1);
					hero.removeOrder(ControllerOrder.UP);
					break;
				case LEFT:
					if(!hero.isOrder(controllerOrder)) {
						hero.setDirection(-1, 0);
						hero.addOrder(controllerOrder);
					}
					break;
				case _LEFT:
					hero.setDirection(1, 0);
					hero.removeOrder(ControllerOrder.LEFT);
					break;
				case RIGHT:
					if(!hero.isOrder(controllerOrder)) {
						hero.setDirection(1, 0);
						hero.addOrder(controllerOrder);
					}
					break;
				case _RIGHT:
					hero.setDirection(-1, 0);
					hero.removeOrder(ControllerOrder.RIGHT);
					break;
				case DOWN:
					if(!hero.isOrder(controllerOrder)) {
						hero.setDirection(0, 1);
						hero.addOrder(controllerOrder);
					}
					break;
				case _DOWN:
					hero.setDirection(0, -1);
					hero.removeOrder(ControllerOrder.DOWN);
					break;
				case ATTACK:
					if(!hero.isOrder(controllerOrder)) {
						hero.attack();
						hero.addOrder(controllerOrder);
					}
					break;
				case _ATTACK:
					hero.removeOrder(ControllerOrder.ATTACK);
					break;
				default:
					break;
			}
		}
	}
}
