package reverseEngSample;

public class Rental {
    private int daysRented;
    private Movie movie;

    public Rental(int daysRented, Movie movie) {
        this.daysRented = daysRented;
        this.movie = movie;
    }

    public int getDaysRented() {
        return daysRented;
    }

    public Movie getMovie() {
        return movie;
    }
}