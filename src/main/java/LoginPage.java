import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    private final WebDriver driver;
    private final By headerLogin = By.xpath(".//h2[text() = 'Вход']");
    private final By loginFormAll = By.xpath(".//*[@class='text input__textfield text_type_main-default']");
    private final By buttonLogin = By.xpath(".//button[text() = 'Войти']");
    private final By buttonRegistration = By.linkText("Зарегистрироваться");
    private final By recoverPassword = By.linkText("Восстановить пароль");


    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void registrationClick() {
        driver.findElement(buttonRegistration).click();
    }

    public void loginClick() {
        driver.findElement(buttonLogin).click();
    }

    public void recoverPasswordClick() {
        driver.findElement(recoverPassword).click();
    }

    public LoginPage waitingHeaderLoad() {
        new WebDriverWait(driver, Duration.ofSeconds(3)).until(driver -> (driver.findElement(headerLogin).getText() != null
                && !driver.findElement(headerLogin).getText().isEmpty()
        ));
        return this;
    }

    public LoginPage setEmail(String newEmail) {
        getEmailField().sendKeys(newEmail);
        return this;
    }

    public LoginPage setPassword(String newPassword) {
        getPasswordField().sendKeys(newPassword);
        return this;
    }

    private WebElement getEmailField() {
        return driver.findElements(loginFormAll).get(0);
    }

    private WebElement getPasswordField() {
        return driver.findElements(loginFormAll).get(1);
    }
}
