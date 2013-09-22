/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Gamelogic;

/**
 *
 * @author Jere
 */
public class Score {

    private int score;
    private int streak;
    private int longestStreak;
    private int turns;

    public Score() {
        score = 0;
        streak = 0;
        longestStreak = 0;
    }

    public void addScore() {
        score++;
        score += streak;
    }

    public void addStreak() {
        streak++;
        if (streak > longestStreak) {
            longestStreak = streak;
        }
    }
    public void resetStreak(){
        streak = 0;
    }
    
    public void addTurn(){
        turns++;
    }
    
    public int getScore(){
        return score;
    }
    public int getStreak(){
        return streak;
    }
    public int getTurns(){
        return turns;
    }
    public int getLongestStreak(){
        return longestStreak;
    }
    public int getFinalScore(){
        return score-(turns/2);
    }
}
