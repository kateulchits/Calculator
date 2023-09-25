package calulatorTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CalculatorForm {

    private final By calculateButton = By.cssSelector("input[type='submit']");
    protected final By firstNumberLabel = By.cssSelector("input#num1");
    protected final By secondNumberLabel = By.cssSelector("input#num2");
    protected final By operationLabel = By.cssSelector("input#operation");
    protected String assertErrorMessage = "Result did not match";
    protected String invalidNumberFormatMessage = "Number format error. Enter the number in the correct form, for example '123' or '12.34'";
    protected String invalidOperationMessage = "Invalid operation. Please enter the correct operation (+, -, *, /) and try again.";
    private final WebDriver driver;
    public CalculatorForm(WebDriver driver) {
        this.driver = driver;
    }

    public void calculateButtonClick() {
        driver.findElement(calculateButton).click();
    }

    public String getResult() {
        WebElement el = driver.findElement(By.cssSelector("body>pre"));
        String newEl = el.getText();
        return newEl;
    }

    public void enterValuesInAllFields(String num1, String num2, String op) {
        driver.findElement(firstNumberLabel).sendKeys(num1);
        driver.findElement(secondNumberLabel).sendKeys(num2);
        driver.findElement(operationLabel).sendKeys(op);
    }
}
