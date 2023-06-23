package reverseEngSample;

import org.junit.jupiter.api.Test;

public class Refactor {

	@Test
	public void test() {
		Customer me = new Customer("DO");
		me.addRental(new Rental(10, new Movie("Avengers1", Movie.REGULAR)));
		me.addRental(new Rental(10, new Movie("Ttanic", Movie.CLASSIC)));
		me.addRental(new Rental(10, new Movie("Gozilla", Movie.RELEASE)));
		System.out.println(me.statement());
	}
}
