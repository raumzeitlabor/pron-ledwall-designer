package de.raumzeitlabor.pr0nwall.gui;

import java.awt.Color;
import java.awt.Frame;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JSlider;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;

public class FrameSeeker extends JSlider {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3975074419073256219L;
	
	private ArrayList<Frame> framelist = null;

	public FrameSeeker(ArrayList<Frame> framelist) {
		setMajorTickSpacing(5);
		setMinorTickSpacing(1);
		setSnapToTicks(true);
		setPaintTicks(true);
//		setPaintLabels(true);
		setMinimum(1);
		setMaximum(framelist.size());
		setBackground(Color.WHITE);
		setBorder(new CompoundBorder(BorderFactory.createMatteBorder(
                0, 0, 0, 1, Color.gray),
                new EmptyBorder(5, 10, 5, 10)));
		
		this.framelist = framelist;
	}
}
