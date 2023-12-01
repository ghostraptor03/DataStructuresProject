package edu.iastate.cs228.hw;

import static org.junit.jupiter.api.Assertions.*;

import java.io.FileNotFoundException;

import org.junit.jupiter.api.Test;

/**
 * @authorZach
 *
 */
class ResellerTest {

	@Test
	void test() throws FileNotFoundException {
		// tests if given Reseller will porvide correct ouputs
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
