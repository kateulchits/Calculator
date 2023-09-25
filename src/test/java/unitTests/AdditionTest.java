package unitTests;

import com.example.calculatorservlet.operations.AdditionOperation;
import org.testng.annotations.Test;

import static org.testng.Assert.assertNotEquals;
import static org.testng.AssertJUnit.assertEquals;

public class AdditionTest {

    public double number1 = 4;
    public double number2 = 5.6;
    public double positiveResult = 9.6;
    public double negativeResult = 10;

    @Test(groups = {"unitTest.AdditionTest", "positive"})
    public void positiveAdditionWithCorrectResultTest() {
        AdditionOperation test1 = new AdditionOperation();
        assertEquals(test1.operatorCalculate(number1, number2), positiveResult);
    }

   @Test(groups = {"unitTest.AdditionTest", "positive"})
    public void positiveAdditionWithIncorrectResultTest() {
       AdditionOperation test1 = new AdditionOperation();
       assertNotEquals(test1.operatorCalculate(number1, number2), negativeResult);
   }

    @Test()
    public void maxSizeIntegerNumberTest() {
        double maxDoubleValue = Double.MAX_VALUE;
        AdditionOperation test1 = new AdditionOperation();
        double result = test1.operatorCalculate(maxDoubleValue,maxDoubleValue);
        double expectedResult = maxDoubleValue * 2;
        assertEquals(expectedResult, result);
    }

    @Test
    public void ZeroNumbersTest() {
        AdditionOperation test1 = new AdditionOperation();
        assertEquals(0.0, test1.operatorCalculate(0.0,0.0));
    }

    @Test
    public void minSizeNumberTest() {
        double minDoubleValue = Double.MIN_VALUE;
        AdditionOperation test1 = new AdditionOperation();
        double result = test1.operatorCalculate(minDoubleValue,minDoubleValue);
        double expectedResult = minDoubleValue * 2;
        assertEquals(expectedResult, result);
    }
}
