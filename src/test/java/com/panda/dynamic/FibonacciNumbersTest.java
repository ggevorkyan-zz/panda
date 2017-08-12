package com.panda.dynamic;

import org.junit.Test;

public class FibonacciNumbersTest {
	
	@Test
	public void testFibonacci() {
		FibonacciNumbers fibonacciNumbers = new FibonacciNumbers();
		System.out.println(fibonacciNumbers.fibonacci(5));
		System.out.println(fibonacciNumbers.fibonacci(25));
	}

}
