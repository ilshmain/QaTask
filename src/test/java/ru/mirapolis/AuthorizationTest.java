package ru.mirapolis;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertTrue;

public class AuthorizationTest {
    private static WebDriver driver;

    @BeforeClass
    public static void setUp() {
        driver = new ChromeDriver();
    }

    @Test
    public void test() {
        driver.get("https://lmslite47vr.demo.mirapolis.ru/mira/"+
                "Do?doaction=Go&s=N4PXVVBG49rzYfytuTLv&id=0&type=customloginpage");
        driver.findElement(By.name("user")).sendKeys("asdsad");
        driver.findElement(By.name("password")).sendKeys("ghjhjkjk");
        driver.findElement(By.id("button_submit_login_form")).click();
        try {
            WebDriverWait wait = new WebDriverWait(driver, 10);
            wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("[class=\"mira-widget-body widgetBody header-is-shown\"]")));
        } catch (Exception e) {
            assertTrue(e.getMessage().contains("Неверные данные для авторизации"));
        }
    }

    @Test
    public void authorization() {
        driver.get("https://lmslite47vr.demo.mirapolis.ru/mira/"+
                "Do?doaction=Go&s=N4PXVVBG49rzYfytuTLv&id=0&type=customloginpage");
        String title = driver.getTitle();
        System.out.println(title);
        Assert.assertEquals("Авторизация", title);
        driver.findElement(By.name("user")).sendKeys("fominaelena");
        driver.findElement(By.name("password")).sendKeys("1P73BP4Z");
        driver.findElement(By.id("button_submit_login_form")).click();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("[class=\"mira-widget-body widgetBody header-is-shown\"]")));
    }

    @AfterClass
    public static void afterClose() {
        driver.quit();
    }
}
