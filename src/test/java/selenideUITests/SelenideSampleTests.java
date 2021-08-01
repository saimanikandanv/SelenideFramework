package selenideUITests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import io.qameta.allure.selenide.LogType;
import org.openqa.selenium.By;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.logging.Level;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

/**
 * Created by Saimanikandan V on 01-08-2021
 */
public class SelenideSampleTests {

    @BeforeTest
    public void setUp()
    {
        Configuration.startMaximized=true;
        SelenideLogger.addListener("allure Selenide",new AllureSelenide()
                .enableLogs(LogType.DRIVER, Level.ALL)
                .screenshots(true));
    }

    @Test
    public void googleTest()
    {
        open("http://www.google.com");
        $(By.name("q")).setValue("facebook");
    }

    @AfterTest
    public void tearDown(){
        SelenideLogger.removeListener("allure Selenide");
        Selenide.closeWebDriver();
    }
}
