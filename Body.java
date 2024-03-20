import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Body here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Body extends Actor
{
    // TODO: Replace these with proper assets once we have decided on a resolution
    // FIXME: Should these be seperate Actors? 
    //        pros: more elegant code, native icon support
    //        cons: the last body element would need to "swap itself out" for a tail. That would mean deleting and creating objects and copying over all transforms which might be slow.
    //              might also not be worth the effort; it would require an abstract Body class
    //        possible solution: use a hybrid approach. we only have three seperate body classes, and swap out the icon when zhe body is a tail
    public static final GreenfootImage STRAIGHT = new GreenfootImage("═", 60, null, null);
    public static final GreenfootImage LEFT = new GreenfootImage("╚", 60, null, null);
    public static final GreenfootImage RIGHT = new GreenfootImage("╔", 60, null, null);
    public static final GreenfootImage TAIL = new GreenfootImage("╼", 60, null, null);
    // FIXME: Find a better name for this variable
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
        age++;
        if (age >= head.getLength()) {
            getWorld().removeObject(this);
        } else if (age + 1 == head.getLength()) {
            setImage(TAIL);
        }
    }

}
