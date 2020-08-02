package pages;

import com.codeborne.selenide.ElementsCollection;

import static com.codeborne.selenide.Selenide.$$;
import static junit.framework.TestCase.assertEquals;

public class MainPage extends BasePage {

    private ElementsCollection serviceTitleList = $$(".services_main .service__title-text");

    private ElementsCollection serviceList = $$(".services_main .service__title");

    public void goToService(String serviceTitle) {
        assertEquals("service title number should be same service number ", serviceTitleList.size(), serviceList.size());
        for (int i = 0; i < serviceTitleList.size(); i++) {
            if (serviceTitleList.get(i).getText().equals(serviceTitle)) {
                serviceList.get(i).click();
                return;
            }
        }
        throw new IllegalArgumentException("service with title:" + serviceTitle + " not found");
    }


}
