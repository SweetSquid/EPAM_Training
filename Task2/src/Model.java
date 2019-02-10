import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mykyta Frolov
 */
public class Model {
    private int minValue = 0;
    private int maxValue = 100;
    private int guessNumber;
    private List<Integer> allAttempts = new ArrayList<Integer>();

    public void setGuess(int guessNumber){
        this.guessNumber = guessNumber;
    }

    public int getMinValue(){
        return minValue;
    }

    public int getMaxValue(){
        return maxValue;
    }

    public int getGuess(){
        return guessNumber;
    }

    public List<Integer> getAllAttempts(){
        return allAttempts;
    }

    public int getAmmountAttempts(){
        return allAttempts.size();
    }

    public void addAttempt(int attempt){
        allAttempts.add(attempt);
    }

}
