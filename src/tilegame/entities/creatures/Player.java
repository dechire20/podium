package tilegame.entities.creatures;

import tilegame.Handler;
import tilegame.gfx.Animation;
import tilegame.gfx.Assets;

import java.awt.*;
import java.awt.image.BufferedImage;
import tilegame.states.StateMachine;

public class Player extends Creature{

    float jumpingVelocity = -430;
    int gravity = 910;

    long deathCounter = 0;
    private int lastDirection;

    private  final Animation animLeft, animRight;
    Handler handler;

    public Player(Handler handler, float x, float y) {
        super(handler, x, y, Creature.DEFAULT_CREATURE_WIDTH, Creature.DEFAULT_CREATURE_HEIGHT);

        bounds.x = 13;
        bounds.y = 3;
        bounds. width = 19;
        bounds.height = 43;
        this.handler = handler;
        // Animation
        animLeft = new Animation(200, Assets.getInstance().getWalkingLeft());
        animRight = new Animation(200, Assets.getInstance().getWalkingRight());
    }

    @Override
    public void update() {
        getInput();
        animLeft.update();
        animRight.update();
        deadFunctionality();
        won();
        move();
        timerDone();
        handler.getGame().getGameCamera().centerOnEntity(this);
    }

    private void getInput() {
        xVelocity = 0;

        // player movement
        if (!handler.getGame().won){
            if (handler.getGame().getKeyManager().left) xVelocity -= movementVelocity;
            if (handler.getGame().getKeyManager().right) xVelocity += movementVelocity;
            // restart game
            if (handler.getGame().getKeyManager().esc){
                StateMachine.getInstance().setCurrentState(StateMachine.STATESENUM.HOMESTATE);
            }
        }
        else{
            if (handler.getGame().getKeyManager().enter && handler.getGame().won){
                restart();
            }
            if (handler.getGame().getKeyManager().ctrl && handler.getGame().won){
                System.exit(1);
            }
        }

        // player jump
        if (handler.getGame().getKeyManager().jump && onFloor) {
            yVelocity += jumpingVelocity;
            onFloor = false;
        }
        // gravity
        yVelocity += gravity * deltaTime;
    }

    public void restart(){
        x = 48;
        y = 10;
        handler.getGame().time = 60;
        handler.getGame().won = false;
    }

    public void timerDone(){
        if (handler.getGame().time <= 0){
            restart();
        }
    }

    public void deadFunctionality(){
        if (isDead() && !handler.getGame().won){
            restart();
            deathCounter++;
        }
    }

    public void won(){
        if (x >= 2943){
            handler.getGame().won = true;
        }
    }

    @Override
    public void render(Graphics g) {
        //g.setColor(Color.red);
        //g.fillRect((int) (x + bounds.x - handler.getGameCamera().getxOffset()), (int) (y + bounds.y - handler.getGameCamera().getyOffset()), bounds.width, bounds.height);
        g.drawImage(getCurrentAnimationFrame(), (int) ( x - handler.getGame().getGameCamera().getxOffset()), (int) (y - handler.getGame().getGameCamera().getyOffset()), width, height, null);
        //deadFunctionality(g);
        g.setFont(new Font("serif", Font.PLAIN, 30));
        g.drawString("deaths: " + deathCounter, 30, 30);
        g.drawString("time: " + handler.getGame().time, 300, 30);

        if (handler.getGame().won){
            g.drawString("You Won!", handler.getGame().getWidth() / 2 - 30, handler.getGame().getHeight() / 2);
            g.drawString("press ENTER to restart", handler.getGame().getWidth() / 2 - 100, handler.getGame().getHeight() / 2 + 30);
            g.drawString("press CTRL to exit", handler.getGame().getWidth() / 2 - 80, handler.getGame().getHeight() / 2 + 60);
        }

    }

    private BufferedImage getCurrentAnimationFrame(){
        if (xMove < 0){
            lastDirection = -1;
            if (onFloor){
                return animLeft.getCurrentFrame();
            }
            else{
                return Assets.getInstance().getPlayer("PlayerLeftJump");
            }
        }
        if (xMove > 0){
            lastDirection = 1;
            if (onFloor){
                return animRight.getCurrentFrame();
            }
            else{
                return Assets.getInstance().getPlayer("PlayerRightJump");
            }
        }
        if (lastDirection < 0){
            return Assets.getInstance().getPlayer("PlayerLeft0");
        }
        else if (lastDirection > 0){
            return Assets.getInstance().getPlayer("PlayerRight0");
        }

        return Assets.getInstance().getPlayer("PlayerRight0");
    }
}