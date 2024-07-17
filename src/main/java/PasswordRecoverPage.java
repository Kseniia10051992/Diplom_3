import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PasswordRecoverPage {
    private final WebDriver driver;
    private final By buttonLogin = By.linkText("Войти");

    public PasswordRecoverPage(WebDriver driver) {

        this.driver = driver;
    }

    public void loginButtonClick() {

        driver.findElement(buttonLogin).click();
    }
}
