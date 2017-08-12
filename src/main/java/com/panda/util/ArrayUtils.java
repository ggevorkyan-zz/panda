package com.panda.util;

public class ArrayUtils {

	public static <T> void printMatrix(T[][] a) {
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a.length; j++) {
				System.out.print(a[i][j] + " ");
			}
			System.out.println();
		}
	}

}
