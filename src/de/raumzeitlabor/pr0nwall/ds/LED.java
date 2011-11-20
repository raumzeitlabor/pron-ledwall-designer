package de.raumzeitlabor.pr0nwall.ds;

import java.awt.Shape;


public class LED {
	private boolean enabled = false;
	private Shape shape;

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	
	public void toggleEnabled() {
		this.enabled = !this.enabled;
	}

	public boolean hasShape() {
		return shape != null;
	}

	public void setShape(Shape s) {
		this.shape = s;
	}

	public Shape getShape() {
		return shape;
	}
}
