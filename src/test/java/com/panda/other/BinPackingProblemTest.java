package com.panda.other;

import java.util.Arrays;

import org.junit.Test;

public class BinPackingProblemTest {

	@Test
	public void testSolve() {
		new BinPackingProblem(10, Arrays.asList(new Integer[]{2, 15, 10, 5, 4})).solve();;
	}
	
}
