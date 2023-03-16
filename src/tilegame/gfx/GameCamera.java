package tilegame.gfx;

import tilegame.Handler;
import tilegame.entities.Entity;
import tilegame.tiles.Tile;

public class GameCamera {

    private final Handler handler;
    private float xOffset, yOffset;

    public GameCamera(Handler handler, float xOffset, float yOffset){
        this.handler = handler;
        this.xOffset = xOffset;
        this.yOffset = yOffset;
    }

    public void checkBlankSpace(){
        if (xOffset < Tile.TILEWIDTH) {
            xOffset = Tile.TILEWIDTH;
        }
        else if (xOffset > (handler.getWorld().getWidth()) * Tile.TILEWIDTH - handler.getGame().getWidth()){
            xOffset = (handler.getWorld().getWidth()) * Tile.TILEWIDTH - handler.getGame().getWidth();
        }

        if (yOffset < 0){
            yOffset = 0;
        }
        else if (yOffset > handler.getWorld().getHeight() * Tile.TILEHEIGHT - handler.getGame().getHeight()){
            yOffset = handler.getWorld().getHeight() * Tile.TILEHEIGHT - handler.getGame().getHeight();

        }
    }

    public void centerOnEntity(Entity e){
        xOffset = e.getX() - (float)handler.getGame().getWidth() / 2 + (float)e.getWidth() / 2;
        yOffset = e.getY() - (float)handler.getGame().getHeight() / 2 + (float)e.getHeight() / 2;
        checkBlankSpace();
    }

    public void move(float xAmt, float yAmt){
        xOffset += xAmt;
        yOffset += yAmt;
        checkBlankSpace();
    }

    public float getxOffset(){
        return xOffset;
    }

    public void setxOffset(float xOffset){
        this.xOffset = xOffset;
    }

    public float getyOffset(){
        return yOffset;
    }

    public void setyOffset(float yOffset){
        this.yOffset = yOffset;
    }
}
