package de.raumzeitlabor.pr0nwall.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class Toolbar extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6353475337784152259L;

	public Toolbar() {
		setPreferredSize(new Dimension(200, 0));
		setLayout(new BorderLayout());
		
		JLabel header = new JLabel("Toolbar");		
		add(header, BorderLayout.NORTH);
	}
}
