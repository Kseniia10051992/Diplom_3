import generator.GeneratorUser;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Step;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertEquals;

public class RegistrationTest extends GeneralTest{
    public static final String INVALID_PASSWORD = "Некорректный пароль";
    private final GeneratorUser generatorUser = new GeneratorUser();
    private final String url2 = "https://stellarburgers.nomoreparties.site/login";
    private String actual;



    @Test
    @DisplayName("Успешная регистрация. Минимальный пароль — шесть символов")
    public void createCorrectUser() {
        toRegisterPage();
        registrationPage.setName( generatorUser.nameGet())
                .setEmail( generatorUser.emailGet())
                .setPassword( generatorUser.correctPasswordGet())
                .clickRegisterButton();

        loginPage.waitingHeaderLoad();

        actual = driver.getCurrentUrl();

        assertEquals(url2, actual);
    }

    @Test
    @DisplayName("Регистрация с некорректным паролем меньше шести символов")
    public void createUserIncorrectPassword() {
        toRegisterPage();
        registrationPage.setName( generatorUser.nameGet())
                .setEmail( generatorUser.emailGet())
                .setPassword( generatorUser.uncorrectedPasswordGet())
                .clickRegisterButton();

        actual = registrationPage.getTextException();

        assertEquals(INVALID_PASSWORD, actual);
    }
    @Step("Переход на форму регистрации")
    private void toRegisterPage() {
        homePage.personalAccountClick();
        loginPage.registrationClick();

    }
}