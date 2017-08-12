package com.panda.backtracking;

import java.util.LinkedHashSet;
import java.util.Set;

import com.panda.util.Color;
import com.panda.util.Node;

public class GraphColoringProblem {

	private Set<Node> visited = new LinkedHashSet<Node>();
	private Color[] COLORS = new Color[] { Color.RED, Color.GREEN, Color.BLUE };
	
	private Node root;
	private int nodeCount;
	
	public GraphColoringProblem(Node root, int nodeCount) {
		this.root = root;
		this.nodeCount = nodeCount;
	}

	private boolean solve(Node n) {
		if (visited.size() == nodeCount) {
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
		if (solve(root)) {
			System.out.println(visited);
		} else {
			System.out.println("No solution...");
		}
	}

}
