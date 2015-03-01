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
public enum IngredientType 
{
    PEPPERONI (0, "Pepperoni"),
    MUSHROOM (1, "Mushroom"),
    PEPPER (2, "Pepper"),
    TOMATO (3, "Tomato"),
    PINEAPPLE (4, "Pineapple"),
    MEATBALL (5, "Meatball"),
    CHEESE (6, "Cheese"),
    HAM (7, "Ham");
    
    private final int intType;
    private final String name;
    
    IngredientType(int num, String name)
    {
        this.intType = num;
        this.name = name;
    }
    
    String getName()
    {
        return this.name;
    }
    
    int getInt()
    {
        return this.intType;
    }
}
