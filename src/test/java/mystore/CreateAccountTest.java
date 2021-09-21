package mystore;

import org.junit.jupiter.api.*;

public class CreateAccountTest extends TestBase {
  HeaderOfTheTestedSite headerOfTheTestedSite = new HeaderOfTheTestedSite();
  AccountPage accountPage = new AccountPage();


  @Test
  public void testCreateAccount() {
    accountPage.openAccountPage();
    accountPage.fillEmailForm("al-tysevi4@yandex.ru");
    accountPage.checkEmailFormFilledWithValue("al-tysevi4@yandex.ru");
    accountPage.fillPasswordForm("aLpine");
    accountPage.checkPasswordFormFilledWithValue("aLpine");
    headerOfTheTestedSite.submit();
    headerOfTheTestedSite.signOut();
  }
}

