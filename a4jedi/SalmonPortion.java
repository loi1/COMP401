package a4jedi;

public class SalmonPortion extends PortionParent {
	private static final Ingredient a = new Salmon();

	public SalmonPortion(double amount) {
		super(a, amount);
	}

	public IngredientPortion combine(IngredientPortion other) {
		if (other == null) {
			return this;
		} else if (other.getIngredient().equals(this.getIngredient())) {
			return new SalmonPortion(this.getAmount() + other.getAmount());
		} else {
			throw new RuntimeException("Ingredient must be same!");
		}
	}
}