package tilegame.states;

import tilegame.Handler;
import tilegame.pages.*;

import java.awt.*;

public class HomeState extends State{
    Handler mHandler;
    public HomeState(Handler handler) {
        super(handler);
        mHandler = handler;
        PageManager.getInstance().addPage(PageManager.PAGESENUM.HOMEPAGE, new HomePage(handler));
        PageManager.getInstance().addPage(PageManager.PAGESENUM.CREDENTIALSPAGE, new CredentialsPage(handler));
        PageManager.getInstance().addPage(PageManager.PAGESENUM.LEADERBOARDPAGE, new LeaderboardPage(handler));

        PageManager.getInstance().setCurrentPage(PageManager.PAGESENUM.CREDENTIALSPAGE);
    }

    @Override
    public  void update(){
        mHandler.getGame().getDisplay().setVisible(false);
        PageManager.getInstance().getCurrentPage().update();
    }
    @Override
    public void render(Graphics g) {    
        PageManager.getInstance().getCurrentPage().render(g);
    }
    //TODO: implement class
}
