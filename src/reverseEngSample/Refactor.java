package reverseEngSample;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class Refactor {

	@Test
	public void test() {
		long startTime = System.currentTimeMillis();
		Customer me = new Customer("DO");
		me.addRental(new Rental(10, new Movie("Avengers1", Movie.REGULAR)));
		me.addRental(new Rental(10, new Movie("Ttanic", Movie.CLASSIC)));
		me.addRental(new Rental(10, new Movie("Gozilla", Movie.RELEASE)));
		
		String expected = new String("Statement\n"
				+ "Avengers1\t14000\n"
				+ "Ttanic\t12000\n"
				+ "Gozilla\t30000\n"
				+ "Total\t56000\n"
				+ "Bonus Point:\t4\n");
		long endTime = System.currentTimeMillis();
        long executionTime = endTime - startTime;

        System.out.println("Execution time: " + executionTime + " milliseconds");
		
		assertEquals(expected, me.statement());
	}
}
