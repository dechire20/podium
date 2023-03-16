package tilegame.tiles;

import tilegame.gfx.Assets;

public class RockTile extends Tile{

    public RockTile(int id) {
        super(Assets.getInstance().getBlocks("rocks"), id);
    }

    @Override
    public boolean isSolid(){
       return true;
    }
}
