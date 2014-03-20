package Go.Mail;

/**
 * Created by philipp on 19.03.14.
 */
import org.openqa.selenium.WebDriver;

public class ResultSearch {

    private WebDriver driver;
    public ResultSearch() {

    }

    public ResultSearch(WebDriver driver) {
        this.driver = driver;
    }

    public SearchEl getSearchFormElement() {
        return new SearchEl(driver);
    }


    public String getTitle() {
        return driver.getTitle();
    }

    public Podmes getPodmes() {
        return new Podmes(this.driver);
    }
}

