package reverseEngSample;

import java.util.ArrayList;

public class Customer {
	private String name;
	private ArrayList<Rental> rentals = new ArrayList<Rental>();

	public Customer(String name) {
		this.name = name;
	}

	public void addRental(Rental newRental) {
		rentals.add(newRental);
	}

	public String getNmae() {
		return this.name;
	}

    public String statement() {
        StringBuilder rentalList = new StringBuilder("Statement\n");
        int totalAmount = 0;
        int bonusPoints = 0;

        for (Rental rental : rentals) {
            int lineAmount = rental.getMovie().calculateRentalAmount(rental.getDaysRented());
            bonusPoints += calculateBonusPoints(rental);

            rentalList.append(rental.getMovie().getName()).append("\t").append(lineAmount).append("\n");
            totalAmount += lineAmount;
        }

        rentalList.append("Total\t").append(totalAmount).append("\n");
        rentalList.append("Bonus Point:\t").append(bonusPoints).append("\n");

        return rentalList.toString();
    }

    private int calculateBonusPoints(Rental rental) {
        int bonusPoints = 1;

        if (rental.getMovie().getPriceCode() == Movie.RELEASE && rental.getDaysRented() > 1) {
            bonusPoints++;
        }

        return bonusPoints;
    }
}
