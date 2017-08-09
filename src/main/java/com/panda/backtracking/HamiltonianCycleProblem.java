package com.panda.backtracking;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class HamiltonianCycleProblem {

	class Node {
		Character id;
		Set<Node> edges = new HashSet<Node>();

		public Node(char id) {
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
	}

	private Set<Character> visited = new LinkedHashSet<Character>();
	private int SIZE = 6;
	private Node a = new Node('a');

	public HamiltonianCycleProblem() {
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
		visited.add(n.id);
		if (visited.size() == SIZE) {
			return n.edges.contains(a);
		}
		for (Node edge : n.edges) {
			if (!visited.contains(edge.id) && solve(edge)) {
				return true;
			}
		}
		visited.remove(n.id);
		return false;
	}

	public void solve() {
		if (solve(a)) {
			System.out.println(visited);
		} else {
			System.out.println("No solution...");
		}
	}

}
