import constant.NameButtonForLogin;
import generator.GeneratorUser;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.http.ContentType;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import user.User;
import static io.restassured.RestAssured.given;

public class GeneralTest {
    public WebDriver driver;
    public User user;
    private static final String URL = "https://stellarburgers.nomoreparties.site";
    private final GeneratorUser generatorUser = new GeneratorUser();
    public LoginPage loginPage;
    public HomePage homePage;
   public RegistrationPage registrationPage;
    public PasswordRecoverPage passwordRecoverPage;
    public TheUserPage theUserPage;



    @Before
    public void create() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get(URL);
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
        registrationPage = new RegistrationPage(driver);
        passwordRecoverPage = new PasswordRecoverPage(driver);
        theUserPage = new TheUserPage(driver);
        userCreate();
    }

    @After
    public void delete() {
        driver.quit();
        userDelete();
    }

    private void userCreate() {
        user = generatorUser.userGet();
        given().contentType( ContentType.JSON)
                .body(user)
                .post(URL + "/api/auth/register");
    }

    private void userDelete() {
        String accessToken = given()
                .contentType(ContentType.JSON)
                .body(user)
                .post(URL + "/api/auth/login")
                .body().path("accessToken");
        given().contentType(ContentType.JSON)
                .header("Authorization", accessToken)
                .body(user).delete(URL+ "/api/auth/user");
    }

    public void quiteButton(NameButtonForLogin buttonName) {
        switch (buttonName) {
            case LOGIN_IN_USING_THE_IN_TO_ACCOUNT_BUTTON_ON_THR_HOME_PAGE:
                homePage.loginButtonClick();
                break;
            case LOGIN_VIA_THE_PERSONAL_ACCOUNT_BUTTON:
                homePage.personalAccountClick();
                break;
            case LOGIN_IN_VIA_THE_BUTTON_IN_THE_REGISTRATION_FORM:
                homePage.personalAccountClick();
                loginPage.registrationClick();
                registrationPage.loginClick();
                break;
            case LOGIN_VIA_THE_BUTTON_IN_THE_PASSWORD_RECOVERY_FORM:
                homePage.personalAccountClick();
                loginPage.recoverPasswordClick();
                passwordRecoverPage.loginButtonClick();
                break;
        }
    }
}
