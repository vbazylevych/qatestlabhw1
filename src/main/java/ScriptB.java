import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
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

        List<WebElement> menu_li = driver.findElements(By.xpath(("//nav[@id='nav-sidebar']/ul/li[contains(@class,'maintab')]")));


        menu_li.forEach(e -> {
            try {
                click(e, driver);
            } catch (InterruptedException e1) {
                e1.printStackTrace();
            }
        });
    }

    private static void click(WebElement e, WebDriver driver) throws InterruptedException {
        Wait<WebDriver> wait = new WebDriverWait(driver, 5).withMessage("Element was not found");
        wait.until(ExpectedConditions.elementToBeClickable(e));

        e.click();
        String title = driver.findElement(className("page-title")).getText();
        System.out.println(title);
        driver.navigate().refresh();
        Thread.sleep(2000);
        String title2 = driver.findElement(className("page-title")).getText();
        System.out.println(title);

        Thread.sleep(2000);
        driver.findElement(xpath("//nav/ul/li")).click();

    }



    public static WebDriver getDriver() {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "//src/main/resources/chromedriver.exe");
        ChromeDriver chromeDriver = new ChromeDriver();
        chromeDriver.manage().window().maximize();
        return chromeDriver;
    }
}
