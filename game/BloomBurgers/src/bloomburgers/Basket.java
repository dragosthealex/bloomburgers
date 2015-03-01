/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bloomburgers;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.Image;
import org.newdawn.slick.Animation;
/**
 *
 * @author alexx
 */
public class Basket extends Entity
{
    // The number of the ingredients
    private int numberOfIngredients = 0;
    // The array of ingredients (as int)
    private int [] ingredients;
    
    
    // The constructor
    public Basket(int x, int y, int width, int height)
    {
        this.height = height;
        this.width = width;
        this.x = x;
        this.y = y;
        this.ingredients = new int [8];
        for (int ingredient:ingredients)
        {
            ingredient = 0;
        }
        
        // Set the image
        try
        {
            Image imageLeft = new Image("res/Bowl-Left-Layer0.png");
            Image imageRight = new Image("res/Bowl-Right-Layer0.png");
            this.movementLeft = new Image[]{imageLeft, imageRight};
            this.movementRight = new Image[]{imageRight, imageLeft};
            left = new Animation(movementLeft, duration, false);
            right = new Animation(movementRight, duration, false);
            sprite = right;
        }
        catch (SlickException e)
        {
            System.err.println(e.getMessage());
        }
    }
    
    // Update
    public void update(boolean direction)
    {
        int delta = BloomGame.DELTA;
        if(!direction)
        {
            if(sprite == right)
            {
                x -= 98;
                sprite.update(delta);
            }
            sprite = left;
            // Going to left
            x -= delta*0.1;
        }
        else
        {
            if(sprite == left)
            {
                x += 98;
                sprite.update(delta);
            }
            // Going to right
            sprite = right;
            x += delta*0.1;
        }
    }
    
    // Add an ingredient
    public void addIngredient(Ingredient ingredient)
    {
        if(numberOfIngredients == 9)
        {
            numberOfIngredients = 0;
            for(int ing : ingredients)
            {
                ing = 0;
            }
        }
        else
        {
            numberOfIngredients ++;
            ingredients[ingredient.getIntType()] ++;
        }
        
        try
        {
            boolean dir = (sprite != left);
            
            Image imageLeft = new Image("res/Bowl-Left-Layer"+
                    numberOfIngredients/2+".png");
            Image imageRight = new Image("res/Bowl-Right-Layer"+
                    numberOfIngredients/2+".png");
            this.movementLeft = new Image[]{imageLeft, imageRight};
            this.movementRight = new Image[]{imageRight, imageLeft};
            left = new Animation(movementLeft, duration, false);
            right = new Animation(movementRight, duration, false);
            sprite = (dir)?right:left;
            //sprite.update(BloomGame.DELTA);
        }
        catch (SlickException e)
        {
            System.err.println(e.getMessage());
        }
    }
    
