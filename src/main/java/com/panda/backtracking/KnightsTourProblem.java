package com.panda.backtracking;

public class KnightsTourProblem {

	private int BOARD_SIZE = 8;
	private int[][] board = new int[BOARD_SIZE][BOARD_SIZE];
	private int[] xMoves = { 2, 1, -1, -2, -2, -1, 1, 2 };
	private int[] yMoves = { 1, 2, 2, 1, -1, -2, -2, -1 };

	private boolean isValidStep(int x, int y) {
		return x >= 0 && x < BOARD_SIZE && y >= 0 && y < BOARD_SIZE && board[x][y] == 0;
	}

	private boolean solveKnightsTour(int step, int x, int y) {
		if (step == (BOARD_SIZE * BOARD_SIZE + 1)) {
			return true;
		}

		for (int i = 0; i < xMoves.length; i++) {
			int nextX = x + xMoves[i];
			int nextY = y + yMoves[i];
			if (isValidStep(nextX, nextY)) {
				board[nextX][nextY] = step;
				if (solveKnightsTour(step + 1, nextX, nextY)) {
					return true;
				}
				board[nextX][nextY] = 0;
			}
		}
		return false;
	}

	private void printBoard() {
		for (int i = 0; i < BOARD_SIZE; i++) {
			for (int j = 0; j < BOARD_SIZE; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
	}

	public void solve() {
		board[0][0] = 1;
		if (solveKnightsTour(2, 0, 0)) {
			printBoard();
		} else {
			System.out.println("No solution...");
		}
	}

}
