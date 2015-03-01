/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bloomburgers;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.Image;
import org.newdawn.slick.Animation;
import org.newdawn.slick.Input;
import java.awt.Color;

/**
 *
 * @author alexx
 */
public class BloomBurgers {

    // The size of the window
    public final static int SIZE = 600;
    // The framerate
    public static final int FPS = 60;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        try
        {
            // Make the app game container
            AppGameContainer appgc = new AppGameContainer(
                    new BloomGame("BloomBurgers"));
            appgc.setDisplayMode(SIZE, SIZE, false);
            appgc.setShowFPS(false);
            appgc.setTargetFrameRate(FPS);
            appgc.start();
        }
        catch (SlickException e)
        {
            System.err.println(e.getMessage());
        }
    }
}
