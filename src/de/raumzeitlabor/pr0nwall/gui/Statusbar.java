package de.raumzeitlabor.pr0nwall.gui;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;

public class Statusbar extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5066509705826501929L;

	private JLabel statuslabel;
	private JProgressBar progressbar;

	public Statusbar() {
		setLayout(new BorderLayout());
		
		statuslabel = new JLabel();
		statuslabel.setText("Ready.");
		add(statuslabel, BorderLayout.WEST);

		progressbar = new JProgressBar();
		add(progressbar, BorderLayout.EAST);
		
//		setBorder(new EmptyBorder(3, 3, 3, 3));
		setBorder(new CompoundBorder(BorderFactory.createMatteBorder(
                1, 0, 0, 0, Color.gray),
                new EmptyBorder(3, 3, 3, 3)));
//		setBorder(BorderFactory.createRaisedBevelBorder());
	}
}
