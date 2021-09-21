package mystore;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static mystore.TestBase.wd;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HomePage {
    //private By dresseButton = By.xpath("//div[text()='Categories']/following-sibling::ul/li/a[text()='Dresses']");

    //@FindBy(xpath = "//div[text()='Categories']/following-sibling::ul/li/a[text()='Dresses']")
    //private WebElement dressButton;
    private By dressButton = By.xpath("//div[text()='Categories']/following-sibling::ul/li/a[text()='Dresses']");

    private By homePageLogoButton = By.xpath("//*[@title='Home']");

    HomePage() {
        PageFactory.initElements(wd, this);
    }

    protected void hoverOverDresses() throws InterruptedException {
        Thread.sleep(3000);
        Actions actions = new Actions(wd);
        WebElement element = wd.findElement(dressButton);
        actions.moveToElement(element).build().perform();
    }
    protected void goToHomePage() {
        wd.findElement(homePageLogoButton).click();
    }

    protected void checkHomePageTitleIs(String s) {
        String homePageTitle = wd.getTitle();
        assertEquals(s, homePageTitle, "Открывается некорректная страница");
    }


}
