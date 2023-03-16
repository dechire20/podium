package tilegame.pages;

import  tilegame.Handler;

import java.awt.*;

public abstract class Page {
    protected Handler mHandler;
    public Page(Handler handler){
        mHandler = handler;
    }
    public abstract void update();
    public abstract void render(Graphics g);
}
