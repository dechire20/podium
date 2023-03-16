package tilegame.pages;

import tilegame.Handler;
import tilegame.pages.LogInFrame;
import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;

import java.awt.*;
import java.util.Set;
import tilegame.states.StateMachine;

public class HomePage extends Page{
    HomeFrame home;
    Handler mHandler;
    public HomePage(Handler handler){
        super(handler);
        mHandler = handler;
        home = new HomeFrame();
        //mHandler.getGame().getDisplay().setVisible(false);

    }

    @Override
    public void update() {
        home.setVisible(true); 
        //todo: add mouse listener and handle the clicks here
        if (home.started){
            home.dispose();
            StateMachine.getInstance().setCurrentState(StateMachine.STATESENUM.GAMESTATE);
            home.started = false;
        }
        else if (home.leaderboard){
            PageManager.getInstance().setCurrentPage(PageManager.PAGESENUM.LEADERBOARDPAGE);
            home.dispose();
            home.leaderboard = false;
        }
        else if (home.quit){
            home.quit = false;
            System.exit(1);
        }

        System.out.println(!mHandler.getGame().getDisplay().isVisible());
    }

    @Override
    public void render(Graphics g) {

    }

    
}
