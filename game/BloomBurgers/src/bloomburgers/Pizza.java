/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bloomburgers;

/**
 *
 * @author alexx
 */
public class Pizza
{
    // The type
    private PizzaType type;
    // The ingredients
    private IngredientType [] ingredients;
    
    // Constructor
    public Pizza(IngredientType [] reqIngredients, PizzaType type)
    {
        this.ingredients = reqIngredients;
        this.type = type;
    }
    
    // Get type
    public PizzaType getType()
    {
        return this.type;
    }
}
