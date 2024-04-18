import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Score here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Score extends Actor
{
    private int score;

    public Score() {
        this.score = 0;
        update();
    }

    public void addToScore(int value) {
        score += value;
        update();
    }

    private void update() {
        // yes, putting spaces before the score is janky and there is probably a better way to add padding, but it works for now
        setImage(new GreenfootImage("  Score: " + score, 20, null, null));
    }
}
