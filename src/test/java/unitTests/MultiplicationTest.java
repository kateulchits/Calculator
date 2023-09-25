package unitTests;

import com.example.calculatorservlet.operations.MultiplicationOperation;
import org.testng.annotations.Test;
import static org.testng.Assert.assertNotEquals;
import static org.testng.AssertJUnit.assertEquals;

public class MultiplicationTest {

    public double number1 = 4;
    public double number2 = 1.1;
    public double positiveResult = 4.4;
    public double negatveResult = 10;

    @Test(groups = {"unitTest.MultiplicationTest", "positive"})
    public void positiveMultiplicationWithCorrectResultTest() {
        MultiplicationOperation test1 = new MultiplicationOperation();
        assertEquals(test1.operatorCalculate(number1, number2), positiveResult);
    }

    @Test(groups = {"unitTest.MultiplicationTest", "positive"})
    public void positiveMultiplicationWithIncorrectResultTest() {
        MultiplicationOperation test1 = new MultiplicationOperation();
        assertNotEquals(test1.operatorCalculate(number1, number2), negatveResult);
    }
}
