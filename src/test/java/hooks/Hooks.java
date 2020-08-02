package hooks;


import com.codeborne.selenide.Configuration;
import io.cucumber.core.api.Scenario;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import lombok.extern.slf4j.Slf4j;

import static com.codeborne.selenide.Browsers.CHROME;
import static io.cucumber.core.event.Status.PASSED;
import static runner.RunnerTest.makeScreenshot;
import static utill.Constants.BATH_TIMEOUT;

@Slf4j
public class Hooks {

    @Before
    public void startScenario(Scenario scenario)
    {
        Configuration.browser = CHROME;
        Configuration.startMaximized = true;
        Configuration.timeout = BATH_TIMEOUT;
        System.out.println("------------------------------------------------------------");
        System.out.println("Запуск сценария - '" + scenario.getName() + "'");
        System.out.println("------------------------------------------------------------");
    }

    @After
    public static void checkScenarioResult(Scenario scenario) {
        System.out.println("------------------------------------------------------------");
        System.out.println("Сценарий '" + scenario.getName());
        System.out.println("----------" + scenario.getStatus() + "----------");
        if (!scenario.getStatus().equals(PASSED))
            makeScreenshot();
        System.out.println("------------------------------------------------------------");
    }

}
