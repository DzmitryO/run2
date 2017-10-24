package fiori.example.scenario.run2.base;

import fiori.example.scenario.run2.Application.FioriAppOrderPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class TestBase {

    public FioriAppOrderPage app;
    public static ThreadLocal<FioriAppOrderPage> t1App = new ThreadLocal<>();

    @Before
    public void start() {
       System.setProperty("webdriver.chrome.driver","C:\\Program Files (x86)\\Google\\ChromeDriver\\chromedriver.exe");
       // driver = new ChromeDriver();
       // driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
       // driver.manage().window().maximize();
        // запуск исполняемого файла на машине
            if (t1App.get() != null) {
                app = t1App.get();
                return;
            }

            app = new FioriAppOrderPage();
            t1App.set(app);
                //создание новой сущности Фиори апликейшена
            Runtime.getRuntime().addShutdownHook(
                    new Thread(() -> { app.quit(); app = null;}));
    }


    //@After
    public void stop()  {
        //driver.quit();
        //driver = null;

    }
}
