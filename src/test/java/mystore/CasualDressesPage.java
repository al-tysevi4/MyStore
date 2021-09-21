package mystore;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import static mystore.TestBase.wd;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CasualDressesPage {
    private By moreButton = By.xpath("//*[contains(text(), 'More')]");
    private By pictureHover =  By.xpath("//li/div/div/div/a/img");
    private By priceSlider = By.xpath("//div[@id='layered_price_slider']/a");
    private By checkInStock = By.xpath("//*[@value='1']");
    private By checkSSize =  By.xpath("//*[@value='1_1']");
    private By checkMSize = By.xpath("//*[@value='2_1']");
    private By checkCotton = By.xpath("//*[@value='5_5']");
    private By casualDressesButton = By.xpath("//div[text()='Categories']/following-sibling::ul/li/ul/li/a[text()='Casual Dresses']");


    protected void clickMoreButton() {
        wd.findElement(moreButton).click();
    }

    protected void hoverOverChosenPicture() throws InterruptedException {
        Thread.sleep(10000);
        Actions actions = new Actions(wd);
        WebElement elem = wd.findElement(pictureHover);
        actions.moveToElement(elem).build().perform();
    }

    protected void setPriceBySlider() {
        WebElement slider = wd.findElement(priceSlider);
        Actions move = new Actions(wd);
        Action action = move.dragAndDropBy(slider, 122, 0).build();
        action.perform();
    }

    protected void checkInStock() {
        wd.findElement(checkInStock).click();
    }

    protected void checkCotton() {
        wd.findElement(checkCotton).click();
    }

    protected void checkSizeM() {
        wd.findElement(checkMSize).click();
    }

    protected void checkSizeS() {
        wd.findElement(checkSSize).click();
    }

    protected void openCasualDressesPage() {
        wd.findElement(casualDressesButton)
                .click();
    }
    protected void checkCasualDressesPageTitleIs(String s) {
        String casualDressesPageTitle = wd.getTitle();
        assertEquals(s, casualDressesPageTitle, "Открывается некорректная страница");
    }
}
