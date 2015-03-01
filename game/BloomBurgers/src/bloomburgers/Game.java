/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bloomburgers;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.Color;
import org.newdawn.slick.Input;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;
/**
 *
 * @author alexx
 */
public class Game extends BasicGameState{
    // The id of this state
    public static final int ID = 1;
    
    private Ingredient test;
    // The pizza heaven
    private PizzaHeaven heaven;
    private Player player;
    
    @Override
    public void init(GameContainer container, StateBasedGame game)
            throws SlickException 
    {
       heaven = new PizzaHeaven();
       test = heaven.revelateIngredient();
       player = new Player(200, 500);
    }
 
    @Override
    public void render(GameContainer container, StateBasedGame game, Graphics g)
            throws SlickException 
    {
        g.setColor(Color.white);
        g.drawString("fuck in the ass", 50, 10);
        player.draw();
        if(test != null)
        {
            test.getSprite().draw((int)test.getX(), (int)test.getY(), 50, 50);
        }
    }
 
    @Override
    public void update(GameContainer container, StateBasedGame game, int delta)
            throws SlickException 
    {
        if(test != null && !test.update(container, player))
        {
            test = heaven.revelateIngredient();
        }
        player.update(container);
    }
 
    @Override
    public int getID() 
    {
        // TODO Auto-generated method stub
        return 1;
    }
}
