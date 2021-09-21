package mystore;

import org.openqa.selenium.By;

import static mystore.TestBase.wd;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PopUpPage {
    private By addToCartButton = By.xpath("//*[@class='exclusive']");
    private By addOneMoreItem = By.xpath("//*[@class='icon-plus']");



    protected void addToCart() {
        wd.findElement(By.xpath("//*[@class='exclusive']")).click();
    }

    protected void addOneMoreItem() {
        wd.findElement(By.xpath("//*[@class='icon-plus']")).click();
    }

    protected void checkQuantityValueIs(String layer_cart_product_quantity, String s, String s2) {
        String quantityCheckValue = wd.findElement(By.id(layer_cart_product_quantity)).getText();
        assertEquals(s, quantityCheckValue, s2);
    }

    protected void checkChosenItemNameIs(String layer_cart_product_title, String s, String s2) {
        String titleDressValue = wd.findElement(By.id(layer_cart_product_title)).getText();
        assertEquals(s, titleDressValue, s2);
    }

    protected void checkPriceTotalValue(String layer_cart_product_price, String s, String s2) throws InterruptedException {
        String totalCheckValue = wd.findElement(By.id(layer_cart_product_price)).getText();
        Thread.sleep(3000);
        assertEquals(s, totalCheckValue, s2);
    }

    protected void checkPriceItemValue(String our_price_display, String s, String s2) {
        String priceCheckValue = wd.findElement(By.id(our_price_display)).getText();
        assertEquals(s, priceCheckValue, s2);
    }

    protected void checkNeededPageNameIs(By xpath, String s, String s2) {
        String neededPageName = wd.findElement(xpath).getText();
        assertEquals(s, neededPageName, s2);
    }
}
