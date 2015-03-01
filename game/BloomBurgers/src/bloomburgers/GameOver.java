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
 * @author Kanoshi
 */
public class GameOver extends BasicGameState
{
    // The game, stored for later use
    private StateBasedGame game;
    // The id of the menu
    public static final int ID = 2;
    
    @Override
    public void init(GameContainer container, StateBasedGame game)
            throws SlickException 
    {
        this.game = game;
    }
 
    @Override
    public void render(GameContainer container, StateBasedGame game, Graphics g)
            throws SlickException 
    {
        g.setColor(Color.white);
        g.drawString("Game over!", 50, 10);

        g.drawString("1. Play Again", 50, 100);
        g.drawString("2. High Scores", 50, 120);
        g.drawString("3. Quit", 50, 140);
 
    }
 
    @Override
    public void update(GameContainer container, StateBasedGame game, int delta)
            throws SlickException 
    {
        // TODO Auto-generated method stub
 
    }
 
    @Override
    public int getID() 
    {
        // TODO Auto-generated method stub
        return 2;
    }
    
    // The menu logic here
    public void keyReleased(int key, char c) 
    {
        switch(key) {
            case Input.KEY_1:
                game.enterState(Game.ID, new FadeOutTransition(Color.black), new FadeInTransition(Color.black));
                break;
            case Input.KEY_2:
                // TODO: Implement later
                break;
            case Input.KEY_3:
                System.exit(0);
                break;
            default:
                break;
        }
    }
}
