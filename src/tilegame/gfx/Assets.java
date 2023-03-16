package tilegame.gfx;

import java.awt.image.BufferedImage;
import java.util.HashMap;

public class Assets {

    public static final int width = 16, height = 16;

    private final HashMap<String, BufferedImage> player = new HashMap<>();
    private final HashMap<String, BufferedImage> blocks = new HashMap<>();
    private final BufferedImage[] walkingPlayerLeft = new BufferedImage[4];
    private final BufferedImage[] walkingPlayerRight = new BufferedImage[4];

    private static Assets instance;
    SpriteSheet spritesheet = new SpriteSheet(ImageLoader.loadImage("/textures/spriteSheet.png"));


    private Assets(){

        // Player hashmap
        player.put("PlayerLeft0", spritesheet.crop(0, 0, width, height));
        player.put("PlayerLeft1", spritesheet.crop(width, 0, width, height));
        player.put("PlayerLeft2", spritesheet.crop(width * 2, 0, width, height));
        player.put("PlayerLeft3", spritesheet.crop(width * 3, 0, width, height));
        player.put("PlayerLeft4", spritesheet.crop(width * 4, 0, width, height));
        player.put("PlayerLeftJump", spritesheet.crop(width * 3, height, width, height));

        player.put("PlayerRight0", spritesheet.crop(width * 5, 0, width, height));
        player.put("PlayerRight1", spritesheet.crop(width * 6, 0, width, height));
        player.put("PlayerRight2", spritesheet.crop(width * 7, 0, width, height));
        player.put("PlayerRight3", spritesheet.crop(0, height, width, height));
        player.put("PlayerRight4", spritesheet.crop(width, height, width, height));
        player.put("PlayerRightJump", spritesheet.crop(width * 2, height, width, height));

        // Blocks hashmap
        blocks.put("stoneBrick", spritesheet.crop(0, height * 2, width, height));
        blocks.put("grass", spritesheet.crop(width * 5, height * 2, width, height));
        blocks.put("dirt", spritesheet.crop(width * 6, height * 2, width, height));
        blocks.put("sky", spritesheet.crop(width * 2, height * 2, width, height));
        blocks.put("rocks", spritesheet.crop(width * 3, height * 2, width, height));
        blocks.put("tree", spritesheet.crop(width * 7, height * 2, width, height));

        walkingPlayerLeft[0] = player.get("PlayerLeft1");
        walkingPlayerLeft[1] = player.get("PlayerLeft2");
        walkingPlayerLeft[2] = player.get("PlayerLeft3");
        walkingPlayerLeft[3] = player.get("PlayerLeft4");

        walkingPlayerRight[0] = player.get("PlayerRight1");
        walkingPlayerRight[1] = player.get("PlayerRight2");
        walkingPlayerRight[2] = player.get("PlayerRight3");
        walkingPlayerRight[3] = player.get("PlayerRight4");

    }


    public static Assets getInstance(){
        if (instance == null){
            instance = new Assets();
        }
        return instance;
    }

    public BufferedImage getPlayer(String token){
        return player.get(token);
    }

    public BufferedImage getBlocks(String token){
        if (blocks.containsKey(token)) {
            return blocks.get(token);
        }
        return null;
    }

    public BufferedImage[] getWalkingLeft(){
        return walkingPlayerLeft;
    }

    public BufferedImage[] getWalkingRight(){
        return walkingPlayerRight;
    }
}
