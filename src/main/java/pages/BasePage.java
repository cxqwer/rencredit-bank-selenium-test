package pages;

import com.codeborne.selenide.Condition;
import lombok.AllArgsConstructor;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static utill.Constants.BATH_TIMEOUT;

@AllArgsConstructor
public class BasePage {

    public static void checkVisibleElementByText(String elementText) {
        $(byText(elementText)).waitUntil(Condition.visible, BATH_TIMEOUT);
    }

    public static void clickElementByText(String elementText) {
        $(byText(elementText)).click();
    }

}
