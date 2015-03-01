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
    // Retain yourself
    
    // Constructor
    public Ingredient (IngredientType type, int x, int y, int height, int width)
    {
        this.type = type;
        this.x = x;
        this.y = y;
        this.height = height;
        this.width = width;
        
        try
        {
            // Set the image
            Image image1 = new Image("res/" + type.getName() + ".png");
            Image image2 = new Image("res/" + type.getName() + ".png");
            movementDown = new Image[]{image1, image2};
            down = new Animation(movementDown, duration, true);
            sprite = down;
        }
        catch (SlickException e)
        {
            System.err.println(e.getMessage());
        }
    }
    
    public boolean update(GameContainer container, Player player)
    {
        int delta = BloomGame.DELTA;
        if(player.hit(this))
        {
            this.destroy();
            return false;
        }
        if(player.get(this))
        {
            this.destroy();
            return false;
        }
        if(!((this.y + this.height + delta*0.1) >= BloomGame.SIZE))
        {
            System.out.println();
            this.sprite = this.down;
            sprite.update(delta);
            this.y += delta*0.1;
            
            return true;
        }

        this.destroy();
        return false;
    }
}