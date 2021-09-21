package mystore;

import org.openqa.selenium.By;

import static mystore.TestBase.wd;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SummaryPage {
    private By proceedToCheckoutButton = By.xpath("//*[text()='Proceed to checkout']");
    private By summaryPageButton = By.xpath("//span[@title='Continue shopping']/following-sibling::a/span");

    protected void ProceedToCheckout() {
        wd.findElement(proceedToCheckoutButton).click();
    }

    protected void openSummaryPage() {
        wd.findElement(summaryPageButton).click();
    }

    protected void checkSummaryPageTotalPrice(String total_product_price_3_13_550068, String s, String s2) {
        String summaryPageTotalPrice = wd.findElement(By.id(total_product_price_3_13_550068)).getText();
        assertEquals(s, summaryPageTotalPrice, s2);
    }

    protected void checkSummaryPageDressData(String product_3_13_0_550068, String s, String s2) {
        String summaryPageDressTitle = wd.findElement(By.id(product_3_13_0_550068)).getText();
        assertEquals(s, summaryPageDressTitle, s2);
    }

    protected void checkSummaryPageTitleIs(String cart_title, String s, String s2) {
        String summaryPageTitle = wd.findElement(By.id(cart_title)).getText();
        assertEquals(s, summaryPageTitle, s2);
    }

}
