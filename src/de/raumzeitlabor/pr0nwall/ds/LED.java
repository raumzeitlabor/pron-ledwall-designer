package de.raumzeitlabor.pr0nwall.ds;

import java.awt.Shape;


public class LED {
	private boolean enabled = false;

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	
	public boolean toggleEnabled() {
		this.enabled = !this.enabled;
		return this.enabled;
	}
}
