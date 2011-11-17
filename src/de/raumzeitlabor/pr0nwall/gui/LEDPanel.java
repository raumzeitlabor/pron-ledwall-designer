package de.raumzeitlabor.pr0nwall.gui;

import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;

public class LEDPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8818828083394984856L;
	private final int LED_SIZE = 32;
	public boolean mousePressed = false;
	
	public LEDPanel() {
		setLayout(new GridLayout(LED_SIZE, LED_SIZE));
		setBorder(new CompoundBorder(BorderFactory.createLoweredBevelBorder(),
				new EmptyBorder(0, 0, 0, 0)));
		
		GridBagConstraints c = new GridBagConstraints();
		
		for (int i = 1; i <= LED_SIZE*LED_SIZE; i++) {
			add(new LED(this), new GridBagConstraints(0,0,1,1,1,1,GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0,0,0,0),0,0));
		}
	}
}
