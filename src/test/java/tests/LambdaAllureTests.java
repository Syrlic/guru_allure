package tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


public class LambdaAllureTests {

    public static final String REPOSITORY = "Syrlic/guru_allure";
    public static final String NUMBER = "1";
    @BeforeAll
    public static void setup(){
        Configuration.startMaximized = true;
    }

    @Test
    public void  testIssuePresentInRepoLambda(){
        SelenideAllureTests allureTests = new SelenideAllureTests();

        open("https://github.com");
        $("input[name='q']").click();
        $("input[name='q']").sendKeys(REPOSITORY);
        $("input[name='q']").submit();
        $(".repo-list").$("a").click();
        $("span[data-content='Issues']").click();
        $("#issue_1").shouldHave(Condition.text("#1"));
                //.shouldHave(Condition.text("#1"));

    }
}
