package Go.Mail;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by philipp on 19.03.14.
 */

public class Podmes {
    private WebDriver driver;

    public Podmes() {

    }

    public Podmes(WebDriver driver) {
        this.driver = driver;
    }

    public String GetInputValue() {
        String val = new String(this.driver.findElement(By.id("ival")).getAttribute("value"));
        return val;
    }

    public String GetInputClass(String data) {
        String val = new String(this.driver.findElement(By.id("ival")).getCssValue(data));
        return val;
    }
    //change_conv
    public Podmes ClickSwapButton() {
        driver.findElement(By.id("change_conv")).click();
        return this;
    }

    public String GetResValue() {
        String val = new String(this.driver.findElement(By.id("oval")).getText());
        return val;
    }

    public String GetNameString() {
        String val = new String(this.driver.findElement(By.className("smack-converter__title")).getText());
        return val;
    }

    public String GetFirstValueString() {
        String val = new String(this.driver.findElement(By.id("icode")).getText());
        return val;
    }

    public String GetSecondValueString() {
        String val = new String(this.driver.findElement(By.id("ocode")).getText());
        return val;
    }

    public Podmes SetInputValue(String data) {
        this.driver.findElement(By.id("ival")).clear();
        this.driver.findElement(By.id("ival")).sendKeys(data);
        return this;
    }

    public Podmes ChangeTypeConvert() {
        this.driver.findElement(By.cssSelector("#icode")).click();
        this.driver.findElement(By.cssSelector("span[data-code='4']")).click();

        this.driver.findElement(By.cssSelector("#ocode")).click();
        this.driver.findElement(By.cssSelector("#change_conv~.smack-converter__select span[data-code='2']")).click();
        return this;
    }

}
