package mystore;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;



public class MakePurchaseTest extends TestBase {
    HeaderOfTheTestedSite headerOfTheTestedSite = new HeaderOfTheTestedSite();
    HomePage homePage = new HomePage();
    PageBase pageBase = new PageBase();
    CasualDressesPage casualDressesPage = new CasualDressesPage();
    PopUpPage popUpPage = new PopUpPage();
    SummaryPage summaryPage = new SummaryPage();

    @Test
    public void testMakePurchase() throws Exception {
        headerOfTheTestedSite.signIn();
        homePage.goToHomePage();
        homePage.checkHomePageTitleIs("My Store");
        maximizeWindow();
        Thread.sleep(3000);
        homePage.hoverOverDresses();
        Thread.sleep(3000);
        casualDressesPage.openCasualDressesPage();
        casualDressesPage.checkCasualDressesPageTitleIs("Casual Dresses - My Store");
        casualDressesPage.checkSizeS();
        casualDressesPage.checkSizeM();
        casualDressesPage.checkCotton();
        casualDressesPage.checkInStock();
        casualDressesPage.setPriceBySlider();
        casualDressesPage.hoverOverChosenPicture();
        Thread.sleep(3000);
        casualDressesPage.clickMoreButton();
        popUpPage.checkNeededPageNameIs(By.xpath("//*[@itemprop='name']"), "Printed Dress", "Некорректно отображается страница выбранного товара");
        popUpPage.checkPriceItemValue("our_price_display", "$26.00", "Отображается некорректная цена");
        popUpPage.addOneMoreItem();
        popUpPage.addToCart();
        Thread.sleep(10000);
        popUpPage.checkPriceTotalValue("layer_cart_product_price", "$52.00", "Некорректное отображение суммы заказа в корзине");
        popUpPage.checkChosenItemNameIs("layer_cart_product_title", "Printed Dress", "Некорректно отображается название выбранного товара");
        popUpPage.checkQuantityValueIs("layer_cart_product_quantity", "2", "Неккоректное отображение количества выбранного товара в корзине");
        Thread.sleep(3000);
        summaryPage.openSummaryPage();
        summaryPage.checkSummaryPageTitleIs("cart_title", "SHOPPING-CART SUMMARY\nYour shopping cart contains: 2 Products", "Некорректно отображается страница Summary");
        summaryPage.checkSummaryPageDressData("product_3_13_0_550068", "Printed Dress\nSKU : demo_3\n" +
                "Color : Orange, Size : S\n" +
                "In stock $26.00\n" +
                "$52.00", "Некорректно отображается выбранный товар");
        summaryPage.checkSummaryPageTotalPrice("total_product_price_3_13_550068", "$52.00", "Некорректно отображается сумма товаров");
        summaryPage.ProceedToCheckout();
    }
}
