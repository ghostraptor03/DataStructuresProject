package edu.iastate.cs228.hw;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Random;
import java.util.Scanner;

/**
 * @authorZach
 *
 */
public class Town {

	private int rows, cols; // Row and col (first and second indices)
	public TownCell[][] grid; // keeps track of the grid
	public char[][] charGrid; // keeps track of the grid using chars

	/**
	 * Constructor to be used when user wants to generate grid randomly, with the
	 * given seed. This constructor does not populate each cell of the grid (but
	 * should assign a 2D array to it).
	 * 
	 * @param length
	 * @param width
	 */
	public Town(int rows, int cols) {
		this.rows = rows;
		this.cols = cols;
		grid = new TownCell[cols][rows];
		charGrid = new char[cols][rows];

	}

	/**
	 * Constructor to be used when user wants to populate grid based on a file.
	 * Please see that it simple throws FileNotFoundException exception instead of
	 * catching it. Ensure that you close any resources (like file or scanner) which
	 * is opened in this function.
	 * 
	 * @param inputFileName
	 * @throws FileNotFoundException
	 */
	public Town(String inputFileName) throws FileNotFoundException {
		File file = new File(inputFileName);
		try (Scanner sc = new Scanner(file)) {
			int c = 0;
			int r = 0;

			rows = sc.nextInt();
			r = rows;

			cols = sc.nextInt();
			c = cols;

			grid = new TownCell[100][100];
			charGrid = new char[100][100];
			Town randomTown = new Town(r, c);
			for (int z = 0; z < r; z++) {
				String wholeLine[] = sc.next().split("");

				for (int x = 0; x < c; x++) {
					char list = wholeLine[x].charAt(0);
					if (list == 'C') {
						Casual Casual = new Casual(randomTown, z, x);
						grid[z][x] = Casual;
						charGrid[z][x] = 'C';
					}
					if (list == 'S') {
						Streamer Streamer = new Streamer(randomTown, z, x);
						grid[z][x] = Streamer;
						charGrid[z][x] = 'S';
					}
					if (list == 'R') {
						Reseller Reseller = new Reseller(randomTown, z, x);
						grid[z][x] = Reseller;
						charGrid[z][x] = 'R';
					}
					if (list == 'E') {
						Empty Empty = new Empty(randomTown, z, x);
						grid[z][x] = Empty;
						charGrid[z][x] = 'E';
					}
					if (list == 'O') {
						Outage Outage = new Outage(randomTown, z, x);
						grid[z][x] = Outage;
						charGrid[z][x] = 'O';
					}

				}
			}
		}

	}

	/**
	 * Returns width of the grid.
	 * 
	 * @return
	 */
	public int getWidth() {
		return cols;
	}

	/**
	 * Returns length of the grid.
	 * 
	 * @return
	 */
	public int getLength() {
		return rows;
	}

	/**
	 * Initialize the grid by randomly assigning cell with one of the following
	 * class object: Casual, Empty, Outage, Reseller OR Streamer
	 */
	public void randomInit(int seed) {
		Random rand = new Random(seed);
		charGrid = new char[100][100];
		for (int z = 0; z < rows; z++) {
			for (int x = 0; x < cols; x++) {
				int newRandomValue = rand.nextInt(5);
				if (newRandomValue == 0) {
					charGrid[z][x] = 'C';
				}
				if (newRandomValue == 1) {
					charGrid[z][x] = 'S';
				}
				if (newRandomValue == 2) {
					charGrid[z][x] = 'R';
				}
				if (newRandomValue == 3) {
					charGrid[z][x] = 'E';
				}
				if (newRandomValue == 4) {
					charGrid[z][x] = 'O';
				}

			}
		}
	}

	/**
	 * Helps return the current state of each cell depending on the type in order to implement the business class
	 * @param c
	 * @param row
	 * @param col
	 * @return
	 */
	public State helper(Town c, int row, int col) {
		if (charGrid[row][col] == 'C') {
			return State.CASUAL;
		}
		if (charGrid[row][col] == 'S') {
			return State.STREAMER;
		}
		if (charGrid[row][col] == 'R') {
			return State.RESELLER;
		}
		if (charGrid[row][col] == 'E') {
			return State.EMPTY;
		}
		if (charGrid[row][col] == 'O') {
			return State.OUTAGE;
		}
		return null;
	}

	/**
	 * Output the town grid. For each square, output the first letter of the cell
	 * type. Each letter should be separated either by a single space or a tab. And
	 * each row should be in a new line. There should not be any extra line between
	 * the rows.
	 */
	@Override
	public String toString() {
		String s = "";
		for (int i = 0; i < rows; i++) {
			for (int z = 0; z < cols; z++) {
				s += charGrid[i][z];
				s += " ";
			}
			s += "\n";
		}
		return s;
	}
}
