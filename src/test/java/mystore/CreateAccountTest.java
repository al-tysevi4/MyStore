package mystore;

import com.google.gson.Gson;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class CreateAccountTest extends TestBase {
  HeaderOfTheTestedSite headerOfTheTestedSite = new HeaderOfTheTestedSite();
  AccountPage accountPage = new AccountPage();


  @ParameterizedTest
  @CsvSource ({"al-tysevi4@yandex.ru, aLpine",
              "13@mail.ru, алпине"})
  public void testCreateAccount(String login, String password) {
    accountPage.openAccountPage()
               .fillEmailForm(login)
               .checkEmailFormFilledWithValue(login)
               .fillPasswordForm(password)
               .checkPasswordFormFilledWithValue(password);
    headerOfTheTestedSite.submit()
                         .signOut();
  }
}

