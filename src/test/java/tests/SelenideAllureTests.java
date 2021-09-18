package tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.*;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

import static com.codeborne.selenide.Selectors.byAttribute;
import static com.codeborne.selenide.Selenide.*;

public class SelenideAllureTests {

    public static final String URL = "https://github.com";
    public static final String REPOSITORY = "Syrlic/guru_allure";
    public static final String NUMBER = "1";

    @BeforeAll
    public static void setup(){
        Configuration.startMaximized = true;
    }

    @Test
    @Owner("klonina")
    @Feature("Issues")
    @Story("Search for issues")
    @Severity(SeverityLevel.BLOCKER)
    @DisplayName("Issue present test")
    public void testIssuePresentInRepoSelenide(){
        SelenideLogger.addListener("allure", new AllureSelenide());

            open(URL);
            $("input[name='q']").click();
            $("input[name='q']").sendKeys(REPOSITORY);
            $("input[name='q']").submit();
            $(byAttribute("href", "/"+REPOSITORY)).click();
            $("span[data-content='Issues']").click();
            $("#issue_1").shouldHave(Condition.text("#"+NUMBER));
    }


}

