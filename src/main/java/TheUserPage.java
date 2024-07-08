import constant.NameButtonForConstructor;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static constant.NameButtonForConstructor.CONSTRUCTOR;
import static constant.NameButtonForConstructor.LOGO;

public class TheUserPage {
    private final WebDriver driver;
    private final By buttonProfile = By.xpath(".//*[text()='Профиль']");
    private final By buttonLogo = By.xpath(".//*[@class='AppHeader_header__logo__2D0X2']");
    private final By buttonConstructor = By.linkText("Конструктор");
    private final By userFieldsAll = By.xpath(".//*[@class='text input__textfield text_type_main-default input__textfield-disabled']");
    private final By buttonExit = By.xpath(".//button[text()='Выход']");

    public TheUserPage(WebDriver driver) {
        this.driver = driver;
    }

    public TheUserPage waitLoadingPage() {
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(driver -> (driver.findElement(buttonProfile).isEnabled()
        ));
        return this;
    }

    public String userNameGet() {
        return driver.findElements(userFieldsAll).get(0).getAttribute("value");
    }

    public String userLoginGet() {
        return driver.findElements(userFieldsAll).get(1).getAttribute("value");
    }

    public void clickConstructorButton() {
        driver.findElement(buttonConstructor).click();
    }

    public void clickLogo() {
        driver.findElement(buttonLogo).click();
    }

    public void clickExit() {
        driver.findElement(buttonExit).click();
    }

    public void editButton(NameButtonForConstructor buttonName) {
        switch (buttonName) {
            case CONSTRUCTOR:
                clickConstructorButton();
                break;
            case LOGO:
                clickLogo();
                break;
        }
    }
}