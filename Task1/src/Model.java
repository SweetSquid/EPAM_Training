/**
 * Created by Mykyta Frolov
 */
public class Model {
    private String resultString = "";

    public void addToString(String stringValue){
        this.resultString += " " + stringValue;
    }

    public String toString(){
        return resultString;
    }
}
