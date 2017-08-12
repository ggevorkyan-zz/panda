package com.panda.dynamic;

import java.util.HashMap;
import java.util.Map;

public class FibonacciNumbers {

	@SuppressWarnings("serial")
	private Map<Long, Long> cache = new HashMap<Long, Long>() {
		{
			put(0L, 0L);
			put(1L, 1L);
		}
	};

	public long fibonacci(long n) {
		if (n < 0) {
			// overflow?
			throw new IllegalArgumentException("Argument is < 0");
		}
		if (cache.containsKey(n)) {
			return cache.get(n);
		}
		long prev2 = fibonacci(n - 2);
		cache.put(n - 2, prev2);
		long prev1 = fibonacci(n - 1);
		cache.put(n - 1, prev1);
		cache.put(n, prev1 + prev2);
		return prev1 + prev2;
	}

}
