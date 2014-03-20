package go.mail;

/**
 * Created by philipp on 19.03.14.
 */
import Go.Mail.GoPage;
import Go.Mail.Podmes;
import Go.Mail.ResultSearch;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.net.MalformedURLException;
import java.net.URL;

public class test {
    private WebDriver driver;

    @BeforeMethod
    @Parameters({"browser", "hub", "url"})
    public void setUp(String browser, String hub, String url) throws MalformedURLException {
       if (browser.toLowerCase().equals("chrome"))
            this.driver = new RemoteWebDriver(new URL(hub), DesiredCapabilities.chrome());
        else if (browser.toLowerCase().equals("firefox"))
            this.driver = new RemoteWebDriver(new URL(hub), DesiredCapabilities.firefox());
        else
            throw new NotImplementedException();
        this.driver.manage().window().maximize();
        this.driver.get(url);

    }

    @Test
    public void Test_comboboxes() {
        Podmes pd;
        pd = new GoPage(this.driver).GetSearch().SearchKgFunts().getPodmes();
        pd.ChangeTypeConvert();
        Assert.assertEquals(pd.GetFirstValueString(), "тройская унция");
        Assert.assertEquals(pd.GetSecondValueString(),"грамма");
    }

    @Test
    public void Test_Input_Text() {
        Podmes pd;
        pd = new GoPage(this.driver).GetSearch().SearchKgFunts().getPodmes();
        Assert.assertEquals(pd.GetInputClass("color"),"rgba(0, 0, 0, 1)");
        pd.SetInputValue("аааа");
        Assert.assertEquals(pd.GetInputClass("color"),"rgba(255, 0, 0, 1)");
        pd.SetInputValue("-4");
        Assert.assertEquals(pd.GetInputClass("color"),"rgba(255, 0, 0, 1)");

    }

    @Test
    public void Test_Get_All_Elements() {
        Podmes pd;
        pd = new GoPage(this.driver).GetSearch().SearchKgFunts().getPodmes();
        Assert.assertEquals(pd.GetNameString(), "Конвертер величин:вес");
        Assert.assertEquals(pd.GetFirstValueString(),"килограмм");
        Assert.assertEquals(pd.GetSecondValueString(),"фунта");
    }

    @Test
    public void Test_swap_values() {
        Podmes pd;
        pd = new GoPage(this.driver).GetSearch().SearchKgFunts().getPodmes();
        Assert.assertEquals(pd.GetFirstValueString(),"килограмм");
        Assert.assertEquals(pd.GetSecondValueString(),"фунта");
        pd.ClickSwapButton();
        Assert.assertEquals(pd.GetFirstValueString(),"фунт");
        Assert.assertEquals(pd.GetSecondValueString(),"килограмма");

    }


    @Test
    public void Test_input() {
        Podmes kg;
        kg = new GoPage(this.driver).GetSearch().SearchKgFunts().getPodmes().SetInputValue("123");
        Assert.assertEquals(kg.GetInputValue(), "123");
        Assert.assertEquals(kg.GetResValue(),"271,16858");
        kg.SetInputValue("0");
        Assert.assertEquals(kg.GetInputValue(), "0");
        Assert.assertEquals(kg.GetResValue(),"0");
    }

    @Test
    public void Test_search_go_kg_funts() {
        String kg;
        kg = new GoPage(this.driver).GetSearch().inputSearchString("пять килограмм в фунты").clickGoButton().getPodmes().GetInputValue();
        Assert.assertEquals(kg,"5");
        kg = new ResultSearch(this.driver).getSearchFormElement().cleanButton().SearchKgFunts().getPodmes().GetInputValue();
        Assert.assertEquals(kg,"1");
    }

    @AfterMethod
    public void tearDown() {
        this.driver.close();
    }
}
