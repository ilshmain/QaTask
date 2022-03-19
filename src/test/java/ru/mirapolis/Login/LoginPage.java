package ru.mirapolis.Login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    private WebDriver driver;
    private WebDriverWait wait;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @FindBy(id = "button_submit_login_form")
    private WebElement comeButton;

    @FindBy(name = "user")
    private WebElement userLogin;

    @FindBy(name = "password")
    private WebElement userPassword;

    private By homeForm = By.cssSelector("[class=\"mira-widget-body widgetBody header-is-shown\"]");
    private By loginForm = By.cssSelector("[name=\"entity\"]");

    public void open() {
        driver.get("https://lmslite47vr.demo.mirapolis.ru/mira/"+
                "Do?doaction=Go&s=N4PXVVBG49rzYfytuTLv&id=0&type=customloginpage");
    }

    public void fillLoginAndPassword(String login, String password) {
        userLogin.sendKeys(login);
        userPassword.sendKeys(password);
    }

    public void waitLoginForm() {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(loginForm));
    }

    public void verifyAuthorization() {
        comeButton.click();
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(homeForm));
    }
}
