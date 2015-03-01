/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bloomburgers;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Color;
/**
 *
 * @author alexx
 */
public class Score
{
    private int score;
    
    public Score()
    {
        this.score = 0;
    }
    
    public void update(int addScore)
    {
        this.score += addScore;
    }
    
    public void draw(Graphics g)
    {
        g.setColor(Color.black);
        g.drawString(this.score + "", 10, 10);
    }
}
