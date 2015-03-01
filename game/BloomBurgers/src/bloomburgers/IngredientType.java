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
    PEPERONNI (0, "pepperoni"),
    MUSHROOM (1, "mushroom");
    
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
}
