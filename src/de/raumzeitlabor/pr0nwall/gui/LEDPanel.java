package de.raumzeitlabor.pr0nwall.gui;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;

import de.raumzeitlabor.pr0nwall.ds.Frame;
import de.raumzeitlabor.pr0nwall.ds.FrameList;
import de.raumzeitlabor.pr0nwall.ds.LED;

public class LEDPanel extends JPanel implements MouseListener, MouseMotionListener, MouseWheelListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8818828083394984856L;

	private PositioningHelper helper;
	
	private int current_frame = 0;
	private FrameList framelist;
	private FrameSeeker seeker;
	
	private final Color C_LED_ENABLED = Color.RED;
	private final Color C_LED_DISABLED = new Color(255, 191, 207);
	
	private int dragLedPos = -1;
	
	public LEDPanel(FrameList framelist) {
		this.helper = new PositioningHelper((int) Math.sqrt(framelist.getDots()));
		this.framelist = framelist;

		addMouseListener(this);
		addMouseWheelListener(this);
		addMouseMotionListener(this);
		
		setBackground(Color.WHITE);
		setBorder(new CompoundBorder(BorderFactory.createMatteBorder(
                0, 0, 0, 1, Color.gray),
                new EmptyBorder(5, 10, 5, 10)));
	}
	
	public void setFrameSeeker(FrameSeeker seeker) {
		this.seeker = seeker;
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		
		int width = getWidth();
		int height = getHeight();
		
		helper.update(width, height);
		double led_size = helper.getLEDSize();
		
		for (int i = 0; i < framelist.getDots(); i++) {
			Point p = helper.getLEDPosition(i);
						
			Shape shape = new Ellipse2D.Double(p.getX(), p.getY(), led_size, led_size);
			getLED(i).setShape(shape);
			
			if (!getLED(i).isEnabled())
				g2.setPaint(C_LED_DISABLED);
			else
				g2.setPaint(C_LED_ENABLED);
			
			g2.fill(shape);
			g2.setPaint(Color.GRAY);
			g2.draw(shape);
			
//			g2.drawOval((int)posX, (int)posY, (int)led_size, (int) led_size);
		}
	}

	public FrameList getFrames() {
		return framelist;
	}

	public int getNumberOfFrames() {
		return framelist.getFrames().size();
	}
	
	public Frame getCurrentFrame() {
		return framelist.getFrames().get(current_frame);
	}
	
	public int getCurrentFrameNumber() {
		return current_frame + 1;
	}
	
	public void prevFrame() {
		if (current_frame > 0) {
			current_frame--;
			repaint();
		}
	}
	
	public void nextFrame() {
		if (current_frame < framelist.getFrames().size() - 1) {
			current_frame++;
			repaint();
		}
	}
	
	public void seekToFrame(int i) {
		if (i > 0 && i <= framelist.getFrames().size()) { 
			current_frame = i - 1;
			repaint();
		}
	}
	
	public LED getLED(int pos) {
		return framelist.getFrames().get(current_frame).getLEDs().get(pos);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		Graphics2D g2 = (Graphics2D) getGraphics();
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		
		int ledNo = helper.getLEDNumber(e.getPoint());
		
		if (ledNo != -1) {
			LED l = getLED(ledNo);
			Shape s = l.getShape();
			if (s.contains(e.getPoint())) {
				l.toggleEnabled();
				g2.setColor(l.isEnabled() ? C_LED_ENABLED : C_LED_DISABLED);
				g2.fill(s);
				g2.setPaint(Color.GRAY);
				g2.draw(s);
			}
		}
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {}

	@Override
	public void mouseExited(MouseEvent arg0) {}

	@Override
	public void mousePressed(MouseEvent arg0) {}

	@Override
	public void mouseReleased(MouseEvent arg0) {}
	
	@Override
	public void mouseWheelMoved(MouseWheelEvent e) {
		int newVal = seeker.getValue() + e.getWheelRotation();
		
		if (newVal >= 1 && newVal <= getNumberOfFrames()) {
			seekToFrame(newVal);
			seeker.refresh();
		}
	}
	
	@Override
	public void mouseDragged(MouseEvent e) {
		int ledPos = helper.getLEDNumber(e.getPoint());
		
//		if (dragLedPos != ledPos) {
			dragLedPos = ledPos;
			mouseClicked(e);
//		}
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		int ledNo = helper.getLEDNumber(e.getX(), e.getY());
		
		if (ledNo != -1) {
			if (getLED(ledNo).getShape().contains(e.getPoint())) {
				setCursor(new Cursor(Cursor.HAND_CURSOR));
				return;
			}
		}
		
		setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
	}
	
	private class PositioningHelper {
		private final int MIN_PADDING = 20;
		private final int dotsPerRow;
		
		private double availableSize;
		private double ledSpacer;
		private double ledSize;
		
		private double hspacer;
		private double vspacer;
		
		public PositioningHelper(int dots) {
			this.dotsPerRow = dots;
		}

		public void update(int width, int height) {
			availableSize = Math.min(width, height) - 2 * MIN_PADDING;
			
			ledSpacer = availableSize / (dotsPerRow * 3);
			ledSize = (availableSize - (dotsPerRow - 1) * ledSpacer) / dotsPerRow;
			
			vspacer = (width <= height) ? (height - availableSize - 2 * MIN_PADDING) / 2 : 0;
			hspacer = (width >= height) ? (width  - availableSize - 2 * MIN_PADDING) / 2 : 0;
		}
		
		public double getAvailableSize() {
			return availableSize;
		}
		
		public Point getLEDPosition(int num) {		
			double posX = MIN_PADDING + hspacer;
			double posY = MIN_PADDING + vspacer;
			
			double baseX = posX;
			
			if (num % dotsPerRow != 0)
				posX += (ledSize + ledSpacer) * (num % dotsPerRow);
			else
				posX = baseX;
			
			if (num / dotsPerRow > 0) {
				posY += (ledSize + ledSpacer) * (num / dotsPerRow);
			}
			
			Point p = new Point();
			p.setLocation(posX, posY);
			
			return p;
		}
		
		public int getLEDNumber(int x, int y) {	
			double posX = MIN_PADDING + hspacer;
			double posY = MIN_PADDING + vspacer;
			
			if (x < posX || y < posY || x > (posX + availableSize)
					|| y > (posY + availableSize))
				return -1;
			
			double deltaX = x - posX;
			double deltaY = y - posY;
			
			int ledX = (int) (deltaX / (ledSize + ledSpacer));
			int ledY = (int) (deltaY / (ledSize + ledSpacer));
			int ledPos = ledX + ledY * dotsPerRow;
			
			return ledPos;
		}
		
		public int getLEDNumber(Point p) {
			return getLEDNumber((int) p.getX(), (int) p.getY());
		}

		public double getLEDSize() {
			return ledSize;
		}
	}
}
