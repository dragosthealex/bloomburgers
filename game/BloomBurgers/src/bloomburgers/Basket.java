/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bloomburgers;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
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
    
    // The constructor
    public Basket(int x, int y, int width, int height)
    {
        this.height = height;
        this.width = width;
        this.x = x;
        this.y = y;
        
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
        numberOfIngredients = (numberOfIngredients == 9)?0:numberOfIngredients+1;
        
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
    }
}
