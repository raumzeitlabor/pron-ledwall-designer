package de.raumzeitlabor.pr0nwall.gui;

import java.awt.Color;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import java.awt.Insets;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class LEDPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8818828083394984856L;
	
	private final int PANEL_SIZE = 32;
	
	public boolean mousePressed = false;
	private ArrayList<Frame> framelist;
	
	public LEDPanel(ArrayList<Frame> framelist) {
		
		setLayout(new GridLayout(PANEL_SIZE, PANEL_SIZE));
		setBorder(BorderFactory.createMatteBorder(
                0, 0, 0, 1, Color.gray));
		setBackground(Color.WHITE);
		
		GridBagConstraints c = new GridBagConstraints();
		for (int i = 1; i <= PANEL_SIZE*PANEL_SIZE; i++) {
			add(new LED(this), new GridBagConstraints(0, 0, 1, 1, 1, 1,
					GridBagConstraints.CENTER, GridBagConstraints.BOTH,
					new Insets(0, 0, 0, 0), 0, 0));
		}
		
		this.framelist = framelist;
	}

	public ArrayList<Frame> getFrames() {
		return framelist;
	}
}
