import constant.NameBlock;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {
    private final WebDriver driver;
    private final By logoHomePage = By.xpath(".//*[@class='active']");
    private final By personalAccountButton = By.xpath(".//p[text() = 'Личный Кабинет']");
    private final By loginButton = By.xpath(".//button[text()='Войти в аккаунт']");
    public final By bunBlock = By.xpath(".//*[text()='Булки']//parent::div");
    public final By sauceBlock = By.xpath(".//*[text()='Соусы']//parent::div");
    public final By fillingBlock = By.xpath(".//*[text()='Начинки']//parent::div");
    public static final String CLASS = "class";
    public HomePage(WebDriver driver) {

        this.driver = driver;
    }

    public void personalAccountClick() {
        waitingHeaderLoad();
        driver.findElement(personalAccountButton).click();
    }

    public void loginButtonClick() {

        driver.findElement(loginButton).click();
    }

    public void waitingHeaderLoad() {
        new WebDriverWait(driver, Duration.ofSeconds(3)).until( driver -> (driver.findElement(logoHomePage).isEnabled()
        ));
    }

    public void bunСlick() {
       waitingHeaderLoad();
        sauceClick();
        driver.findElement(bunBlock).click();
    }

    public void sauceClick() {
        waitingHeaderLoad();
        driver.findElement(sauceBlock).click();
    }

    public void fillingClick() {
        waitingHeaderLoad();
        driver.findElement(fillingBlock).click();
    }

    public void blockClick(NameBlock nameBlock) {
        switch (nameBlock) {
            case BUN:
                bunСlick();
                break;
            case SAUCE:
                sauceClick();
                break;
            case FILLING:
                fillingClick();
                break;
        }
    }

    public WebElement blockGet(NameBlock nameBlock) {
        switch (nameBlock) {
            case BUN:
                return driver.findElement( bunBlock );
            case SAUCE:
                return driver.findElement( sauceBlock );
            case FILLING:
                return driver.findElement( fillingBlock );
            default:
                throw new RuntimeException( "Некорректное название элемента" );
        }
    }

    public String classNameGet(NameBlock nameBlock) {

        return blockGet( nameBlock ).getAttribute(CLASS);
    }
    }

