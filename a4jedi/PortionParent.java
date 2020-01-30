package a4jedi;

abstract public class PortionParent implements IngredientPortion {
	private Ingredient Ing;
	private double Amount;

	protected PortionParent(Ingredient ing, double amount) {
		if (ing == null) {
			throw new RuntimeException("Ingredient cannot be null!");
		}
		if (amount < 0) {
			throw new RuntimeException("Amount cannot be negative!");
		}
		Ing = ing;
		Amount = amount;
	}

	public Ingredient getIngredient() {
		return Ing;
	}

	public double getAmount() {
		return Amount;
	}

	public String getName() {
		return Ing.getName();
	}

	public double getCalories() {
		return Ing.getCaloriesPerOunce() * Amount;
	}

	public double getCost() {
		return Ing.getPricePerOunce() * Amount;
	}

	public boolean getIsVegetarian() {
		return Ing.getIsVegetarian();
	}

	public boolean getIsRice() {
		return Ing.getIsRice();
	}

	public boolean getIsShellfish() {
		return Ing.getIsShellfish();
	}

	@Override
	abstract public IngredientPortion combine(IngredientPortion other);
}