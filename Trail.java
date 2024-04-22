import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Trail here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Trail extends Actor
{
    private GreenfootImage trailimg;
    
    public Trail(){
        int trans = Greenfoot.getRandomNumber(250);
        trailimg = getImage();
        trailimg.setTransparency(trans);
        setImage(trailimg);
        setRotation(trans);
    }
    /**
     * Act - do whatever the Trail wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        removetrail();
    }
    
    public void removetrail(){
        if(trailimg.getTransparency() >= 20){
            trailimg.setTransparency(trailimg.getTransparency()-20);
            setImage(trailimg);
        }
        else{
            getWorld().removeObject(this);
        }
    }
}
