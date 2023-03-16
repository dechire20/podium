package tilegame.tiles;

import tilegame.gfx.Assets;

public class SkyTile extends Tile{

    public SkyTile(int id) {
        super(Assets.getInstance().getBlocks("sky"), id);
    }

}
