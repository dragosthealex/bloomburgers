import java.util.ArrayList;

/**
 * Class to access prices and usage amounts of certain ingredients.
 */

public abstract class FoodData
{
	public static void main(String[] args)
	{
		Ingredient pizzaDough = Ingredient.PIZZA_DOUGH;
		System.out.println(pizzaDough.getColor());
		System.out.println(Ingredient.random());
	}
}