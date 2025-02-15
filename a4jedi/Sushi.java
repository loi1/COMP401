package a4jedi;

public interface Sushi {
	String getName();

	IngredientPortion[] getIngredients();

	int getCalories();

	double getCost();

	boolean getHasRice();

	boolean getHasShellfish();

	boolean getIsVegetarian();
}
