package mystore;

import com.google.gson.Gson;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.FileWriter;

import static mystore.TestBase.wd;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HeaderOfTheTestedSite extends PageBase {
    private By signInBy = By.linkText("Sign in");
    private By emailBy = By.id("email");
    private By passwordBy = By.id("passwd");
    private By submitLogin = By.id("SubmitLogin");
    private By signOut = By.linkText("Sign out");


    public void signIn() {
        wd.get("http://automationpractice.com/index.php");
        wd.findElement(By.linkText("Sign in")).click();
        wd.findElement(By.id("email")).click();
        wd.findElement(By.id("email")).clear();
        wd.findElement(By.id("email")).sendKeys("al-tysevi4@yandex.ru");
        wd.findElement(By.id("passwd")).click();
        wd.findElement(By.id("passwd")).clear();
        wd.findElement(By.id("passwd")).sendKeys("aLpine");
        wd.findElement(By.id("SubmitLogin")).click();
    }
    protected void signOut() {
        wd.findElement(By.linkText("Sign out")).click();
    }

    protected HeaderOfTheTestedSite submit() {
        wd.findElement(By.id("SubmitLogin")).click();
        return this;
    }
}
