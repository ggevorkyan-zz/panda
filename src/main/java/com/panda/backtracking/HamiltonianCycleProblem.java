package com.panda.backtracking;

import java.util.LinkedHashSet;
import java.util.Set;

import com.panda.util.Node;

public class HamiltonianCycleProblem {

	private Set<Character> visited = new LinkedHashSet<Character>();
	private Node root;
	private int nodeCount;

	public HamiltonianCycleProblem(Node root, int nodeCount) {
		this.root = root;
		this.nodeCount = nodeCount;
	}

	private boolean solve(Node n) {
		visited.add(n.id);
		if (visited.size() == nodeCount) {
			return n.edges.contains(root);
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
		if (solve(root)) {
			System.out.println(visited);
		} else {
			System.out.println("No solution...");
		}
	}

}
