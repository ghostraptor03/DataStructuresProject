package edu.iastate.cs228.hw;

import java.util.Scanner;
import java.io.FileNotFoundException;

/**
 * @authorZach
 *
 *       The ISPBusiness class performs simulation over a grid plain with cells
 *       occupied by different TownCell types.
 *
 */
public class ISPBusiness {

	/**
	 * Returns a new Town object with updated grid value for next billing cycle.
	 * 
	 * @param tOld: old/current Town object.
	 * @return: New town object.
	 */
	public static Town updatePlain(Town tOld) {
		Town tNew = new Town(tOld.getLength(), tOld.getWidth());
		for (int i = 0; i < tOld.getLength() - 1; i++) {
			for (int z = 0; z < tOld.getWidth() - 1; z++) {
				if (tOld.helper(tOld, i, z) == State.CASUAL) {
					Outage thing = new Outage(tNew, i, z);
					tNew.grid[i][z] = thing;
				}
				if (tOld.helper(tOld, i, z) == State.STREAMER) {
					Outage thing = new Outage(tNew, i, z);
					tNew.grid[i][z] = thing;
				}
				if (tOld.helper(tOld, i, z) == State.RESELLER) {
					Empty thing = new Empty(tNew, i, z);
					tNew.grid[i][z] = thing;
				}
				if (tOld.helper(tOld, i, z) == State.OUTAGE) {
					Empty thing = new Empty(tNew, i, z);
					tNew.grid[i][z] = thing;
				}
				if (tOld.helper(tOld, i, z) == State.EMPTY) {
					Casual thing = new Casual(tNew, i, z);
					tNew.grid[i][z] = thing;
				}
			}
		}

		return tNew;

	}

	/**
	 * Returns the profit for the current state in the town grid.
	 * 
	 * @param town
	 * @return
	 */
	public static int getProfit(Town town) {
		int count = 0;
		for (int i = 0; i < town.getLength(); i++) {
			for (int z = 0; z < town.getWidth(); z++) {
				if (town.helper(town, i, z) == State.CASUAL) {
					count++;
				}

			}
		}
		return (count * 100) / (town.getLength() * town.getWidth());
	}

	/**
	 * Main method. Interact with the user and ask if user wants to specify elements
	 * of grid via an input file (option: 1) or wants to generate it randomly
	 * (option: 2).
	 * 
	 * Depending on the user choice, create the Town object using respective
	 * constructor and if user choice is to populate it randomly, then populate the
	 * grid here.
	 * 
	 * Finally: For 12 billing cycle calculate the profit and update town object
	 * (for each cycle). Print the final profit in terms of %. You should print the
	 * profit percentage with two digits after the decimal point: Example if profit
	 * is 35.5600004, your output should be:
	 *
	 * 35.56%
	 * 
	 * Note that this method does not throw any exception, so you need to handle all
	 * the exceptions in it.
	 * 
	 * @param args
	 * @throws FileNotFoundException
	 * 
	 */
	public static void main(String[] args) throws FileNotFoundException {
		try (Scanner scanner = new Scanner(System.in)) {
			System.out.println("How to populate grid (type 1 or 2): 1 from a file. 2: randomly with a seed");
			int choice = scanner.nextInt();
			if (choice == 1) {
				System.out.println("Please enter a file path");
				String file = scanner.next();
				Town tNew = new Town(file);
				double profit = 0;
				profit += getProfit(tNew);
				for (int i = 1; i < 12; i++) {
					tNew = updatePlain(tNew);
					profit += getProfit(tNew);
				}
				profit = profit / 12;
				String formatted = String.format("%.2f", profit);
				System.out.println(formatted + "%");

			} else if (choice == 2) {
				System.out.println("Provide rows, cols and seed integer separated byspaces:");
				int row = scanner.nextInt();
				int col = scanner.nextInt();
				int seed = scanner.nextInt();
				Town tNew = new Town(row, col);
				tNew.randomInit(seed);
				double profit = 0;
				profit += getProfit(tNew);
				for (int i = 1; i < 12; i++) {
					tNew = updatePlain(tNew);
					profit += getProfit(tNew);
				}
				profit = profit / 12;
				String formatted = String.format("%.2f", profit);
				System.out.println(formatted + "%");

			}
		}
	}

}
