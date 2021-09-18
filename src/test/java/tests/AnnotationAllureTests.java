package tests;

import com.codeborne.selenide.Configuration;
import io.qameta.allure.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class AnnotationAllureTests {

    public static final String URL = "https://github.com";
    public static final String REPOSITORY = "Syrlic/guru_allure";
    public static final String NUMBER = "1";

    WebSteps steps = new WebSteps();

    @BeforeAll
    public static void setup(){
        Configuration.startMaximized = true;
    }

    @Test
    public void testIssuePresentInRepoAnnotation(){
    steps.openMainPage(URL);
    steps.searchForRepository(REPOSITORY);
    steps.openRepository(REPOSITORY);
    steps.proceedIssuesTab();
    steps.shouldSeeIssueWithNumber(NUMBER);

    }
}
