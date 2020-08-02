package runner;

import com.codeborne.selenide.WebDriverRunner;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.qameta.allure.Allure;
import lombok.extern.slf4j.Slf4j;
import org.junit.runner.RunWith;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.nio.charset.StandardCharsets;

@RunWith(Cucumber.class)
@Slf4j
@CucumberOptions(
        strict = true,
        features = {"src/test/resources/features/"},
        plugin = {"io.qameta.allure.cucumber4jvm.AllureCucumber4Jvm"},
        glue = {"steps", "hooks"},
        tags = "@all"
)

public class RunnerTest{

    private static byte[] getScreenshotBytes() {
        return ((TakesScreenshot) WebDriverRunner.getWebDriver()).getScreenshotAs(OutputType.BYTES);
    }

    private static byte[] getPageSourceBytes() {
        return WebDriverRunner.getWebDriver().getPageSource().getBytes(StandardCharsets.UTF_8);
    }

    public static void makeScreenshot() {
        Allure.getLifecycle().addAttachment("Screenshot", "image/png", "png", getScreenshotBytes());
        Allure.getLifecycle().addAttachment("Page source", "text/html", "html", getPageSourceBytes());
    }
}

