package de.raumzeitlabor.pr0nwall.ds;

import java.util.ArrayList;


public class Frame {
	private ArrayList<LED> leds;
	
	public Frame(int dots) {
		leds = new ArrayList<LED>(dots);
		
		for (int i = 0; i < dots; i++) {
			leds.add(new LED());
		}
	}

	public ArrayList<LED> getLEDs() {
		return leds;
	}
	
}
