package tilegame.tiles;

import tilegame.gfx.Assets;

public class StoneBrick extends Tile{

    public StoneBrick(int id) {
        super(Assets.getInstance().getBlocks("stoneBrick"), id);
    }

    @Override
    public boolean isSolid() {
        return true;
    }

}
