import model.Actions;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class ActionsTest {

    @Test
    public void testAddSixAndFour(){
        Integer expectedSum = 10;
        Integer firstNum = 6;
        Integer secondNum = 4;

        Integer actualResult = null;
        actualResult = (Integer) Actions.actions.get(0).add(firstNum,secondNum);
        assertEquals(expectedSum,actualResult);
    }

    @Test
    public void testAddStringSixAndFour(){
        String expectedSum = "64";
        String firstNum = "6";
        String secondNum = "4";

        String actualResult = null;
        actualResult = (String) Actions.actions.get(0).add(firstNum,secondNum);
        assertEquals(expectedSum,actualResult);
    }

    @Test(expected = NullPointerException.class)
    public void testAddNull(){
        Integer secondNum = 6;
        Actions.actions.get(0).add(null,secondNum);
        fail();
    }

    @Test
    public void testSubtractSixAndFour(){
        Integer expectedSub = 2;
        Integer firstNum = 6;
        Integer secondNum = 4;

        Integer actualResult = null;
        actualResult = (Integer) Actions.actions.get(0).subtract(firstNum,secondNum);
        assertEquals(expectedSub,actualResult);
    }

    @Test
    public void testDivideSixAndFour(){
        Integer expectedDiv = 1;
        Integer firstNum = 6;
        Integer secondNum = 4;

        Integer actualResult = null;
        actualResult = (Integer) Actions.actions.get(0).divide(firstNum,secondNum);
        assertEquals(expectedDiv,actualResult);
    }

    @Test
    public void testMultipleSixAndFour(){
        Integer expectedMul = 24;
        Integer firstNum = 6;
        Integer secondNum = 4;

        Integer actualResult = null;
        actualResult = (Integer) Actions.actions.get(0).multiply(firstNum,secondNum);
        assertEquals(expectedMul,actualResult);
    }

}
