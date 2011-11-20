package de.raumzeitlabor.pr0nwall.gui;

import java.awt.Color;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

import javax.swing.BorderFactory;
import javax.swing.JSlider;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;

import de.raumzeitlabor.pr0nwall.ds.FrameList;

public class FrameSeeker extends JSlider implements MouseWheelListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3975074419073256219L;
	
	private LEDPanel panel;

	public FrameSeeker(LEDPanel panel) {
		setMajorTickSpacing(5);
		setMinorTickSpacing(1);
		setSnapToTicks(true);
		setPaintTicks(true);
		setPaintLabels(true);
		setMinimum(1);
		setValue(1);
		setMaximum(panel.getNumberOfFrames());
		setBackground(Color.WHITE);
		setBorder(new CompoundBorder(BorderFactory.createMatteBorder(
                0, 0, 0, 1, Color.gray),
                new EmptyBorder(5, 10, 5, 10)));
		
		addMouseWheelListener(this);
		
		this.panel = panel;
	}

	public void refresh() {
		setValue(panel.getCurrentFrameNumber());
		setMaximum(panel.getNumberOfFrames());
	}

	@Override
	public void mouseWheelMoved(MouseWheelEvent e) {
		int newVal = getValue() + e.getWheelRotation();
		
		if (newVal >= 1 && newVal <= panel.getNumberOfFrames()) {
			panel.seekToFrame(newVal);
			refresh();
		}
	}
}
