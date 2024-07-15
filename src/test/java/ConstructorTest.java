import constant.NameBlock;
import io.qameta.allure.junit4.DisplayName;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import static constant.NameBlock.*;
import static org.junit.Assert.assertTrue;

@Slf4j
@RunWith(Parameterized.class)
public class ConstructorTest extends GeneralTest{
    private final NameBlock nameBlock;

    public ConstructorTest(NameBlock nameBlock) {

        this.nameBlock = nameBlock;
    }

    @Parameterized.Parameters
    public static Object[][] geParameters() {
        return new Object[][]{
                {BUN},
                {SAUCE},
                {FILLING}
        };
    }

    @Test
    @DisplayName("Переход к разделам Конструктора")
    public void clickSectionTest() {
        homePage.blockClick( nameBlock );

        String actual = homePage.classNameGet( nameBlock );

        assertTrue(actual.contains(HomePage.ELEMENT));
    }
}