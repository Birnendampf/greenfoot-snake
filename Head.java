import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Head here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Head extends Actor
{
    private final int NORTH = 270;
    private final int EAST = 0;
    private final int SOUTH = 90;
    private final int WEST = 180;
    private int length = 3;
    /**
     * Act - do whatever the Head wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        processMove();
        if (colliding()) {
            GreenfootSound colliding = new GreenfootSound("colliding.wav");
            colliding.play();
            getWorldOfType(MyWorld.class).gameOver();
        }
        eatCollectible();
    }

    private void processMove() {
        int oldDirection = getRotation();
        int newDirection = oldDirection;
        String key = Greenfoot.getKey();
        if (key != null) {
            newDirection =  switch (key) {
                case "w", "up" -> NORTH;
                case "a", "left" -> WEST;
                case "s", "down" -> SOUTH;
                case "d", "right" -> EAST;
                default -> newDirection;
            };
        }
        // make sure we ignore 180 degree turns
        if (newDirection % 180 == oldDirection % 180) {
            newDirection = oldDirection;
        }
        Body body;
        if (newDirection == NORTH) {
            body = new Body(Body.BACK, this);

        } else if (newDirection == EAST) {
            body = new Body(Body.RIGHT, this);
        } else if(newDirection == WEST){
            body = new Body(Body.LEFT, this);
        }
        else{
            body = new Body(Body.FRONT, this);
        }
        setRotation(newDirection);
        getWorld().addObject(body, getX(), getY());
        move(1);
    }
    
    public boolean colliding() {
        return getOneObjectAtOffset(0, 0, Colliding.class) != null;
    }

    public int getLength() {
        return this.length;
    }
    
    public void eatCollectible() {
        Star star = (Star) getOneObjectAtOffset(0, 0, Star.class);
        if (star == null) return;
        GreenfootSound eating = new GreenfootSound("eating.wav");
        eating.play();
        this.length += star.getValue();
        MyWorld world = getWorldOfType(MyWorld.class);
        world.removeObject(star);
        world.addCollectible();
        world.getScore().addToScore(star.getScore());
    }
}
