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

    /**
     * Initialize Score and streaks as 0.
     */
    public Score() {
        score = 0;
        streak = 0;
        longestStreak = 0;
    }
    /**
     * Increase score by 1.
     */
    public void addScore() {
        score++;
        score += streak;
    }
    /**
     * Increase streak by 1, if longest streak, update.
     */
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
    /**
     * Calculate final score as score minus half of turns.
     * @return 
     */
    public int getFinalScore(){
        return score-(turns/2);
    }
}
