package pages;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;

import java.util.Map;

import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selenide.$;

@Getter
public class СardRequestPage extends BasePage{

    private SelenideElement orderForm = $(".order-form");

    private SelenideElement surnameInput = $(byId("t1"));

    private SelenideElement nameInput = $(byId("t2"));

    private SelenideElement patronymicCheckbox = $("[data-ignoreid='1']");

    public void fillForm(Map<String, String> map){
        if (map.containsKey("Фамилия"))
            surnameInput.sendKeys(map.get("Фамилия"));
        if (map.containsKey("Имя"))
            nameInput.sendKeys(map.get("Имя"));
    }
}
