package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import lombok.Getter;

import java.awt.*;

import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

@Getter
public class DepositsPage extends BasePage {

    private ElementsCollection checkTextList = $$(".calculator__check-text");

    private ElementsCollection checkBoxList = $$(".calculator__check-block-input");

    private SelenideElement depositInput = $("[name='amount']");

    private ElementsCollection sliderTitleList = $$(".calculator__slide-section .calculator__slide-input-label");

    private ElementsCollection sliderList = $$(".calculator__slide-row");

    private ElementsCollection sliderHandleList = $$(".ui-slider-handle");

    private SelenideElement printForm = $(byId("deposits-compare-window"));

    public void selectCheckBox(String checkText) {
        assertEquals("The number of checkboxes must match the number of headers", checkBoxList.size(), checkTextList.size());
        for (int i = 0; i < checkTextList.size(); i++) {
            if (checkTextList.get(i).getText().equals(checkText)) {
                checkBoxList.get(i).click();
                return;
            }
        }
        throw new AssertionError("checkbox not found: " + checkText);
    }

    public void moveSlider(String sliderTitle) {
        assertEquals("The number of sliders must match the number of headers", sliderList.size(), sliderTitleList.size());
        assertEquals("The number of sliders must match the number of slider-handles", sliderHandleList.size(), sliderList.size());
        int index = -1;
        for (int i = 0; i < sliderTitleList.size(); i++) {
            if (sliderTitleList.get(i).getText().equals(sliderTitle)) {
                index = i;
                break;
            }
        }
        assertTrue("slider not found: " + sliderTitle, index > 0);

        Selenide.actions()
                .moveToElement(sliderHandleList.get(index))
                .clickAndHold()
                .moveToElement(sliderHandleList.get(index))
                .build()
                .perform();
    }
}
