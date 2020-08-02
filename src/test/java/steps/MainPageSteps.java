package steps;

import io.cucumber.java.ru.И;
import io.cucumber.java.ru.Тогда;
import pages.MainPage;
import runner.RunnerTest;

import static com.codeborne.selenide.Selenide.page;
import static pages.BasePage.checkVisibleElementByText;

public class MainPageSteps extends RunnerTest {

    private MainPage mainPage = page(MainPage.class);

    @И("переходим на страницу {string}")
    public void переходимНаCтраницу(String section){
        mainPage.goToService(section);
    }

    @Тогда("отображается секция {string}")
    public void отображаетсяСекция(String section) {
        checkVisibleElementByText(section);
        makeScreenshot();
    }
}
