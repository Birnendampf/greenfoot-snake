import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 *  This can be a pause button at some point if we want to bother
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyButton extends Button
{
    protected void onClicked() {
        Greenfoot.stop();
    }

    protected void changePressedState(boolean pressed) {
        if (pressed) {
            setRotation(180);
        } else {
            setRotation(0);
        }
    }
}
