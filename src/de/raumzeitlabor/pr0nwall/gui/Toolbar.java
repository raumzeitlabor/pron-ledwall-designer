package de.raumzeitlabor.pr0nwall.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

public class Toolbar extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6353475337784152259L;
	private JSlider ledbrightness;
	private JSlider duration;

	public Toolbar() {
		Dimension d = new Dimension(220, 0);
		setPreferredSize(d);
		setMinimumSize(d);
		setSize(d);
		
		setLayout(new BorderLayout());
		
		BufferedImage logo = null;
		try {
			logo = ImageIO.read(new File("res/logo.png")); //XXX
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		JLabel header = new JLabel(new ImageIcon(logo));
		header.setBorder(new EmptyBorder(5, 0, 0, 0));
		add(header, BorderLayout.NORTH);
		
		JPanel mainpanel = new JPanel();
		
		/*
		 * LED settings
		 */
		JPanel ledsettings = new JPanel();
		ledsettings.setBorder(new TitledBorder(
				BorderFactory.createMatteBorder(1, 0, 0, 0, Color.LIGHT_GRAY), "LED Brightness"));
		
		ledbrightness = new JSlider();
		ledbrightness.setMinimum(1);
		ledbrightness.setMaximum(8);
		ledbrightness.setMinorTickSpacing(1);
		ledbrightness.setPaintTicks(true);
		ledbrightness.setSnapToTicks(true);
		ledsettings.add(ledbrightness);
		
		mainpanel.add(ledsettings);
		
		/*
		 * Frame settings
		 */
		JPanel framesettings = new JPanel();
		framesettings.setBorder(new TitledBorder(
				BorderFactory.createMatteBorder(1, 0, 0, 0, Color.LIGHT_GRAY), "Frame Duration"));
		
		duration = new JSlider();
		duration.setMinimum(100);
		duration.setMaximum(10000);
		duration.setMinorTickSpacing(200);
		duration.setMajorTickSpacing(1000);
		duration.setPaintTicks(true);
		framesettings.add(duration);
		
		mainpanel.add(framesettings);
		
		add(mainpanel, BorderLayout.CENTER);		
		
		/*
		 * FrameButtons
		 */
		JPanel framecontrol = new JPanel();
		framecontrol.setBorder(new TitledBorder(
				BorderFactory.createMatteBorder(1, 0, 0, 0, Color.LIGHT_GRAY), "Frames"));
		
		JButton newframebtn = new JButton("New");
		JButton playanimbtn = new JButton("Play");
		JButton delframebtn = new JButton("Del");
		
		framecontrol.add(newframebtn);
		framecontrol.add(playanimbtn);
		framecontrol.add(delframebtn);
		
		add(framecontrol, BorderLayout.SOUTH);
	}
}
