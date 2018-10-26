import org.openqa.selenium.WebDriver;

public class Test {

    static WebDriver driver;
    LoginPage loginPage;

    @BeforeMethod

    public void beforeMethod() {

        driver = new FirefoxDriver();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("http://www.store.demoqa.com");

        HomePage = PageFactory.initElements(driver, Home_PG_POF.class);

        LoginPage = PageFactory.initElements(driver, LogIn_PG_POF.class);

    }
}
