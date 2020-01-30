package a4jedi;

public class EelPortion extends PortionParent {
	private static final Ingredient a = new Eel();

	public EelPortion(double amount) {
		super(a, amount);
	}

	public IngredientPortion combine(IngredientPortion other) {
		if (other == null) {
			return this;
		} else if (other.getIngredient().equals(this.getIngredient())) {
			return new EelPortion(this.getAmount() + other.getAmount());
		} else {
			throw new RuntimeException("Ingredient must be same!");
		}
	}
}