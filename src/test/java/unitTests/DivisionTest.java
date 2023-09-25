package unitTests;

import com.example.calculatorservlet.operations.DivisionOperation;
import org.testng.annotations.Test;
import static org.testng.Assert.assertNotEquals;
import static org.testng.AssertJUnit.assertEquals;

public class DivisionTest {
    public double number1 = 4.1;
    public double number2 = 1;
    public double positiveResult = 4.1;
    public double negatveResult = 10;
    public double zero = 0;

    @Test(groups = {"unitTest.DivisionTest", "positive"})
    public void positiveDivisionWithCorrectResultTest() {
        DivisionOperation test1 = new DivisionOperation();
        assertEquals(test1.operatorCalculate(number1, number2), positiveResult);
    }

    @Test(groups = {"unitTest.DivisionTest", "positive"})
    public void positiveDivisionWithIncorrectResultTest() {
        DivisionOperation test1 = new DivisionOperation();
        assertNotEquals(test1.operatorCalculate(number1, number2), negatveResult);
    }

    @Test(groups = {"unitTest.DivisionTest", "negative"}, expectedExceptions = {ArithmeticException.class})
    public void divisionOnZero(){
            DivisionOperation test1 = new DivisionOperation();
            test1.operatorCalculate(number1, zero);

    }
    }

