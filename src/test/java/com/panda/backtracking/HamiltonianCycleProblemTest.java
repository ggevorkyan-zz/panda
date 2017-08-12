package com.panda.backtracking;

import org.junit.Test;

import com.panda.util.Node;

public class HamiltonianCycleProblemTest {

	@Test
	public void testSolve() {
		Node a = new Node('a');
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

		new HamiltonianCycleProblem(a, 6).solve();
	}

}
