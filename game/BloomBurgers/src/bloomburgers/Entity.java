/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bloomburgers;
import org.newdawn.slick.Image;
import org.newdawn.slick.Animation;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.GameContainer;
/**
 *
 * @author alexx
 */
abstract public class Entity 
{
    // The entity's position
    protected float x;
    protected float y;
    
    // The duration for the animation
    int [] duration = BloomGame.DURATION;
    
    // The entity's image
    protected Image [] movementLeft = null;
    protected Image [] movementRight = null;
    protected Image [] movementUp = null;
    protected Image [] movementDown = null;
    
    // The entity's sizes
    protected int width;
    protected int height;
    
    // The entity's animation
    protected Animation sprite, up, down, left, right;
    
    // Distroy this entity
    public void destroy()
    {
        try
        {
            if(this.movementDown != null)
            {
                this.movementDown[0].destroy();
                this.movementDown[1].destroy();
            }
            if(this.movementUp != null)
            {
                this.movementUp[0].destroy();
                this.movementUp[1].destroy();
            }
            if(this.movementLeft != null)
            {
                this.movementLeft[0].destroy();
                this.movementLeft[1].destroy();
            }
            if(this.movementRight != null)
            {
                this.movementRight[0].destroy();
                this.movementRight[1].destroy();
            }
        }
        catch (SlickException e)
        {
            System.err.println(e.getMessage());
        }
    }
    
    // Get position
    public float getX()
    {
        return this.x;
    }
    
    public float getY()
    {
        return this.y;
    }
    
    // Get sprite
    public Animation getSprite()
    {
        return this.sprite;
    }
}
