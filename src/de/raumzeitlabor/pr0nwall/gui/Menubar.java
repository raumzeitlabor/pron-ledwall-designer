package de.raumzeitlabor.pr0nwall.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class Menubar extends JMenuBar {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8702818468640225167L;
	
	private JMenu filemenu;
	private JMenu helpmenu;

	private JMenu framemenu;

	public Menubar() {
		/*
		 * File Menu
		 */
		filemenu = new JMenu("File");
		
		JMenuItem openitem = new JMenuItem("Open");
		openitem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
			}
		});
		filemenu.add(openitem);
		
		JMenuItem saveitem = new JMenuItem("Save");
		saveitem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
			}
		});
		filemenu.add(saveitem);

		JMenuItem exititem = new JMenuItem("Exit");
		exititem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				MainFrame.instance.dispose();
			}
		});
		filemenu.add(exititem);

		/*
		 * Frame Menu
		 */
		framemenu = new JMenu("Frame");
		
		JMenuItem importitem = new JMenuItem("Import");
		importitem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
			}			
		});
		framemenu.add(importitem);
		
		JMenuItem exportitem = new JMenuItem("Export");
		exportitem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
			}
		});
		framemenu.add(exportitem);
		
		/*
		 * Help Menu
		 */
		helpmenu = new JMenu("Help");
		
		JMenuItem aboutitem = new JMenuItem("About");
		aboutitem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
			}
		});
		helpmenu.add(aboutitem);
		
		add(filemenu);
		add(framemenu);
		add(helpmenu);
	}
}
