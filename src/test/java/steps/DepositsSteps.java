package steps;

import com.codeborne.selenide.Condition;
import cucumber.api.java.ru.И;
import io.cucumber.java.ru.Тогда;
import pages.DepositsPage;
import runner.RunnerTest;

import static com.codeborne.selenide.Selenide.page;
import static pages.BasePage.checkVisibleElementByText;

public class DepositsSteps extends RunnerTest {

    private DepositsPage depositsPage = page(DepositsPage.class);


    @И("выбираем чекбокс {string}")
    public void выбираемЧекбокс(String checkbox) {
        depositsPage.selectCheckBox(checkbox);
        makeScreenshot();
    }

    @И("вносим сумму вклада {int}")
    public void вносимСуммуВклада(int depositValue) {
        depositsPage.getDepositInput().setValue(String.valueOf(depositValue));
        makeScreenshot();
    }

    @И("передвигаем ползунок {string}")
    public void передвигаемПолзунок(String sliderTitle) {
        depositsPage.moveSlider(sliderTitle);
        makeScreenshot();
    }

    @Тогда("отображается чекбокс {string}")
    public void отображаетсяЧекбокс(String checkbox) {
        checkVisibleElementByText(checkbox);
        makeScreenshot();
    }

    @Тогда("отображается печатная форма Сравнение вкладов")
    public void отображаетсяПечатнаяФормаСравнениеВкладов() {
        depositsPage.getPrintForm().shouldBe(Condition.visible);
        makeScreenshot();
    }
}
