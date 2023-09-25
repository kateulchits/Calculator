package calulatorTests;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(ScreenshotListener.class)
public class CalculatorTest extends TestBase{

    @Test
    public void  positiveNumbersAndOperationTest() {
        CalculatorForm test = new CalculatorForm(driver);
        String expectedResult = "Result: 12";
        test.enterValuesInAllFields("5","7","+");
        test.calculateButtonClick();
        Assert.assertEquals(test.getResult(), expectedResult, test.assertErrorMessage);
    }

    @Test
    public void positiveWithNegativeAndDoubleNumbersTest() {
        CalculatorForm test = new CalculatorForm(driver);
        String expectedResult = "Result: -36,65";
        test.enterValuesInAllFields("-5","7.33","*");
        test.calculateButtonClick();
        Assert.assertEquals(test.getResult(), expectedResult, test.assertErrorMessage);
    }

    @Test
    public void divisionOnZeroTest() {
        CalculatorForm test = new CalculatorForm(driver);
        String expectedResult = "The division by zero operation is not allowed. Please enter a different division number to continue";
        test.enterValuesInAllFields("-5","0","/");
        test.calculateButtonClick();
        Assert.assertEquals(test.getResult(), expectedResult, test.assertErrorMessage);
    }

    @Test
    public void invalidNumberFormatTest() {
        CalculatorForm test = new CalculatorForm(driver);
        test.enterValuesInAllFields("hello", "5", "+");
        test.calculateButtonClick();
        Assert.assertEquals(test.getResult(), test.invalidNumberFormatMessage, test.assertErrorMessage);
    }

    @Test
    public void nullNumberFieldTest() {
        CalculatorForm test = new CalculatorForm(driver);
        test.enterValuesInAllFields("  ", "5", "-");
        test.calculateButtonClick();
        Assert.assertEquals(test.getResult(), test.invalidNumberFormatMessage, test.assertErrorMessage );
    }

    @Test
    public void invalidOperationTest() {
        CalculatorForm test = new CalculatorForm(driver);
        test.enterValuesInAllFields("-5", "5", "hello");
        test.calculateButtonClick();
        Assert.assertEquals(test.getResult(), test.invalidOperationMessage, test.assertErrorMessage);
    }
}
