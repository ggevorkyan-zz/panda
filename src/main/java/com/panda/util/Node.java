package com.panda.util;

import java.util.HashSet;
import java.util.Set;

public class Node {

	public Character id;
	public Color color = null;
	public Set<Node> edges = new HashSet<Node>();

	public Node(char id) {
		this.id = id;
	}

	@Override
	public int hashCode() {
		return id.hashCode();
	}

	@Override
	public boolean equals(Object other) {
		return this.id.equals(((Node) other).id);
	}

	@Override
	public String toString() {
		return id + (color == null ? "" : " - " + color);
	}

}
