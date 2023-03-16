package tilegame.tiles;

import tilegame.gfx.Assets;

public class GrassTile extends Tile{

    public GrassTile(int id) {
        super(Assets.getInstance().getBlocks("grass"), id);
    }

    @Override
    public boolean isSolid(){
        return true;
    }
}
