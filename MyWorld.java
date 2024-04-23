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
        super(width, height + 1, 60); 
        score = new Score();
        setActOrder(Button.class, Body.class, Head.class, Trail.class);
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
        for (int i = 0; i < getWidth(); i++) {
            addObject(new TopBar(), i, 0);
        }
        GreenfootImage grass = new GreenfootImage("grass.jpeg");
        setBackground(grass);
        addObject(score,0, 0);
        MyButton myButton = new MyButton();
        addObject(myButton,getWidth() - 1,0);
        addObject(new Head(), getWidth() / 2, getHeight() / 2);
        addFruit();
    }

    public Score getScore() {
        return this.score;
    }
    
    public void addFruit() {
        addObject(new Star(), 0, 0);
    }

    public void gameOver() {
        GreenfootSound over = new GreenfootSound("gameover.wav");
        over.play();
        Greenfoot.stop();
        int width = getWidth();
        int height = getHeight() - 1;
        Greenfoot.setWorld(new MyWorld(width, height));
    }
}