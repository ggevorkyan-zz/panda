package com.panda.backtracking;

import com.panda.util.ArrayUtils;

public class SudokuProblem {

	private int[][] board;

	public SudokuProblem(int[][] board) {
		this.board = board;
	}

	private boolean solveSudoku(int row, int col) {
		if (row == board.length) {
			if (++col == board.length) {
				return true;
			}
			row = 0;
		}
		if (board[row][col] != 0) {
			return solveSudoku(row + 1, col);
		}
		for (int num = 1; num <= 9; num++) {
			if (isValid(row, col, num)) {
				board[row][col] = num;
				if (solveSudoku(row + 1, col)) {
					return true;
				}
				board[row][col] = 0;
			}
		}
		return false;
	}

	private boolean isValid(int row, int col, int num) {
		for (int i = 0; i < board.length; i++) {
			if (board[row][i] == num) {
				return false;
			}
			if (board[i][col] == num) {
				return false;
			}
		}
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (board[row / 3 * 3 + i][col / 3 * 3 + j] == num) {
					return false;
				}
			}
		}
		return true;
	}

	public void solve() {
		if (solveSudoku(0, 0)) {
			ArrayUtils.printMatrix(board);
		} else {
			System.out.println("No solution...");
		}
	}

}
