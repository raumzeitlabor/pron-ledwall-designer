package de.raumzeitlabor.pr0nwall.ds;

import java.util.LinkedList;
import java.util.List;

public class FrameList {
	private final int dots;
	private final LinkedList<Frame> framelist;
	
	public FrameList(int dots) {
		this(dots, 1);
	}
	
	public FrameList(int dots, int frames) {
		this.dots = dots;

		framelist = new LinkedList<Frame>();
		for (int i = 0; i < frames; i++) {
			framelist.add(new Frame(dots));
		}
	}

	public int getDots() {
		return dots;
	}
	
	public List<Frame> getFrames() {
		return framelist;
	}

	public void addFrame() {
		framelist.add(new Frame(dots));
	}

	public void addFrame(int pos) {
		framelist.add(pos - 1, new Frame(dots));
	}

	public void deleteFrame(int i) {
		framelist.remove(i);
	}
}
