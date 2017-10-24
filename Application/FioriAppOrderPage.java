package fiori.example.scenario.run2.Application;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class FioriAppOrderPage {

    public WebDriverWait wait;
    private WebDriver driver;
//объявление "ожидалки" и драйвера

    public FioriAppOrderPage()  {
        driver = new ChromeDriver();//запуск новой сущности Хром драйвера в классе
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, 15);
        driver.manage().window().maximize();

    }

    public void quit() {driver.quit();}

        public void fioriOrderListExecute() {
        driver.navigate().to("https://sapui5.hana.ondemand.com/test-resources/sap/m/demokit/orderbrowser/webapp/test/mockServer.html#/Orders/6858/?tab=shipping");
        driver.findElement(By.xpath("//input[@id='__component0---master--searchField-I']")).sendKeys("Tortuga Restaurante");
        driver.findElement(By.xpath("//div[@id='__component0---master--searchField-search']")).click();
        List<WebElement> orderList = driver.findElements(By.cssSelector("ul[role=listbox] li[role=option]"));
        String currentOrder = driver.findElement(By.xpath("//span[contains(@id,'component0---detail--objectHeader-titleText-inner')]")).getAttribute("textContent");
        orderList.get(0).click();
        wait.until(ExpectedConditions.not(ExpectedConditions.textToBe(By.xpath("//span[contains(@id,'component0---detail--objectHeader-titleText-inner')]"),currentOrder)));
        driver.findElement(By.xpath("//div[@title='Group']")).click();
        driver.findElement(By.xpath("//li[contains(.,'Group by Shipped Period')]")).click();}
        //обработка мастер-списка заказов (поиск определённых заказов в списке, сортировка списка)

    public void fioriOrderDetailExecute() {

        String orderNum = driver.findElement(By.xpath("//span[contains(@id,'component0---detail--objectHeader-titleText-inner')]")).getAttribute("textContent");
        Assert.assertEquals(orderNum, "Order 7918");

        List<WebElement> tabList = driver.findElements(By.cssSelector("div[role=tab]"));
        tabList.get(1).click();
        WebElement formHeader = driver.findElement(By.id("__xmlview1--SimpleFormProcessorInfo--Form--title"));
        wait.until(ExpectedConditions.visibilityOf(formHeader));
        tabList = driver.findElements(By.cssSelector("div[role=tab]"));
        tabList.get(1).click();
        wait.until(ExpectedConditions.not(ExpectedConditions.visibilityOf(formHeader)));
        //обработка деталей заказа (проверка, что открылся нужный заказ, проверка работы кнопки Processor information)

              }
    }