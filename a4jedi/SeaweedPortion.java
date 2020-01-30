package a4jedi;

public class SeaweedPortion extends PortionParent {
	private static final Ingredient a = new Seaweed();

	public SeaweedPortion(double amount) {
		super(a, amount);
	}

	public IngredientPortion combine(IngredientPortion other) {
		if (other == null) {
			return this;
		} else if (other.getIngredient().equals(this.getIngredient())) {
			return new SeaweedPortion(this.getAmount() + other.getAmount());
		} else {
			throw new RuntimeException("Ingredient must be same!");
		}
	}
}