package a4jedi;

import static org.junit.Assert.*;

import org.junit.Test;

import a4adept.Nigiri.NigiriType;
import a4adept.Sashimi.SashimiType;
import a4jedi.Nigiri.NigiriType1;
import a4jedi.Sashimi.SashimiType1;

public class A4_Tester {

	@Test
	public void RegularFoodTest() {
		Avocado a = new Avocado();
		Avocado b = new Avocado();
		assertEquals(a.getName(), "avocado");
		assertEquals(a.equals(null), false);
		assertEquals(a.equals(a), true);
		assertEquals(a.getCaloriesPerDollar(), 45 / .22, .0000001);
		assertEquals(a.getIsVegetarian(), true);
		assertEquals(a.getIsRice(), false);
		assertEquals(a.getIsShellfish(), false);
		assertEquals(a.equals(b), true);
	}

	@Test
	public void PortionFoodTest() {
		IngredientPortion a = new CrabPortion(2.5);
		IngredientPortion b = new CrabPortion(5.0);
		IngredientPortion c = new CrabPortion(7.5);
		IngredientPortion d;
		IngredientPortion e;
		assertEquals(a.getIngredient(), b.getIngredient());
		assertEquals(a.getName(), "crab");
		assertEquals(a.getAmount(), 2.5, .0000001);
		assertEquals(a.getCalories(), 36 * 2.5, .0000001);
		assertEquals(a.getCost(), .75 * 2.5, .0000001);
		assertEquals(a.getIsVegetarian(), false);
		assertEquals(a.getIsRice(), false);
		assertEquals(a.getIsShellfish(), true);
		d = a.combine(b);
		e = a.combine(null);
		assertEquals(d.getAmount(), c.getAmount(), .0000001);
	}

	@Test
	public void SashimiTester() {
		// test Sashimi
		Sashimi a = new Sashimi(SashimiType1.TUNA);
		assertEquals(a.getName(), "tuna sashimi");
		IngredientPortion Ing = new TunaPortion(.75);
		IngredientPortion[] Ing2 = a.getIngredients();
		assertEquals(Ing2[0].getIngredient(), Ing.getIngredient());
		assertEquals(a.getCalories(), 36);
		assertEquals(a.getCost(), ((int) ((1.77 * .75 * 100.0) + .5)) / 100.0, .0000001);
		assertEquals(a.getIsVegetarian(), false);
		assertEquals(a.getHasRice(), false);
		assertEquals(a.getHasShellfish(), false);
	}

	@Test
	public void NigiriTester() {
		// test Nigiri
		Nigiri b = new Nigiri(NigiriType1.TUNA);
		assertEquals(b.getName(), "tuna nigiri");
		IngredientPortion[] Ing = new IngredientPortion[2];
		Ing[0] = new TunaPortion(.75);
		Ing[1] = new RicePortion(.5);
		IngredientPortion[] Ing2 = b.getIngredients();
		assertEquals(Ing[0].getAmount(), Ing2[0].getAmount(), .0000001);
		assertEquals(b.getCalories(), 36 + 37 / 2);
		assertEquals(b.getCost(), ((int) (((1.77 * .75 + .12 * .5) * 100.0) + .5)) / 100.0, .0000001);
		assertEquals(b.getIsVegetarian(), false);
		assertEquals(b.getHasRice(), false);
		assertEquals(b.getHasShellfish(), false);
	}

	@Test
	public void RollTester() {
		TunaPortion tuna = new TunaPortion(1);
		SeaweedPortion weed = new SeaweedPortion(1);
		EelPortion eel = new EelPortion(1);
		IngredientPortion[] Ing = { tuna, weed, eel };
		Roll a = new Roll("ImOnARoll", Ing);
		IngredientPortion[] Ing2 = a.getIngredients();
		for (int i = 0; i < Ing2.length; i++) {
			System.out.println(Ing2[i].getIngredient().getName());
		}
		assertEquals(a.getName(), "ImOnARoll");
		assertEquals(a.getCalories(), 113 + 48 + 84);
		assertEquals(a.getCost(), ((int) (((2.18 + 2.95 + 1.77) * 100.0) + .5)) / 100.0, .0000001);
		assertEquals(a.getIsVegetarian(), false);
		assertEquals(a.getHasRice(), false);
		assertEquals(a.getHasShellfish(), false);
	}

}