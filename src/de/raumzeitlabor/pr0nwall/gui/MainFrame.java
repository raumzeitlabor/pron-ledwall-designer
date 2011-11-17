package de.raumzeitlabor.pr0nwall.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.UIManager;

public class MainFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7779061692730593904L;
	
	private final int FRAME_WIDTH  = 800;
	private final int FRAME_HEIGHT = 600;
	
	private Statusbar statusbar;
	private LEDPanel panel;
	private Toolbar toolbar;

	public MainFrame() {
		super("Pr0nWall Designer");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(new Dimension(FRAME_WIDTH, FRAME_HEIGHT));
		setLayout(new BorderLayout());
		
		try {
	        UIManager.setLookAndFeel(
	        		UIManager.getCrossPlatformLookAndFeelClassName());
	    } catch (Exception e) { }
		
		statusbar = new Statusbar();
		add(statusbar, BorderLayout.SOUTH);
		
		panel = new LEDPanel();
		add(panel, BorderLayout.CENTER);
		
		toolbar = new Toolbar();
		add(toolbar, BorderLayout.EAST);
		
		setVisible(true);
	}
	
	
}
