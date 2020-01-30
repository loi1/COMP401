package a4jedi;

abstract public class Foodtype implements Ingredient {
	private String name;
	private double calperDol;
	private int calperOunce;
	private double priceperOunce;
	private boolean isVeggie;
	private boolean isRice;
	private boolean isShellfish;

	protected Foodtype(String Name, int CalperOunce, double PriceperOunce, boolean IsVeggie, boolean IsRice,
			boolean IsShellfish) {
		this.name = Name;
		this.calperOunce = CalperOunce;
		this.priceperOunce = PriceperOunce;
		this.calperDol = CalperOunce / PriceperOunce;
		this.isVeggie = IsVeggie;
		this.isRice = IsRice;
		this.isShellfish = IsShellfish;
	}

	public String getName() {
		return name;
	}

	public double getCaloriesPerDollar() {
		return calperDol;
	}

	public int getCaloriesPerOunce() {
		return calperOunce;
	}

	public double getPricePerOunce() {
		return priceperOunce;
	}

	public boolean equals(Ingredient other) {
		if (other == null)
			return false;
		if (other == this)
			return true;
		return (other.getName().equals(this.getName()) && other.getCaloriesPerOunce() == this.getCaloriesPerOunce()
				&& Math.abs(other.getPricePerOunce() - this.getPricePerOunce()) <= .01
				&& other.getIsVegetarian() == this.getIsVegetarian() && other.getIsRice() == this.getIsRice()
				&& other.getIsShellfish() == this.getIsShellfish());

	}

	public boolean getIsVegetarian() {
		return isVeggie;
	}

	public boolean getIsRice() {
		return isRice;
	}

	public boolean getIsShellfish() {
		return isShellfish;
	}
}