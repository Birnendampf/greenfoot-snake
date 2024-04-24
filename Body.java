import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Body here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Body extends Actor implements Colliding
{
    // TODO: Replace these with proper assets once we have decided on a resolution
    // FIXME: Should these be seperate Actors? 
    //        pros: more elegant code, native icon support
    //        cons: the last body element would need to "swap itself out" for a tail. That would mean deleting and creating objects and copying over all transforms which might be slow.
    //              might also not be worth the effort; it would require an abstract Body class
    //        possible solution: use a hybrid approach. we only have three seperate body classes, and swap out the icon when zhe body is a tail
    public static final GreenfootImage LEFT = new GreenfootImage("left.png");
    public static final GreenfootImage RIGHT = new GreenfootImage("right2.png");
    public static final GreenfootImage FRONT = new GreenfootImage("front.png");
    public static final GreenfootImage BACK = new GreenfootImage("back.png");
    
    private int age = 0;
    private Head head;

    public Body(GreenfootImage state, Head head) {
        this.head = head;
        setImage(state);
    }

    /**
     * Act - do whatever the Body wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        getWorld().addObject(new Trail(), getX(), getY());
        age++;
        if (age >= head.getLength()) {
            getWorld().removeObject(this);
        } 
        
    }

}
