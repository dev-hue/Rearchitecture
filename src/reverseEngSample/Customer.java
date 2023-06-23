package reverseEngSample;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private String name;
    private List<Rental> rentals = new ArrayList<>();

    public Customer(String name) {
        this.name = name;
    }

    public void addRental(Rental newRental) {
        rentals.add(newRental);
    }

    public String getName() {
        return this.name;
    }

    public String statement() {
        StringBuilder rentalList = new StringBuilder("Statement\n");
        int totalAmount = 0;
        int bonusPoints = 0;

        for (Rental rental : rentals) {
            int lineAmount = rental.getMovie().calculateRentalAmount(rental.getDaysRented());
            bonusPoints += rental.getMovie().calculateBonusPoints(rental.getDaysRented());

            rentalList.append(rental.getMovie().getName()).append("\t").append(lineAmount).append("\n");
            totalAmount += lineAmount;
        }

        rentalList.append("Total\t").append(totalAmount).append("\n");
        rentalList.append("Bonus Point:\t").append(bonusPoints).append("\n");

        return rentalList.toString();
    }
}
