/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bloomburgers;
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.Image;
import org.newdawn.slick.Animation;
import org.newdawn.slick.Input;
/**
 *
 * @author alexx
 */
public class PizzaHeaven 
{
    // The image
    private Image image;
    // The ingredients
    private IngredientType ingredient [] = {IngredientType.PEPPERONI,
                                 IngredientType.CHEESE,
                                 IngredientType.HAM,
                                 IngredientType.MEATBALL,
                                 IngredientType.PEPPER,
                                 IngredientType.PINEAPPLE,
                                 IngredientType.TOMATO}; 
    
    // Constructor
    public PizzaHeaven()
    {
        try
        {
            this.image = new Image("res/Foreground.png");
        }
        catch (SlickException e)
        {
            System.err.println(e.getMessage());
        }
    }
    
    // Generate ingredient
    public Ingredient revelateIngredient()
    {
        int index = (int) Math.floor(Math.random()*7);
        int startX = (int) Math.floor(Math.random()*(BloomGame.SIZE-100));
        return new Ingredient(ingredient[index], startX, 0, 50, 50);
    }
    
    // Draw
    public void draw()
    {
        image.draw(0,0, BloomGame.SIZE, BloomGame.SIZE);
    }
}
