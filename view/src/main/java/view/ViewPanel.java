package view;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

import contract.IHero;
import contract.IMobile;
import contract.ITouchable;
import contract.MotionLessElement;
/**
 * The Class ViewPanel.
 *
 * @author Jean-Aymeric Diet
 */
class ViewPanel extends JPanel implements Observer {

	/** The view frame. */
	private ViewFrame					viewFrame;
	/** The Constant serialVersionUID. */
	private static final long	serialVersionUID	= -998294702363713521L;

	/**
	 * Instantiates a new view panel.
	 *
	 * @param viewFrame
	 *          the view frame
	 */
	public ViewPanel(final ViewFrame viewFrame) {
		this.setViewFrame(viewFrame);
		viewFrame.getModel().getObservable().addObserver(this);
	}

	/**
	 * Gets the view frame.
	 *
	 * @return the view frame
	 */
	private ViewFrame getViewFrame() {
		return this.viewFrame;
	}

	/**
	 * Sets the view frame.
	 *
	 * @param viewFrame
	 *          the new view frame
	 */
	private void setViewFrame(final ViewFrame viewFrame) {
		this.viewFrame = viewFrame;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see java.util.Observer#update(java.util.Observable, java.lang.Object)
	 */
	public void update(final Observable arg0, final Object arg1) {
		this.repaint();
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
	 */
	@Override
	protected void paintComponent(final Graphics graphics) {
		graphics.clearRect(0, 0, this.getWidth(), this.getHeight());
		MotionLessElement[][] map = this.getViewFrame().getModel().getMap();
		ArrayList<IMobile> mobiles = this.getViewFrame().getModel().getMobiles();
		for(int y = 0; y < map[0].length; y++) {
			for(int x = 0; x < map.length; x++) {
				graphics.drawImage(map[x][y].getImage(), x*64, y*64, 64, 64, this);
			}
		}
		for(int i = mobiles.size()-1; i >= 0; i--) {
			IMobile mobile = mobiles.get(i);
			mobile.move();
			if(map[mobile.getPosition().x][mobile.getPosition().y] instanceof ITouchable) {
				((ITouchable) map[mobile.getPosition().x][mobile.getPosition().y]).onTouch(mobile);
			}
			for(int j = mobiles.size()-1; j >= 0; j--) {
				IMobile mobile2 = mobiles.get(j);
				if(mobile2 instanceof ITouchable && mobile2.getPosition().x == mobile.getPosition().x && mobile2.getPosition().y == mobile.getPosition().y) {
					if(((ITouchable) mobile2).onTouch(mobile)) {
						mobiles.remove(j);
					}
				}
			}
			graphics.drawImage(mobile.getImage(), mobile.getPosition().x*64, mobile.getPosition().y*64, 64, 64, this);
		}
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		graphics.drawString("Score : " + ((IHero) mobiles.get(0)).getScore(), 590, map[0].length*32+20);
		this.repaint();
	}
}
