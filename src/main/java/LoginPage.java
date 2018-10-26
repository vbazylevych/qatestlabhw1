import lombok.Data;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

@Data
public class LoginPage {
    final WebDriver driver;

    @FindBy(id = "email")
    private WebElement email;

    @FindBy(id = "passwd")
    private WebElement passwd;

    @FindBy(name = "submitLogin")
    private WebElement submitLogin;

    public void login(String userEmail, String userPassword) {
        email.sendKeys(userEmail);
        passwd.sendKeys(userPassword);
        submitLogin.click();
    }
}

