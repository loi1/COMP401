package a4jedi;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public class Roll implements Sushi {

	private String Name;
	private IngredientPortion[] Ing;

	public Roll(String name, IngredientPortion[] roll_ingredients) {
		if (name == null) {
			throw new RuntimeException("Name cannot be null.");
		}
		if (roll_ingredients == null) {
			throw new RuntimeException("Ingredients cannot be null.");
		}
		for (int i = 0; i < roll_ingredients.length; i++) {
			if (roll_ingredients[i].getName() == null) {
				throw new RuntimeException("Ingredient name cannot be null.");
			}
			if (roll_ingredients[i].getAmount() < 0 || roll_ingredients[i].getCost() < 0
					|| roll_ingredients[i].getCalories() < 0) {
				throw new RuntimeException("Amounts cannot be negative.");
			}
		}

		HashMap<String, IngredientPortion> map = new HashMap<String, IngredientPortion>();
		for (int i = 0; i < roll_ingredients.length; i++) {
			IngredientPortion newAmount = map.get(roll_ingredients[i].getIngredient().getName());
			map.put(roll_ingredients[i].getIngredient().getName(), roll_ingredients[i].combine(newAmount));
		}
		if (map.containsKey("seaweed") == false) {
			map.put("seaweed", new SeaweedPortion(.1));
		} else if (map.get("seaweed").getAmount() < 0.1) {
			map.replace("seaweed", new SeaweedPortion(0.1));
		}
		IngredientPortion[] roll_ingsFinal = new IngredientPortion[map.size()];
		Set<Entry<String, IngredientPortion>> set = map.entrySet();
		Iterator<Entry<String, IngredientPortion>> it = set.iterator();
		int i = 0;
		while (it.hasNext()) {
			roll_ingsFinal[i] = it.next().getValue();
			i++;
		}
		Ing = roll_ingsFinal.clone();
		Name = name;
	}

	public String getName() {
		return Name;
	}

	public IngredientPortion[] getIngredients() {
		IngredientPortion Ing2[] = Ing.clone();
		return Ing2;
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
