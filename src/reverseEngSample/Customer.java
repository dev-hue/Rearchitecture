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
            int lineAmount = calculateRentalAmount(rental);
            bonusPoints += calculateBonusPoints(rental);

            rentalList.append(rental.getMovie().getName()).append("\t").append(lineAmount).append("\n");
            totalAmount += lineAmount;
        }

        rentalList.append("Total\t").append(totalAmount).append("\n");
        rentalList.append("Bonus Points:\t").append(bonusPoints).append("\n");

        return rentalList.toString();
    }

    private int calculateRentalAmount(Rental rental) {
        int lineAmount = 0;

        switch (rental.getMovie().getPriceCode()) {
            case Movie.REGULAR:
                lineAmount += 2000;
                if (rental.getDaysRented() > 2) {
                    lineAmount += (rental.getDaysRented() - 2) * 1500;
                }
                break;
            case Movie.CLASSIC:
                lineAmount += 1500;
                if (rental.getDaysRented() > 3) {
                    lineAmount += (rental.getDaysRented() - 3) * 1500;
                }
                break;
            case Movie.RELEASE:
                lineAmount += (rental.getDaysRented() * 3000);
                break;
        }

        return lineAmount;
    }

    private int calculateBonusPoints(Rental rental) {
        int bonusPoints = 1;

        if (rental.getMovie().getPriceCode() == Movie.RELEASE && rental.getDaysRented() > 1) {
            bonusPoints++;
        }

        return bonusPoints;
    }
}
