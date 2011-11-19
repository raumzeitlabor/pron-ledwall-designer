package de.raumzeitlabor.pr0nwall.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Frame;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;

public class MainFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7779061692730593904L;
	
	private final int FRAME_WIDTH  = 800;
	private final int FRAME_HEIGHT = 600;
	
	private Statusbar statusbar;
	private LEDPanel ledpanel;
	private Toolbar toolbar;
	private Menubar menubar;
	private FrameSeeker frameseeker;
	
	public static MainFrame instance = null;

	public MainFrame() {
		super("Pr0nWall Designer");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(new Dimension(FRAME_WIDTH, FRAME_HEIGHT));
		setLayout(new BorderLayout());
		
		try {
	        UIManager.setLookAndFeel(
	        		UIManager.getCrossPlatformLookAndFeelClassName());
	    } catch (Exception e) { }
		
	    menubar = new Menubar();
	    add(menubar, BorderLayout.NORTH);
	    
		statusbar = new Statusbar();
		add(statusbar, BorderLayout.SOUTH);
		
		JPanel mainpanel = new JPanel();
		mainpanel.setLayout(new BorderLayout());
		
		ArrayList<Frame> framelist = new ArrayList<Frame>();
		framelist.add(new Frame());
		
		ledpanel = new LEDPanel(framelist);
		frameseeker = new FrameSeeker(framelist);
		
		mainpanel.add(ledpanel, BorderLayout.CENTER);
		mainpanel.add(frameseeker, BorderLayout.SOUTH);
		add(mainpanel);
		
		toolbar = new Toolbar();
		add(toolbar, BorderLayout.EAST);
		
//		JSplitPane split = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,
//                mainpanel, toolbar);
//		split.setResizeWeight(1);
//		split.setDividerSize(10);
//		split.setOneTouchExpandable(true);
//		add(split, BorderLayout.CENTER);
		
		setVisible(true);
		instance = this;
	}
	
	
}
