import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class Test {

    static WebDriver driver;
    private LoginPage loginPage;

    @BeforeMethod
    public void beforeMethod() {
        System.setProperty("webdriver.chrome.driver", "D:\\ddd\\src\\main\\resources\\chromedriver.exe");
        System.setProperty("webdriver.gecko.driver", "D:\\ddd\\src\\main\\resources\\geckodriver.exe");
        driver = new FirefoxDriver();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://prestashop-automation.qatestlab.com.ua/admin147ajyvk0/");

        loginPage = PageFactory.initElements(driver, LoginPage.class);
    }

    @org.testng.annotations.Test
    public void test() {

        loginPage.login(" webinar.test@gmail.com", "Xcg7299bnSmMuRLp9ITw");

    }
}