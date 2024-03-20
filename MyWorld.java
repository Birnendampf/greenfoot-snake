import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{
    private Score score;
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld(int width, int height)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(width, height + 1, 60); 
        score = new Score();
        prepare();
    }

    public MyWorld() {
        this(7, 7);
    }

    public void act() {
        System.out.println("1");
    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        for (int i = 0; i < getWidth(); i++) {
            addObject(new TopBar(), i, 0);
        }
        addObject(score,0, 0);
        MyButton myButton = new MyButton();
        addObject(myButton,getWidth() - 1,0);
        addObject(new Head(), getWidth() / 2, getHeight() / 2);
    }

    public Score getScore() {
        return this.score;
    }
}