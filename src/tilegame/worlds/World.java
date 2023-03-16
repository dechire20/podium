package tilegame.worlds;

import tilegame.Handler;
import tilegame.tiles.Tile;
import tilegame.utils.Utils;

import java.awt.*;

public class World {

    private final Handler handler;
    private int width, height;
    private int spawnX, spawnY;
    private int[][] tiles;

    public World(Handler handler, String path) {
        this.handler = handler;
        loadWorld(path);
    }

    public void update() {

    }

    public void render(Graphics g) {
        int xStart = (int) Math.max(0, handler.getGame().getGameCamera().getxOffset() / Tile.TILEWIDTH );
        int xEnd = (int) Math.min(width, (handler.getGame().getGameCamera().getxOffset() + handler.getGame().getWidth()) / Tile.TILEWIDTH + 1);
        int yStart = (int) Math.max(0, handler.getGame().getGameCamera().getyOffset() / Tile.TILEHEIGHT);
        int yEnd = (int) Math.min(height, (handler.getGame().getGameCamera().getyOffset() + handler.getGame().getHeight()) / Tile.TILEHEIGHT + 1);

        for (int y = yStart; y < yEnd; y++) {
            for (int x = xStart; x < xEnd; x++) {
                getTile(x, y).render(g,(int) (x * Tile.TILEWIDTH - handler.getGame().getGameCamera().getxOffset()), (int) (y * Tile.TILEWIDTH - handler.getGame().getGameCamera().getyOffset()));
            }
        }
    }

    public Tile getTile(int x, int y) {
        if (x < 0 || y < 0 || x >= width || y >= height){
            return Tile.rockTile;
        }

        Tile t = Tile.tiles[tiles[x][y]];
        if (t == null) {
            return Tile.rockTile;
        }
        return t;
    }

    private void loadWorld(String path) {
        String file = Utils.loadFileAsString(path);
        String[] tokens = file.split("\\s+");
        width = Utils.parseInt(tokens[0]);
        height = Utils.parseInt(tokens[1]);
        spawnX = Utils.parseInt(tokens[3]);
        spawnY = Utils.parseInt(tokens[4]);

        tiles = new int[width][height];
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                tiles[x][y] = Utils.parseInt(tokens[(x + y * width) + 4]);
            }
        }

    }

    public int getWidth() {
        return width;
    }

    public int getHeight(){
        return height;
    }

    public int getSpawnX(){
        return spawnX;
    }

    public int getSpawnY(){
        return spawnY;
    }
}