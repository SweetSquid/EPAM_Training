public class View {
    public final String START_MESSAGE = "Hello, you are playing the game, where you need to guess a random number in the range [0,100]";
    public final String ERROR_TYPE_MESSAGE = "Only integer is acceptable";
    public final String CONGRATULATION_MESSAGE = "Congratulations, you have won";
    public final String WRONG_NUMBER_MESSAGE = "Cold, you are far away, try again";
    public final String RANGE_MESSAGE = "Your range: ";
    public final String CLOSE_NUMBER_MESSAGE = "Hot, keep trying";
    public final String WRONG_TRY_MESSAGE = "Didn't guess, try another number from the range ";
    public final String BEYOND_THE_RANGE_MESSAGE = "Your number beyond the range";
    public final String ATTEMPTS_MESSAGE = "The number of your attempts: ";

    public void printMessage(String message){
        System.out.println(message);
    }
}
