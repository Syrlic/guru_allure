package tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class LambdaAllureTests {

    @BeforeAll
    public static void setup(){
        Configuration.startMaximized = true;
    }

    @Test
    public void  testIssuePresentInRepoLambda(){
        open("https://github.com");
        $("input[name='q']").click();
        $("input[name='q']").sendKeys("/Syrlic/guru_allure/issues");
        $("input[name='q']").submit();
        $("div[area_label='Issues]").shouldHave(Condition.text("#1"));

    }
}
