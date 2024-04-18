import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 *
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class Button extends Actor
{
    private boolean wasPressed = false;
    /**
     * Act - do whatever the Button wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        if (!wasPressed && Greenfoot.mousePressed(this)) {
            changePressedState(true);
            wasPressed = true;

        }

        if (Greenfoot.mouseClicked(this)) {
            onClicked();
            // this makes sure the button has visible animation, even if the click was faster than one cycle
            Greenfoot.delay(1);
            changePressedState(false);
            wasPressed = false;
        } else if (wasPressed && Greenfoot.mouseDragEnded(this)) {
            changePressedState(false);
            wasPressed = false;
        }
    }

    /**
     * Currently unused. this can check if the mouse is hovering over a button, but might impact performance if called every tick
     */
    private boolean hovering() {
        MouseInfo mInfo = Greenfoot.getMouseInfo();
        if (mInfo == null) {
            return false;
        }
        if (mInfo.getX() == getX() && mInfo.getY() == getY()) {
            return true;
        }
        return false;
    }

    protected abstract void onClicked();
    
    /**
     * Default implementation does nothing. Can be used by subclasses to add fancy animations
     */
    protected void changePressedState(boolean pressed) {
        // System.out.println("pressed: " + pressed);
    }
}
