package Go.Mail;

/**
 * Created by philipp on 19.03.14.
 */
import org.openqa.selenium.WebDriver;

public class GoPage {
    WebDriver driver;

    public GoPage(WebDriver driver) {
        this.driver = driver;
    }

    public void GoPage() {

    }

    public SearchEl GetSearch() {
        return new SearchEl(this.driver);
    }




}
