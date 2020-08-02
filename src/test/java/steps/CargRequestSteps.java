package steps;

import com.codeborne.selenide.Condition;
import io.cucumber.java.ru.И;
import io.cucumber.java.ru.Тогда;
import pages.СardRequestPage;
import runner.RunnerTest;

import java.util.Map;

import static com.codeborne.selenide.Selenide.page;
import static utill.Constants.BATH_TIMEOUT;

public class CargRequestSteps extends RunnerTest {

    private СardRequestPage cardRequestPage = page(СardRequestPage.class);


    @Тогда("открыта форма заполнения заявки на карту")
    public void открытаФормаЗаполненияЗаявкиНаКарту() {
        cardRequestPage.getOrderForm().waitUntil(Condition.visible, BATH_TIMEOUT);
        makeScreenshot();
    }

    @И("заполнить следующие поля значениями:")
    public void заполнитьСледующиеПоляЗначениями(Map<String, String> map) {
        cardRequestPage.fillForm(map);
        makeScreenshot();
    }

    @И("выбрать чекбокс Нет отчества")
    public void выбратьЧекбоксНетОтчества() {
        cardRequestPage.getPatronymicCheckbox().click();
        makeScreenshot();
    }
}
