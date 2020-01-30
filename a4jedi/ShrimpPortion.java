package a4jedi;

public class ShrimpPortion extends PortionParent {
	private static final Ingredient a = new Shrimp();

	public ShrimpPortion(double amount) {
		super(a, amount);
	}

	public IngredientPortion combine(IngredientPortion other) {
		if (other == null) {
			return this;
		} else if (other.getIngredient().equals(this.getIngredient())) {
			return new ShrimpPortion(this.getAmount() + other.getAmount());
		} else {
			throw new RuntimeException("Ingredient must be same!");
		}
	}
}