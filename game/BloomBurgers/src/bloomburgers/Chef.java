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
public class Chef
{
    // The body parts
    private final ChefBody body;
    private final ChefHead head;
    private int hitCount = 0;
    
    public Chef(int x, int y, int width, int height)
    {
        this.body = new ChefBody(x, y, width, height);
        this.head = new ChefHead(x, y-49, width, height);
    }
    
    // Update
    public void update(boolean direction)
    {
        body.update(direction);
        head.update(direction);
    }
    
    // Draw
    public void draw()
    {
        body.getSprite().draw((int)body.getX(), body.getY(), 50, 50);
        head.getSprite().draw((int)head.getX(), head.getY(), 50, 50);
    }
    
    // Return head pos
    public int getHeadX()
    {
        return (int)this.head.getX();
    }
    public int getHeadY()
    {
        return (int)this.head.getY();
    }
    
    // Hit
    public void hit()
    {
        hitCount++;
        switch (hitCount)
        {
            case 6:
                // GAME OVER
            case 5:
                body.setBloody(true);
            case 3:
                head.setBloody(true);
                break;
        }
    }
}
