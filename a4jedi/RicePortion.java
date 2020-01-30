package a4jedi;

public class RicePortion extends PortionParent {
	private static final Ingredient a = new Rice();

	public RicePortion(double amount) {
		super(a, amount);
	}

	public IngredientPortion combine(IngredientPortion other) {
		if (other == null) {
			return this;
		} else if (other.getIngredient().equals(this.getIngredient())) {
			return new RicePortion(this.getAmount() + other.getAmount());
		} else {
			throw new RuntimeException("Ingredient must be same!");
		}
	}
}