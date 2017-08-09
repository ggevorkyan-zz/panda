package com.panda.backtracking;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class GraphColoringProblem {

	class Node {
		Character id;
		Color color = null;
		Set<Node> edges = new HashSet<Node>();

		Node(char id) {
			this.id = id;
		}

		@Override
		public int hashCode() {
			return id.hashCode();
		}

		@Override
		public boolean equals(Object other) {
			return this.id.equals(other);
		}

		@Override
		public String toString() {
			return id + " - " + (color == null ? "" : color);
		}
	}

	enum Color {
		RED, GREEN, BLUE, YELLOW
	};

	private Set<Node> visited = new LinkedHashSet<Node>();
	private int NUMBER_OF_NODES = 6;
	private Color[] COLORS = new Color[] { Color.RED, Color.GREEN, Color.BLUE };
	private Node a = new Node('a');

	public GraphColoringProblem() {
		Node b = new Node('b');
		Node c = new Node('c');
		Node d = new Node('d');
		Node e = new Node('e');
		Node o = new Node('o');
		a.edges.add(b);
		a.edges.add(d);
		a.edges.add(o);
		b.edges.add(a);
		b.edges.add(c);
		b.edges.add(e);
		b.edges.add(o);
		c.edges.add(b);
		c.edges.add(d);
		c.edges.add(e);
		c.edges.add(o);
		d.edges.add(a);
		d.edges.add(c);
		d.edges.add(o);
		o.edges.add(a);
		o.edges.add(b);
		o.edges.add(c);
		o.edges.add(d);
		e.edges.add(b);
		e.edges.add(c);
	}

	private boolean solve(Node n) {
		if (visited.size() == NUMBER_OF_NODES) {
			return true;
		}
		for (Color color : COLORS) {
			if (isValidColor(n, color)) {
				n.color = color;
				visited.add(n);
				boolean result = true;
				for (Node edge : n.edges) {
					if (!visited.contains(edge)) {
						result = result && solve(edge);
					}
				}
				if (result) {
					return true;
				}
			}
		}
		return false;
	}

	private boolean isValidColor(Node n, Color color) {
		for (Node edge : n.edges) {
			if (edge.color == color) {
				return false;
			}
		}
		return true;
	}

	public void solve() {
		if (solve(a)) {
			System.out.println(visited);
		} else {
			System.out.println("No solution...");
		}
	}

}
