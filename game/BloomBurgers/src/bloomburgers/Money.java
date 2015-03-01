/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bloomburgers;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;

/**
 *
 * @author Kanoshi
 */
class Money {
    private int money;
    private StateBasedGame game;
    
    public Money(int money, StateBasedGame game)
    {
        this.money = money;
        this.game = game;
    }
    
    public void add(int money)
    {
        this.money += money;
    }
    
    public void sub(int money)
    {
        this.money -= money;
        if (this.money < 0)
            game.enterState(GameOver.ID);
    }
    
    @Override
    public String toString()
    {
        return String.format("$%.2f", (double) money / 100.0d);
    }
    
    public void draw(Graphics g)
    {
        g.setColor(Color.black);
        g.drawString(this + "", 10, 20);
    }
}
