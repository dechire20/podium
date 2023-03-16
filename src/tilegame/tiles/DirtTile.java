package tilegame.tiles;

import tilegame.gfx.Assets;

public class DirtTile extends Tile{

    public DirtTile(int id) {
        super(Assets.getInstance().getBlocks("dirt"), id);
    }

    @Override
    public boolean isSolid(){
        return true;
    }
}
