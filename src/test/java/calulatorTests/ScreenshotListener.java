package calulatorTests;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.Allure;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import static org.openqa.selenium.OutputType.FILE;

public class ScreenshotListener implements ITestListener {
    @Override
    public void onTestFailure(ITestResult testResult) {
        try {
            Allure.addAttachment("screenshot", new FileInputStream(Selenide.screenshot(FILE)));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

}
