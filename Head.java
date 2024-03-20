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
    // the score and length are purposefully kept seperate because a) the initial length should not be counted to the score and b) it allows for different fruit types that might yield different
    // score and growth amounts
    private int length = 3;
    /**
     * Act - do whatever the Head wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        processMove();
        // TODO: process collision
        // TODO: process eating
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
        if (newDirection == oldDirection) {
            // direction has not changed
            body = new Body(Body.STRAIGHT, this);

        } else if ((oldDirection + 90) % 360 == newDirection) {
            // turned right
            body = new Body(Body.RIGHT, this);
        } else {
            // turned left
            body = new Body(Body.LEFT, this);
        }
        setRotation(newDirection);
        body.setRotation(newDirection);
        getWorld().addObject(body, getX(), getY());
        move(1);
    }

    public int getLength() {
        return this.length;
    }
}
