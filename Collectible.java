import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Collectible here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class Collectible extends Actor
{
    public abstract int getValue();

    public abstract int getScore();

    protected void addedToWorld(World world) {
        int x, y;
        do {
            x = Greenfoot.getRandomNumber(world.getWidth());
            y = Greenfoot.getRandomNumber(world.getHeight() - 1) + 1;
            setLocation(x, y);
        }
        while (getOneObjectAtOffset(0, 0, Actor.class) != null);
        
    }

}
