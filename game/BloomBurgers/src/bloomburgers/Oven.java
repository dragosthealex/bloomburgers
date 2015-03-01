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
    public int bakePizza(Pizza pizza)
    {      
        int score = 0;
        if(pizza != null)
        {
            switch(pizza.getType())
            {
                case CAPRICIOSSA:
                    score = 20;
                    break;
                case QFORMAGGI:
                    score = 20;
                    break;
                case QSTAGIONNI:
                    score = 15;
                    break;
                case PEPPERONI:
                    score = 15;
                    break;
                case VEGETARIAN:
                    score = 10;
                    break;
                default:
                    break;
            }
        }
        return score;
    }
}
