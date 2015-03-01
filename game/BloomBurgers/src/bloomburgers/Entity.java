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
    protected int x;
    protected int y;
    
    // The entity's image
    protected Image [] movementLeft;
    protected Image [] movementRight;
    protected Image [] movementUp;
    protected Image [] movementDown;
    
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
            this.movementDown[0].destroy();
            this.movementDown[1].destroy();
            this.movementUp[0].destroy();
            this.movementUp[1].destroy();
            this.movementLeft[0].destroy();
            this.movementLeft[1].destroy();
            this.movementRight[0].destroy();
            this.movementRight[1].destroy();
        }
        catch (SlickException e)
        {
            System.err.println(e.getMessage());
        }
    }
    
    // Get position
    public int getX()
    {
        return this.x;
    }
    
    public int getY()
    {
        return this.y;
    }
}
