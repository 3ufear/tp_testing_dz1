package Go.Mail;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by philipp on 19.03.14.
 */
public class SearchEl {
    private WebDriver driver;
    public SearchEl() {

    }

    public SearchEl(WebDriver driver) {
        this.driver = driver;
    }
    public ResultSearch clickGoButton() {
        driver.findElement(By.cssSelector(".js-is-not-scrollable")).submit();

        return new ResultSearch(this.driver);
    }
    public SearchEl inputSearchString(String query) {
        driver.findElement(By.id("q")).sendKeys(query);
        return this;
    }
    public SearchEl cleanButton() {
        driver.findElement(By.id("go-form__qclear")).click();

        return this;
    }
    public ResultSearch SearchKgFunts() {
        this.inputSearchString("кг в фунты");
        return this.clickGoButton();
    }
}
