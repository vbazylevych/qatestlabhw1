import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.openqa.selenium.By.*;

public class ScriptA {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = getDriver();
        driver.get("http://prestashop-automation.qatestlab.com.ua/admin147ajyvk0/");
        WebElement email = driver.findElement(id("email"));
        email.sendKeys("webinar.test@gmail.com");

        WebElement password = driver.findElement(id("passwd"));
        password.sendKeys("Xcg7299bnSmMuRLp9ITw");

        WebElement submitLogin = driver.findElement(name("submitLogin"));
        submitLogin.click();

        Thread.sleep(300);

        WebElement avatar = driver.findElement(className("employee_avatar_small"));
        avatar.click();

        WebElement logout = driver.findElement(id("header_logout"));
        logout.click();

        driver.close();
    }


    public static WebDriver getDriver() {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "//src/main/resources/chromedriver.exe");
        ChromeDriver chromeDriver = new ChromeDriver();
        chromeDriver.manage().window().maximize();
        return chromeDriver;
    }
}
