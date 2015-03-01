/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bloomburgers;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Input;
import org.newdawn.slick.state.StateBasedGame;
/**
 *
 * @author alexx
 */
public class Player
{
    private final StateBasedGame game;
    private final Basket basket;
    private final Chef chef;
    private final Oven oven;
    private int x = 100, y = BloomGame.SIZE - 100;
    
    public Player(int x, int y, StateBasedGame game)
    {
        this.basket = new Basket(x+49, y, 50, 50);
        this.chef = new Chef(x, y, 50, 50, game);
        this.oven = new Oven();
        this.game = game;
    }
    
    public void update(GameContainer container, Score score)
    {
        int delta = BloomGame.DELTA;
        Input input = container.getInput();
        if(input.isKeyDown(Input.KEY_LEFT))
        {
            if (x+50-delta*0.1 >= 0)
            {
                basket.update(false);
                chef.update(false);
                x -= delta*0.1;
            }
        }
        else if(input.isKeyDown(Input.KEY_RIGHT))
        {
            if (x+235+delta*0.1 <= BloomGame.SIZE)
            {
                basket.update(true);
                chef.update(true);
                x += delta*0.1;
            }
        }
        
        if(basketInOven() && basket.hasPizzaIngredients()!=null)
        {
            score.update(oven.bakePizza(basket.hasPizzaIngredients()));
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
    
    // Method to find if the basket has reached the oven
    private boolean basketInOven()
    {
        return (basket.getX() + 140 >= BloomGame.SIZE);
    }
}
