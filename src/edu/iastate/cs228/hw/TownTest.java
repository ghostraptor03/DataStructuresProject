package edu.iastate.cs228.hw;

import static org.junit.jupiter.api.Assertions.*;
/**
 * @authorZach
 *
 */
import java.io.FileNotFoundException;

import org.junit.jupiter.api.Test;

class TownTest {

	@Test
	void testAllMethodsInTown() throws FileNotFoundException {
		Town tNew = new Town(5, 5);
		tNew.randomInit(5);
		tNew.toString();
		Town tNew2 = new Town("/Users/zachkehoe/Downloads/test.txt");
		tNew2.toString();
		tNew2.getWidth();
		tNew2.getLength();
		tNew2.helper(tNew2, 0, 0);
		
	}

}
