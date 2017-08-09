package com.panda.backtracking;

public class EightQueensProblem {

	private static int BOARD_SIZE = 8;
	private static char[][] board = new char[BOARD_SIZE][BOARD_SIZE];

	public EightQueensProblem() {
		for (int i = 0; i < BOARD_SIZE; i++) {
			for (int j = 0; j < BOARD_SIZE; j++) {
				board[i][j] = '-';
			}
		}
	}

	private boolean solveEightQueensProblem(int col) {
		if (col == BOARD_SIZE) {
			return true;
		}
		for (int row = 0; row < BOARD_SIZE; row++) {
			board[row][col] = '*';
			if (isValid(row, col) && solveEightQueensProblem(col + 1)) {
				return true;
			}
			board[row][col] = '-';
		}
		return false;
	}

	private boolean isValid(int row, int col) {
		for (int i = 0; i < BOARD_SIZE; i++) {
			if (i != col && board[row][i] == '*') {
				return false;
			}
		}
		for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
			if (board[i][j] == '*') {
				return false;
			}
		}
		for (int i = row + 1, j = col - 1; i < BOARD_SIZE && j >= 0; i++, j--) {
			if (board[i][j] == '*') {
				return false;
			}
		}
		return true;
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
		if (solveEightQueensProblem(0)) {
			printBoard();
		} else {
			System.out.println("No solution...");
		}
	}

}
