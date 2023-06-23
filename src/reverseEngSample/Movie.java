package reverseEngSample;

public class Movie {
    public static final int REGULAR = 0;
    public static final int CLASSIC = 1;
    public static final int RELEASE = 2;

    private String name;
    private int priceCode;

    public Movie(String name, int priceCode) {
        this.name = name;
        this.priceCode = priceCode;
    }

    public String getName() {
        return this.name;
    }

    public int getPriceCode() {
        return this.priceCode;
    }

    public void setPriceCode(int priceCode) {
        this.priceCode = priceCode;
    }

    public int calculateRentalAmount(int daysRented) {
        PriceCalculator calculator;

        switch (priceCode) {
            case REGULAR:
                calculator = new RegularPriceCalculator();
                break;
            case CLASSIC:
                calculator = new ClassicPriceCalculator();
                break;
            case RELEASE:
                calculator = new ReleasePriceCalculator();
                break;
            default:
                throw new IllegalArgumentException("Invalid price code");
        }

        return calculator.calculateRentalAmount(daysRented);
    }
}

interface PriceCalculator {
    int calculateRentalAmount(int daysRented);
}

class RegularPriceCalculator implements PriceCalculator {
    @Override
    public int calculateRentalAmount(int daysRented) {
        int amount = 2000;
        if (daysRented > 2) {
            amount += (daysRented - 2) * 1500;
        }
        return amount;
    }
}

class ClassicPriceCalculator implements PriceCalculator {
    @Override
    public int calculateRentalAmount(int daysRented) {
        int amount = 1500;
        if (daysRented > 3) {
            amount += (daysRented - 3) * 1500;
        }
        return amount;
    }
}

class ReleasePriceCalculator implements PriceCalculator {
    @Override
    public int calculateRentalAmount(int daysRented) {
        return daysRented * 3000;
    }
}
