package com.panda.backtracking;

public class MazeProblem {

	private char[][] maze = { 
			{ '-', '-', '-', '-', '-', '#', '-', '-', '-', '-' }, // 0
			{ '-', '-', '-', '-', '-', '#', '-', '-', '#', '-' }, // 1
			{ '-', '-', '#', '#', '#', '#', '#', '-', '#', '-' }, // 2
			{ '-', '-', '#', '-', '-', '-', '#', '-', '#', '-' }, // 3
			{ '-', '-', '#', '-', '#', '-', '#', '-', '#', '-' }, // 4
			{ '-', '-', '#', '-', '#', '-', '-', '-', '#', '-' }, // 5
			{ '-', '-', '#', '-', '#', '#', '#', '#', '#', '-' }, // 6
			{ '-', '-', '#', '-', '-', '-', '-', '-', '#', '-' }, // 7
			{ '-', '-', '#', '#', '#', '#', '-', '#', '#', '-' }, // 8
			{ '-', '-', '-', '-', '-', '-', '-', '#', '#', '-' }  // 9
	};

	private void printMaze() {
		for (int i = 0; i < maze.length; i++) {
			for (int j = 0; j < maze.length; j++) {
				System.out.print(maze[i][j]);
			}
			System.out.println();
		}
	}

	private boolean solveMaze(int i, int j) {
		maze[i][j] = '*';
		if (i == maze.length - 1 && j == maze.length - 1) {
			return true;
		}
		if (isValid(i + 1, j) && solveMaze(i + 1, j)) {
			return true;
		}
		if (isValid(i - 1, j) && solveMaze(i - 1, j)) {
			return true;
		}
		if (isValid(i, j + 1) && solveMaze(i, j + 1)) {
			return true;
		}
		if (isValid(i, j - 1) && solveMaze(i, j - 1)) {
			return true;
		}
		maze[i][j] = '-';
		return false;
	}

	private boolean isValid(int i, int j) {
		return i >= 0 && i < maze.length && j >= 0 && j < maze.length && maze[i][j] == '-';
	}

	public void solve() {
		if (solveMaze(0, 0)) {
			printMaze();
		} else {
			System.out.println("No solution...");
		}
	}

}
