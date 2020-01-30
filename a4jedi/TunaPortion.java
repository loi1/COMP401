package a4jedi;

public class TunaPortion extends PortionParent {
	private static final Ingredient a = new Tuna();

	public TunaPortion(double amount) {
		super(a, amount);
	}

	public IngredientPortion combine(IngredientPortion other) {
		if (other == null) {
			return this;
		} else if (other.getIngredient().equals(this.getIngredient())) {
			return new TunaPortion(this.getAmount() + other.getAmount());
		} else {
			throw new RuntimeException("Ingredient must be same!");
		}
	}
}