package steps;

import io.cucumber.java.ru.И;
import io.cucumber.java.ru.Когда;
import pages.BasePage;
import runner.RunnerTest;

import static com.codeborne.selenide.Selenide.open;
import static pages.BasePage.clickElementByText;

public class BaseSteps extends RunnerTest {

    private BasePage basePage = new BasePage();

    @Когда("открываем сайт {string}")
    public void открываемСайт(String url) {
        open(url);
    }

    @И("нажимаем {string}")
    public void нажимаем(String text) {
        clickElementByText(text);
        makeScreenshot();
    }

}
