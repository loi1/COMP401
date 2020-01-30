package a4jedi;

public class Sashimi implements Sushi {

	public enum SashimiType1 {
		TUNA, SALMON, EEL, CRAB, SHRIMP
	};

	private String Name;
	private IngredientPortion[] Ing;

	public Sashimi(SashimiType1 crab) {
		switch (crab) {
		case TUNA:
			Name = "tuna";
			Ing = new IngredientPortion[1];
			Ing[0] = new TunaPortion(.75);
			break;
		case SALMON:
			Name = "salmon";
			Ing = new IngredientPortion[1];
			Ing[0] = new SalmonPortion(.75);
			break;
		case EEL:
			Name = "eel";
			Ing = new IngredientPortion[1];
			Ing[0] = new EelPortion(.75);
			break;
		case CRAB:
			Name = "crab";
			Ing = new IngredientPortion[1];
			Ing[0] = new CrabPortion(.75);
			break;
		case SHRIMP:
			Name = "shrimp";
			Ing = new IngredientPortion[1];
			Ing[0] = new ShrimpPortion(.75);
			break;
		}
	}

	public String getName() {
		return Name + " sashimi";
	}

	public IngredientPortion[] getIngredients() {
		return Ing;
	}

	public int getCalories() {
		double calories = 0;
		for (int i = 0; i < Ing.length; i++) { // keeps adding calories from
												// each ingredient
			calories += Ing[i].getCalories();
		}
		return ((int) (calories + .5));
	}

	public double getCost() {
		double cost = 0;
		for (int i = 0; i < Ing.length; i++) { // keeps adding costs from each
												// ingredient
			cost += Ing[i].getCost();
		}
		return ((int) ((cost * 100.0) + .5)) / 100.0;
	}

	public boolean getIsVegetarian() {
		boolean veggies = true;
		for (int i = 0; i < Ing.length; i++) {
			if (Ing[i].getIsVegetarian() == false) {
				veggies = false;
			}
		}
		return veggies;
	}

	public boolean getHasRice() {
		boolean rice = false;
		for (int i = 0; i < Ing.length; i++) {
			if (Ing[i].getIsRice() == true) {
				rice = true;
			}
		}
		return rice;
	}

	public boolean getHasShellfish() {
		boolean shellfish = false;
		for (int i = 0; i < Ing.length; i++) {
			if (Ing[i].getIsShellfish() == true) {
				shellfish = true;
			}
		}
		return shellfish;
	}
}
