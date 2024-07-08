import constant.NameBlock;
import io.qameta.allure.junit4.DisplayName;
import lombok.extern.slf4j.Slf4j;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static constant.NameBlock.*;
import static org.junit.Assert.assertTrue;

@Slf4j
@RunWith(Parameterized.class)
public class ConstructorTest {
    private WebDriver driver;
    private static final String URL= "https://stellarburgers.nomoreparties.site";
    private HomePage homePage;
    private NameBlock nameBlock;
    private String element = "tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect";

    public ConstructorTest(NameBlock nameBlock) {

        this.nameBlock = nameBlock;
    }

    @Parameterized.Parameters
    public static Object[][] geParameters() {
        return new Object[][]{
                {BUN},
                {SAUCE},
                {FILLING}
        };
    }

        @Before
        public void create() {
            driver = new ChromeDriver();
            homePage = new HomePage(driver);
            driver.get(URL);
        }

    @After
    public void quite() {

        driver.quit();
    }

    @Test
    @DisplayName("Переход к разделам Конструктора")
    public void clickSectionTest() {
        homePage.blockClick( nameBlock );

        String actual = homePage.classNameGet( nameBlock );

        assertTrue(actual.contains(element));
    }
}
