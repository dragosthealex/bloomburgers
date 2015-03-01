/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bloomburgers;
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.Image;
import org.newdawn.slick.Animation;
import org.newdawn.slick.Input;
/**
 *
 * @author alexx
 */
public class Player
{
    private Basket basket;
    private Chef chef;
    private int x = 100, y = BloomGame.SIZE - 100;
    
    public Player(int x, int y)
    {
        this.basket = new Basket(x+49, y, 50, 50);
        this.chef = new Chef(x, y, 50, 50);
    }
    
    public void update(GameContainer container)
    {
        int delta = BloomGame.DELTA;
        Input input = container.getInput();
        if(input.isKeyDown(Input.KEY_LEFT) 
            && (x-delta*0.1+50 >= 0))
        {
            basket.update(false);
            chef.update(false);
            x -= delta*0.1;
        }
        else if(input.isKeyDown(Input.KEY_RIGHT)
            && (x+200+delta*0.1 <= BloomGame.SIZE))
        {
            basket.update(true);
            chef.update(true);
            x += delta*0.1;
        }
    }
    
    // Draw
    public void draw ()
    {
        basket.getSprite().draw((int)basket.getX(), (int)basket.getY(), 50, 50);
        chef.draw();
    }
    
    // Method to check if ingredient entered the basket
    public boolean get(Ingredient ingredient)
    {
        if(ingredient.getY()+25 >= basket.getY()
            && (ingredient.getX() <= basket.getX()+25)
            && (ingredient.getX() >= basket.getX()-25))
        {
            basket.addIngredient(ingredient);
            return true;
        }
        return false;
    }
    
    public boolean hit(Ingredient ingredient)
    {
        if(ingredient.getY() + 49 >= chef.getHeadY()
            && (ingredient.getX() <= chef.getHeadX() + 25)
            && (ingredient.getX() >= chef.getHeadX() - 25))
        {
            chef.hit();
            return true;
        }
        return false;
    }
}
