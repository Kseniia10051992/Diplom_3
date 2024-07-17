package generator;
import org.apache.commons.lang3.RandomStringUtils;
import user.User;

public class GeneratorUser {
    public User userGet() {
        return new User(nameGet(), emailGet(), correctPasswordGet());
    }
    public String nameGet() {
        return RandomStringUtils.randomAlphabetic(10);
    }

    public String emailGet() {
        return String.format("%s@%s.ru", RandomStringUtils.randomAlphabetic(5),
                RandomStringUtils.randomAlphabetic(4));
    }
    public String correctPasswordGet() {

        return RandomStringUtils.randomAlphanumeric(8);
    }

    public String uncorrectedPasswordGet() {

        return RandomStringUtils.randomAlphanumeric(5);
    }
}