package mystore;

import com.google.gson.Gson;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.TimeUnit;


public class TestBase {
    static WebDriver wd;



    @BeforeEach
    public void setUp() {
        init();
    }

    @AfterEach
    public void tearDown() {
        stop();
    }

    protected void init() {
        System.setProperty("webdriver.chrome.driver", "chromedriver");
        wd = new ChromeDriver();

        wd.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        wd.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        maximizeWindow();
    }

    protected void stop() {
        wd.quit();
    }

    protected void maximizeWindow() {
        wd.manage().window().maximize();
    }

    private void toJson() throws IOException {
        Gson gson = new Gson();
        gson.toJson("al-tysevi4@yandex.ru, aLpine", new FileWriter("src/test/java/mystore/resources/testData.json"));
    }
}
