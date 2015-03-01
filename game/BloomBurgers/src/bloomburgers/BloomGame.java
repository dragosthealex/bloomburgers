/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bloomburgers;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
/**
 *
 * @author alexx
 */
public class BloomGame extends StateBasedGame
{
    // The speed of the game
    public static final int DELTA = 50;
    // The duration in ms for an animation
    public static final int [] DURATION = {500,500};
    // Main menu
    public static final int MAINMENU     = 0;
    // The game
    public static final int GAME         = 1;
    // The size
    public static final int SIZE = BloomBurgers.SIZE;
    // The score
    private int score;
    
    
    // The constructor
    public BloomGame (String gameName)
    {
        super(gameName);
    }

    // Initialize your game states (calls init method of each gamestate, and set's the state ID)
    @Override
    public void initStatesList(GameContainer gc) throws SlickException
    {
        // The first state added will be the one that is loaded first, when the application is launched
        //this.addState(new SplashScreen(SPLASHSCREEN));
        this.score = 0;
        this.addState(new MainMenu());
        this.addState(new Game());
        this.addState(new GameOver());
        this.addState(new Pause());
    }
    
    public void updateScore(int score)
    {
        this.score += score;
    }
    
    // Get the score
    public int getScore()
    {
        return this.score;
    }
}