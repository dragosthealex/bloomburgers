/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bloomburgers;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.state.StateBasedGame;
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
public class BloomGame extends StateBasedGame
{
    // The speed of the game
    public static final int DELTA = 50;
    // The duration in ms for an animation
    public static final int [] DURATION = {300,300};
    // Splashscreen
    public static final int SPLASHSCREEN = 0;
    // Main menu
    public static final int MAINMENU     = 0;
    // The game
    public static final int GAME         = 1;
    // The size
    public static final int SIZE = BloomBurgers.SIZE;
    
    
    // The constructor
    public BloomGame (String gameName)
    {
        super(gameName);
    }

    // Initialize your game states (calls init method of each gamestate, and set's the state ID)
    public void initStatesList(GameContainer gc) throws SlickException
    {
        // The first state added will be the one that is loaded first, when the application is launched
        //this.addState(new SplashScreen(SPLASHSCREEN));
        this.addState(new MainMenu());
        this.addState(new Game());
    }
}