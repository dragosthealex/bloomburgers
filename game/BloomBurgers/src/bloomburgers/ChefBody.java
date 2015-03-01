/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bloomburgers;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

/**
 *
 * @author alexx
 */
public class ChefBody extends Entity
{
    public ChefBody(int x, int y, int width, int height)
    {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        
        try
        {
            Image imageLeft = new Image("res/Body-Left.png");
            Image imageRight = new Image("res/Body-Right.png");
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
                sprite.update(delta);
            }
            // Going to right
            sprite = right;
            x += delta*0.1;
        }
    }
}
