package unitTests;

import com.example.calculatorservlet.operations.SubtractionOperation;
import org.testng.annotations.Test;
import static org.testng.Assert.assertNotEquals;
import static org.testng.AssertJUnit.assertEquals;

public class SubtractionTest {

    public double number1 = -3;
    public double number2 = 10.1;
    public double positiveResult = -13.1;
    public double negativeResult = 9;

    @Test(groups = {"unitTest.SubtractionTest", "positive"})
    public void positiveSubtractionWithCorrectResultTest() {
        SubtractionOperation test1 = new SubtractionOperation();
        assertEquals(test1.operatorCalculate(number1, number2), positiveResult);
    }

    @Test(groups = {"unitTest.SubtractionTest", "positive"})
    public void positiveSubtractionWithIncorrectResultTest() {
        SubtractionOperation test1 = new SubtractionOperation();
        assertNotEquals(test1.operatorCalculate(number1, number2), negativeResult);
    }

}
