package mystore;

import org.openqa.selenium.By;

import static mystore.TestBase.wd;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AccountPage extends PageBase {
    private By signIn = By.linkText("Sign in");
    private By email = By.id("email");
    private By password = By.id("passwd");
    private By submitLogin = By.id("SubmitLogin");
    private By signOut = By.linkText("Sign out");


    protected void fillPasswordForm(String password) {
        wd.findElement(By.id("passwd")).click();
        wd.findElement(By.id("passwd")).clear();
        wd.findElement(By.id("passwd")).sendKeys(password);
    }

    protected void fillEmailForm(String email) {
        wd.findElement(By.id("email")).click();
        wd.findElement(By.id("email")).clear();
        wd.findElement(By.id("email")).sendKeys(email);
    }

    protected void openAccountPage() {
        wd.get("http://automationpractice.com/index.php");
        wd.findElement(By.linkText("Sign in")).click();
    }

    protected void checkPasswordFormFilledWithValue(String password) {
        String emailElementText = wd.findElement(By.id("passwd")).getAttribute("value");
        assertEquals(password, emailElementText, "Отображается некорректный пароль");
    }

    protected void checkEmailFormFilledWithValue(String email) {
        String emailElementText = wd.findElement(By.id("email")).getAttribute("value");
        assertEquals(email, emailElementText, "Отображается  некорректный email");
    }

}