    // Check whether the basket has the necessary ingredients for pizza
    public Pizza hasPizzaIngredients()
    {
        // Initialise pizza as null obj
        Pizza pizza = null;
                
        if(ingredients[IngredientType.CHEESE.getInt()] >= 1
        &&(ingredients[IngredientType.HAM.getInt()] >= 1)
        &&(ingredients[IngredientType.TOMATO.getInt()] >= 1)
        &&(ingredients[IngredientType.PEPPERONI.getInt()] >= 1)
        &&(ingredients[IngredientType.PINEAPPLE.getInt()] >= 1)
        &&(ingredients[IngredientType.MEATBALL.getInt()] >= 1))
        {
            IngredientType [] pizzaIngredients = {IngredientType.CHEESE,
                                              IngredientType.HAM,
                                              IngredientType.TOMATO,
                                              IngredientType.PEPPERONI,
                                              IngredientType.PINEAPPLE,
                                              IngredientType.MEATBALL};
            pizza = new Pizza(pizzaIngredients, PizzaType.CAPRICIOSSA);
            ingredients[IngredientType.CHEESE.getInt()]--;
            ingredients[IngredientType.HAM.getInt()]--;
            ingredients[IngredientType.TOMATO.getInt()]--;
            ingredients[IngredientType.PEPPERONI.getInt()]--;
            ingredients[IngredientType.PINEAPPLE.getInt()]--;
            ingredients[IngredientType.MEATBALL.getInt()]--;
            
            numberOfIngredients -= 6;
        }
        else if(ingredients[IngredientType.CHEESE.getInt()] >= 4
        &&(ingredients[IngredientType.MUSHROOM.getInt()] >= 1))
        {
            IngredientType [] pizzaIngredients = {IngredientType.CHEESE,
                                              IngredientType.MUSHROOM};
            pizza = new Pizza(pizzaIngredients, PizzaType.QFORMAGGI);
            ingredients[IngredientType.CHEESE.getInt()] -= 4;
            ingredients[IngredientType.MUSHROOM.getInt()]--;
            

            try
            {
                boolean dir = (sprite != left);
            }
            catch (Exception e)
            {
                
            }
                numberOfIngredients -= 5;
        }
        else if(ingredients[IngredientType.MUSHROOM.getInt()] >= 1
        &&(ingredients[IngredientType.HAM.getInt()] >= 1)
        &&(ingredients[IngredientType.TOMATO.getInt()] >= 1)
        &&(ingredients[IngredientType.PINEAPPLE.getInt()] >= 1))
        {
            IngredientType [] pizzaIngredients = {IngredientType.TOMATO,
                                              IngredientType.MUSHROOM,
                                              IngredientType.HAM,
                                              IngredientType.PINEAPPLE};
            pizza = new Pizza(pizzaIngredients, PizzaType.QSTAGIONNI);
            ingredients[IngredientType.MUSHROOM.getInt()]--;
            ingredients[IngredientType.HAM.getInt()]--;
            ingredients[IngredientType.PINEAPPLE.getInt()]--;
            ingredients[IngredientType.TOMATO.getInt()]--;
            
            numberOfIngredients -= 4;
        }
        else if(ingredients[IngredientType.PEPPERONI.getInt()] >= 1
        &&(ingredients[IngredientType.HAM.getInt()] >= 1)
        &&(ingredients[IngredientType.PEPPER.getInt()] >= 1)
        &&(ingredients[IngredientType.MEATBALL.getInt()] >= 1))
        {
            IngredientType [] pizzaIngredients = {IngredientType.PEPPERONI,
                                              IngredientType.PEPPER,
                                              IngredientType.HAM,
                                              IngredientType.MEATBALL};
            pizza = new Pizza(pizzaIngredients, PizzaType.PEPPERONI);
            ingredients[IngredientType.PEPPERONI.getInt()]--;
            ingredients[IngredientType.HAM.getInt()]--;
            ingredients[IngredientType.MEATBALL.getInt()]--;
            ingredients[IngredientType.PEPPER.getInt()]--;
            
            numberOfIngredients -= 4;
        }
        else if(ingredients[IngredientType.CHEESE.getInt()] >= 1
        &&(ingredients[IngredientType.PEPPER.getInt()] >= 1)
        &&(ingredients[IngredientType.PINEAPPLE.getInt()] >= 1))
        {
            IngredientType [] pizzaIngredients = {IngredientType.CHEESE,
                                              IngredientType.PEPPER,
                                              IngredientType.PINEAPPLE};
            pizza = new Pizza(pizzaIngredients, PizzaType.VEGETARIAN);
            ingredients[IngredientType.PEPPER.getInt()]--;
            ingredients[IngredientType.CHEESE.getInt()]--;
            ingredients[IngredientType.PINEAPPLE.getInt()]--;
            
            numberOfIngredients -= 3;
        }
        try
        {
            boolean dir = (sprite == left)?false:true;

            Image imageLeft = new Image("res/Bowl-Left-Layer"+
                    numberOfIngredients/2+".png");
            Image imageRight = new Image("res/Bowl-Right-Layer"+
                    numberOfIngredients/2+".png");
            this.movementLeft = new Image[]{imageLeft, imageRight};
            this.movementRight = new Image[]{imageRight, imageLeft};
            left = new Animation(movementLeft, duration, false);
            right = new Animation(movementRight, duration, false);
            sprite = (dir)?right:left;
            //sprite.update(BloomGame.DELTA);
        }
        catch (SlickException e)
        {
            System.err.println(e.getMessage());
        }
        return pizza;
    }
}
