package ru.mirapolis.Login;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

public class WebDriverSettings {
    public WebDriver driver;
    public LoginPage loginPage;

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        loginPage = PageFactory.initElements(driver, LoginPage.class);
        loginPage.open();
        loginPage.waitLoginForm();
    }

    @After
    public  void close() {
        driver.quit();
    }
}
