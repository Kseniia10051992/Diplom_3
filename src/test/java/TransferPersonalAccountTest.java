import io.qameta.allure.Step;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TransferPersonalAccountTest extends GeneralTest {

    @Test
    @DisplayName("Переход в Личный кабинет авторизованным пользователем")
    public void personalAreaButtonWithAuthUser() {
        logPersonalAccount();
        homePage.personalAccountClick();
        theUserPage.waitLoadingPage();
        assertEquals(user.getName(), theUserPage.userNameGet());
        assertEquals(user.getEmail(), theUserPage.userLoginGet());
    }

    @Test
    @DisplayName("Выход из Личного кабинета")
    public void exitPersonalAccount() {
        logPersonalAccount();
        toLkAfterAutorization();
        theUserPage.clickExit();
        loginPage.waitingHeaderLoad();
        String Url = "https://stellarburgers.nomoreparties.site/login";
        assertEquals(Url, driver.getCurrentUrl());
    }

    @Step("Вход в дичный кабинет")
    private void logPersonalAccount() {
        homePage.personalAccountClick();
        loginPage.waitingHeaderLoad()
                .setEmail(user.getEmail())
                .setPassword(user.getPassword())
                .loginClick();
    }

    @Step("Переход по клику на «Личный кабинет»")
    private void toLkAfterAutorization() {
        homePage.personalAccountClick();
        theUserPage.waitLoadingPage();
    }
}
