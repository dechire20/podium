package tilegame.tiles;


import tilegame.gfx.Assets;

public class TreeTile extends Tile{

    public TreeTile(int id) {
        super(Assets.getInstance().getBlocks("tree"), id);
    }

    @Override
    public boolean isSolid(){
        return true;
    }
}
