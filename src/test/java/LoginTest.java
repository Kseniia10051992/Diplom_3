import constant.NameButtonForLogin;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import static constant.NameButtonForLogin.*;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class LoginTest extends GeneralTest {
    public static final String URL = "https://stellarburgers.nomoreparties.site/";
    private final NameButtonForLogin nameButtonLogin;
    public LoginTest(NameButtonForLogin nameButtonLogin) {

        this.nameButtonLogin = nameButtonLogin;
    }

    @Parameterized.Parameters
    public static Object[][] getParameters() {
        return new Object[][]{
                {LOGIN_IN_USING_THE_IN_TO_ACCOUNT_BUTTON_ON_THR_HOME_PAGE},
                {LOGIN_VIA_THE_PERSONAL_ACCOUNT_BUTTON},
                {LOGIN_IN_VIA_THE_BUTTON_IN_THE_REGISTRATION_FORM},
                {LOGIN_VIA_THE_BUTTON_IN_THE_PASSWORD_RECOVERY_FORM}
        };
    }

    @Test
    @DisplayName("Вход в личный кабинет")
    public void loginTest() {
        quiteButton(nameButtonLogin);

        loginPage.waitingHeaderLoad()
                .setEmail(user.getEmail())
                .setPassword(user.getPassword())
                .loginClick();

        homePage.waitingHeaderLoad();

        String actualUrl = driver.getCurrentUrl();

        assertEquals(URL, actualUrl);
    }
}