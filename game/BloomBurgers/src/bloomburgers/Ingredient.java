/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bloomburgers;
import org.newdawn.slick.Input;
import org.newdawn.slick.Color;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.Image;
import org.newdawn.slick.Animation;
/**
 *
 * @author alexx
 */
public class Ingredient extends Entity
{
    // The type of the ingredient
    private final IngredientType type;
    
    // Constructor
    public Ingredient (IngredientType type)
    {
        this.type = type;
        try
        {
            // Set the image
            Image image1 = new Image("res/" + type.getName() + ".png");
            Image image2 = new Image("res/" + type.getName() + ".png");
            this.movementDown = new Image[]{image1, image2};
        }
        catch (SlickException e)
        {
            System.err.println(e.getMessage());
        }
    }
}