package reverseEngSample;

public class Movie {
	public static final int REGULAR = 0;
	public static final int CLASSIC = 1;
	public static final int RELEASE = 2;

	private String name;
	private int priceCode;

	public Movie() {
	}

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
}
