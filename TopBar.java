import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class TopBar here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TopBar extends Actor
{
    protected void addedToWorld(World world) {
        int cellSize = world.getCellSize();
        GreenfootImage img = new GreenfootImage(cellSize, cellSize);
        img.setColor(Color.WHITE);
        img.fill();
        img.setColor(Color.BLACK);
        img.drawLine(0, cellSize - 1, cellSize, cellSize - 1);
        setImage(img);
    }
}
