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
import org.newdawn.slick.Image;
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
    private Score score;
    
    @Override
    public void init(GameContainer container, StateBasedGame game)
            throws SlickException 
    {
       heaven = new PizzaHeaven();
       test = heaven.revelateIngredient();
       player = new Player(200, BloomGame.SIZE - 150, game);
       score = new Score();
    }
 
    @Override
    public void render(GameContainer container, StateBasedGame game, Graphics g)
            throws SlickException 
    {
        // Draw player
        player.draw();
        // Draw ingredient
        test.getSprite().draw((int)test.getX(), (int)test.getY(), 50, 50);
        // Draw pizza heaven
        heaven.draw();
        Image legend = new Image("res/legend.png");
        legend.draw(0, BloomGame.SIZE-120);
        score.draw(g);
    }
 
    @Override
    public void update(GameContainer container, StateBasedGame game, int delta)
            throws SlickException 
    {
        if (container.getInput().isKeyDown(Input.KEY_ESCAPE))
        {
            game.enterState(Pause.ID, new FadeOutTransition(Color.black), new FadeInTransition(Color.black));
        }
        
        if(test != null && !test.update(container, player))
        {
            test = heaven.revelateIngredient();
        }
        player.update(container, score);
    }
 
    @Override
    public int getID() 
    {
        // TODO Auto-generated method stub
        return 1;
    }
}
