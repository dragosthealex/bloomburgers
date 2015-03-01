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
public class Oven extends Entity
{
    // The state (on or off)
    private boolean state = false;
    // The fire image
    private Image image;
    
    // Constructor
    public Oven()
    {
        this.x = BloomGame.SIZE - 100;
        this.y = BloomGame.SIZE - 150;
        /*
        try
        {
            image = new Image("res/fire.png");
        }
        catch (SlickException e)
        {
            System.err.println(e.getMessage());
        }*/
    }
    
    // Make pizza
    public void bakePizza(Pizza pizza, Score score, Money money)
    {
        if(pizza != null)
        {
            switch(pizza.getType())
            {
                case CAPRICIOSSA:
                    score.update(20);
                    money.add(2000);
                    break;
                case QFORMAGGI:
                    score.update(15);
                    money.add(1500);
                    break;
                case QSTAGIONNI:
                    score.update(15);
                    money.add(1500);
                    break;
                case PEPPERONI:
                    score.update(15);
                    money.add(1500);
                    break;
                case VEGETARIAN:
                    score.update(10);
                    money.add(1000);
                    break;
                default:
                    break;
            }
        }
    }
}
