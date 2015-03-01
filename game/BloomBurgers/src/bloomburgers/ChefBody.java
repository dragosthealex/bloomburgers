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
public class ChefBody extends BloodyEntity
{
    public ChefBody(int x, int y, int width, int height)
    {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        
        try
        {
            normalImageLeft = new Image("res/Body-Left.png");
            normalImageRight = new Image("res/Body-Right.png");
            normalMovementLeft = new Image[]{normalImageLeft, normalImageRight};
            normalMovementRight = new Image[]{normalImageRight, normalImageLeft};
            normalLeft = new Animation(normalMovementLeft, duration, false);
            normalRight = new Animation(normalMovementRight, duration, false);
            
            bloodyImageLeft = new Image("res/Body-Left-Bloody.png");
            bloodyImageRight = new Image("res/Body-Right-Bloody.png");
            bloodyMovementLeft = new Image[]{bloodyImageLeft, bloodyImageRight};
            bloodyMovementRight = new Image[]{bloodyImageRight, bloodyImageLeft};
            bloodyLeft = new Animation(bloodyMovementLeft, duration, false);
            bloodyRight = new Animation(bloodyMovementRight, duration, false);
            
            left = normalLeft;
            right = normalRight;;
            
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
