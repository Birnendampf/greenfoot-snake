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
    private GreenfootSound backsd = new GreenfootSound("back.wav");
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld(int width, int height)
    {    
        super(width, height + 1, 60); 
        score = new Score();
        setActOrder(Button.class, Body.class, Head.class);
        setPaintOrder(Head.class, Body.class, Trail.class);
        prepare();
    }

    public MyWorld() {
        this(7, 7);
    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        GreenfootImage back = new GreenfootImage(getWidth(), getHeight());
        back.setColor(new Color(100,50,70));
        back.fill();
        for (int i = 0; i < getWidth(); i++) {
            addObject(new TopBar(), i, 0);
        }
        GreenfootImage grass = new GreenfootImage("grass.jpeg");
        setBackground(grass);
        addObject(score,1, 0);
        MyButton myButton = new MyButton();
        //addObject(myButton,getWidth() - 1,0);
        addObject(new Head(), getWidth() / 2, getHeight() / 2);
        addCollectible();
    }

    public void started() {
        backsd.setVolume(25);
        backsd.playLoop();
    }

    public void stopped() {
        backsd.stop();
    }

    public Score getScore() {
        return this.score;
    }

    public void addCollectible() {
        addObject(new Star(), 0, 0);
    }

    public void gameOver() {
        backsd.stop();
        Greenfoot.stop();
        int width = getWidth();
        int height = getHeight() - 1;
        Greenfoot.setWorld(new MyWorld(width, height));
    }
}