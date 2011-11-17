package de.raumzeitlabor.pr0nwall.gui;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Ellipse2D;

import javax.swing.JComponent;

public class LED extends JComponent implements MouseListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5698663633870675134L;
	
	final static BasicStroke stroke = new BasicStroke(2.0f);
	
	private Shape ellipsis;
	private boolean enabled = false;
	private LEDPanel ledpanel;
	
	public LED(LEDPanel parent) {
		ledpanel = parent;
		addMouseListener(this);
	}
	
	public void paint(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		
		int posX = getWidth()/4;
		int posY = getHeight()/4;
		
		ellipsis = new Ellipse2D.Double(posX, posY, getWidth()*0.45, getWidth()*0.45);
		
		if (!enabled) {
			g2.setPaint(new Color(255, 191, 207));
		} else {
			g2.setPaint(Color.RED);
		}
		
		g2.fill(ellipsis);
		g2.setPaint(Color.GRAY);
		g2.draw(ellipsis);
	}

	@Override
	public void mouseClicked(MouseEvent e) {}

	@Override
	public void mouseEntered(MouseEvent e) {}

	@Override
	public void mouseExited(MouseEvent e) {}

	@Override
	public void mousePressed(MouseEvent e) {
		ledpanel.mousePressed = true;
		
		if (ellipsis.contains(e.getX(), e.getY())) {
			enabled = !enabled;
			repaint();
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		ledpanel.mousePressed = false;
	}
	
	public boolean isEnabled() {
		return enabled;
	}
}
