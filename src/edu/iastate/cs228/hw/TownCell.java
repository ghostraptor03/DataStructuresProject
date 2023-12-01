package edu.iastate.cs228.hw;

import java.util.Objects;

/**
 * 
 * @authorZach
 *
 */
public abstract class TownCell {

	protected Town plain;
	protected int row;
	protected int col;

	// constants to be used as indices.
	protected static final int RESELLER = 0;
	protected static final int EMPTY = 1;
	protected static final int CASUAL = 2;
	protected static final int OUTAGE = 3;
	protected static final int STREAMER = 4;

	public static final int NUM_CELL_TYPE = 5;

	// Use this static array to take census.
	public static final int[] nCensus = new int[NUM_CELL_TYPE];

	public TownCell(Town p, int r, int c) {
		plain = p;
		row = r;
		col = c;
	}

	/**
	 * Checks all neigborhood cell types in the neighborhood. Refer to homework pdf
	 * for neighbor definitions (all adjacent neighbors excluding the center cell).
	 * Use who() method to get who is present in the neighborhood
	 * 
	 * @param counts of all customers
	 */
	public void census(int nCensus[]) {
		// zero the counts of all customers
		nCensus[RESELLER] = 0;
		nCensus[EMPTY] = 0;
		nCensus[CASUAL] = 0;
		nCensus[OUTAGE] = 0;
		nCensus[STREAMER] = 0;

		// TODO: Write your code here.

		int[] rows = { -1, -1, -1, 0, 0, 1, 1, 1 };
		int[] cols = { -1, 0, 1, -1, 1, -1, 0, 1 };

		for (int z = 0; z < 8; z++) {
			int nextRow = row + rows[z];
			int nextCol = col + cols[z];
			TownCell nextTo = plain.grid[nextRow][nextCol];
			State type = nextTo.who();
			if (type == State.RESELLER) {
				nCensus[RESELLER]++;
			}
			if (type == State.EMPTY) {
				nCensus[EMPTY]++;
			}
			if (type == State.CASUAL) {
				nCensus[CASUAL]++;
			}
			if (type == State.OUTAGE) {
				nCensus[OUTAGE]++;
			}
			if (type == State.STREAMER) {
				nCensus[STREAMER]++;
			}

		}
	}

	/**
	 * Gets the identity of the cell.
	 * 
	 * @return State
	 */
	public abstract State who();

	/**
	 * Determines the cell type in the next cycle.
	 * 
	 * @param tNew: town of the next cycle
	 * @return TownCell
	 */
	public abstract TownCell next(Town tNew);
}
