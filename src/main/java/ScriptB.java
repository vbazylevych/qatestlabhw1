import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static org.openqa.selenium.By.*;

public class ScriptB {

    public static void main(String[] args) throws InterruptedException {
        final WebDriver driver = getDriver();
        driver.get("http://prestashop-automation.qatestlab.com.ua/admin147ajyvk0/");
        WebElement email = driver.findElement(id("email"));
        email.sendKeys("webinar.test@gmail.com");

        WebElement password = driver.findElement(id("passwd"));
        password.sendKeys("Xcg7299bnSmMuRLp9ITw");

        WebElement submitLogin = driver.findElement(name("submitLogin"));
        submitLogin.click();

        Thread.sleep(300);

        int menuSize = driver.findElements(By.xpath(("//nav/ul/li[contains(@class,'maintab')]"))).size();

        for (int i = 0; i < menuSize; i++) {

            List<WebElement> allMenuElements = driver.findElements(By.xpath(("//nav/ul/li[contains(@class,'maintab')]")));
            allMenuElements.get(i).click();
            writeTitleName(driver);
            Thread.sleep(2000);

            driver.navigate().refresh();
            writeTitleName(driver);
            Thread.sleep(2000);

            driver.findElement(xpath("//nav/ul/li[1]")).click();
            Thread.sleep(2000);
        }
    }

    private static void writeTitleName(WebDriver driver) {
        String title = driver.findElement(By.xpath("//h2")).getText();
        System.out.println(title);
    }

    public static WebDriver getDriver() {
        System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "//src/main/resources/geckodriver.exe");
        FirefoxDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        return driver;
    }
}
