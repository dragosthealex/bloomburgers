/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bloomburgers;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Image;

/**
 *
 * @author Kanoshi
 */
public class BloodyEntity extends Entity {
    protected boolean bloody = false;
    protected Image normalImageLeft;
    protected Image normalImageRight;
    protected Image[] normalMovementLeft;
    protected Image[] normalMovementRight;
    protected Animation normalLeft;
    protected Animation normalRight;
    protected Image bloodyImageLeft;
    protected Image bloodyImageRight;
    protected Image[] bloodyMovementLeft;
    protected Image[] bloodyMovementRight;
    protected Animation bloodyLeft;
    protected Animation bloodyRight;
    
    public void setBloody(boolean bool)
    {
        bloody = bool;
        
        boolean spriteWasLeft = sprite == left;
        
        if (bloody)
        {
            left = bloodyLeft;
            right = bloodyRight;
        }
        else
        {
            left = normalLeft;
            right = normalRight;
        }
        
        sprite = spriteWasLeft ? left : right;
    }
}
