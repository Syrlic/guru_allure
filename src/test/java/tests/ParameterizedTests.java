package tests;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static io.qameta.allure.Allure.parameter;
import static io.qameta.allure.Allure.step;

public class ParameterizedTests {

    @ParameterizedTest(name = "Check city in state")
    @CsvSource({
            "Austin, Texas",
            "Tulsa, Oklahoma",
            "Orlando, Florida"
    })
    public void regionTest(String city, String state){
        parameter("State", state);
        parameter("City", city);

        step("Open region:" + state);
        step("Check the city that should be:" + city);
    }
}
