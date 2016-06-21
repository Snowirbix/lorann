package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

import contract.IHero;
import contract.IMobile;
import contract.IModel;
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

	/**
	 * Diplay the map from the recovery of the database
	 *
	 * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
	 * 
	 */
	@Override
	protected void paintComponent(final Graphics graphics) {
		graphics.clearRect(0, 0, this.getWidth(), this.getHeight());
		IModel model = this.getViewFrame().getModel();
		MotionLessElement[][] map = model.getMap();
		ArrayList<IMobile> mobiles = model.getMobiles();
		IHero hero = model.getHero();;
		
		if(map != null) {
			graphics.setColor(new Color(246, 250, 251));
			graphics.fillRect(0, 0, this.getViewFrame().getWidth(), this.getViewFrame().getHeight());
			
			for(int y = 0; y < map[0].length; y++) {
				for(int x = 0; x < map.length; x++) {
					graphics.drawImage(map[x][y].getImage(), x*32, y*32, 32, 32, this);
				}
			}
			for(int i = mobiles.size()-1; i >= 0; i--) {
				if(i >= mobiles.size() && i > 0) {
					i--;
				}
				if(i != -1) {
					IMobile mobile = mobiles.get(i);
					Point postPosition = mobile.move();
					if(map[mobile.getPosition().x][mobile.getPosition().y] instanceof ITouchable) {
						((ITouchable) map[mobile.getPosition().x][mobile.getPosition().y]).onTouch(mobile);
					}
					for(int j = mobiles.size()-1; j >= 0; j--) {
						if(j >= mobiles.size()) {
							j--;
						}
						if(j != -1) {
							IMobile mobile2 = mobiles.get(j);
							if(mobile2 instanceof ITouchable &&
							(mobile2.getPosition().x == mobile.getPosition().x && mobile2.getPosition().y == mobile.getPosition().y)
							|| (mobile2.getPosition().x == postPosition.x && mobile2.getPosition().y == postPosition.y)) {
								if(((ITouchable) mobile2).onTouch(mobile)) {
										mobiles.remove(mobile2);
								}
							}
						}
					}
					graphics.drawImage(mobile.getImage(), mobile.getPosition().x*32, mobile.getPosition().y*32, 32, 32, this);
				}
			}

			graphics.setColor(new Color(41, 128, 185));
			graphics.fillRect(0, map[0].length*32, map.length*32/2, 60);
			graphics.setColor(new Color(22, 160, 133));
			graphics.fillRect(map.length*32/2, map[0].length*32, map.length*32/2, 60);
			graphics.setColor(new Color(52, 73, 94));
			graphics.fillRect(0, map[0].length*32+60, map.length*32, 60);

			graphics.setFont(new Font("Calibri", Font.BOLD, 36));
			graphics.setColor(new Color(236, 240, 241));
			graphics.drawString("Score : " + (hero.getScore()+model.getSave().getScore()), 100, map[0].length*32+40);
			graphics.drawString("Life : " + model.getSave().getLife(), 450, map[0].length*32+40);
			graphics.drawString(model.getMessage(), 250, map[0].length*32+100);
		} else {
			graphics.setFont(new Font("Calibri", Font.BOLD, 36));
			graphics.drawString("Best score : " + model.getHighScore().getScore(), 800, 450); 
		}
	}
}
