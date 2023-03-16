package tilegame;

import tilegame.worlds.World;



public class Handler {

    private final Game game;
    private World world;
    public Handler(Game game){
        this.game = game;
    }
    public Game getGame(){
        return game;
    }

    public World getWorld(){
        return world;
    }
    public void setWorld(World world){
        this.world = world;
    }
}
