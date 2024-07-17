import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RegistrationPage {
    private final WebDriver driver;
    private final By registrationHeader = By.xpath(".//h2[text() = 'Регистрация']");
    private final By buttonRegistration = By.xpath(".//button[text() = 'Зарегистрироваться']");
    private final By registrationFormAll = By.xpath(".//*[@class='text input__textfield text_type_main-default']");

    private final By passwordException = By.xpath(".//*[@class='input__error text_type_main-default' and text()='Некорректный пароль']");
    private final By buttonLogin = By.linkText("Войти");
    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
    }

    private void waitDownloadPage() {
        new WebDriverWait(driver, Duration.ofSeconds(3)).until( driver -> (driver.findElement(registrationHeader).getText() != null
                && !driver.findElement(registrationHeader).getText().isEmpty()
        ));
    }

    public RegistrationPage setName(String newName) {
        waitDownloadPage();
        nameFieldGet().sendKeys(newName);
        return this;
    }

    public RegistrationPage setEmail(String newEmail) {
        emailFieldGet().sendKeys(newEmail);
        return this;
    }

    public RegistrationPage setPassword(String newPassword) {
        passwordFieldGet().sendKeys(newPassword);
        return this;
    }

    public void clickRegisterButton() {
        driver.findElement(buttonRegistration).click();
    }

    public String getTextException() {
        return driver.findElement(passwordException).getText();
    }

    public void loginClick() {

        driver.findElement(buttonLogin).click();
    }

    private WebElement nameFieldGet() {

        return driver.findElements(registrationFormAll).get(0);
    }

    private WebElement emailFieldGet() {
        return driver.findElements(registrationFormAll).get(1);
    }

    private WebElement passwordFieldGet() {
        return driver.findElements(registrationFormAll).get(2);
    }
}
