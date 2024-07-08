import constant.NameButtonForConstructor;
import io.qameta.allure.Step;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static constant.NameButtonForConstructor.*;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class SwitchingPersonalAccToConstructor extends GeneralTest {
    public NameButtonForConstructor buttonName;
    public SwitchingPersonalAccToConstructor(NameButtonForConstructor buttonName) {
        this.buttonName = buttonName;
    }

    @Parameterized.Parameters
    public static Object[][] getParameters() {
        return new Object[][]{
                {},
                {LOGO}
        };
    }

    @Test
    @DisplayName("Переход в Конструктор из личного кабинета")
    public void transitionToConstructorFromLk() {
        transitionToLk();

        theUserPage.waitLoadingPage()
                .editButton(buttonName);

        String Url = "https://stellarburgers.nomoreparties.site/";

        assertEquals(Url, driver.getCurrentUrl());
    }

    @Step("Переход в личный кабинет")
    private void transitionToLk() {
        homePage.personalAccountClick();
        loginPage.waitingHeaderLoad()
                .setEmail(user.getEmail())
                .setPassword(user.getPassword())
                .loginClick();
        homePage.personalAccountClick();
    }
}