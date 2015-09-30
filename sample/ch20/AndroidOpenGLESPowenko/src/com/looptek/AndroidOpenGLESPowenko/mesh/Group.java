package com.looptek.AndroidOpenGLESPowenko.mesh;

import java.util.Vector;

import javax.microedition.khronos.opengles.GL10;

public class Group extends Mesh {
	private Vector<Mesh> children = new Vector<Mesh>();
	
	@Override
	public void draw(GL10 gl) {
		int size = children.size();
		for( int i = 0; i < size; i++)
			children.get(i).draw(gl);
	}

	
	public void add(int location, Mesh object) {
		children.add(location, object);
	}

	
	public boolean add(Mesh object) {
		return children.add(object);
	}

	
	public void clear() {
		children.clear();
	}

	public Mesh get(int location) {
		return children.get(location);
	}

	
	public Mesh remove(int location) {
		return children.remove(location);
	}

	
	public boolean remove(Object object) {
		return children.remove(object);
	}

	
	public int size() {
		return children.size();
	}
	
	
}
