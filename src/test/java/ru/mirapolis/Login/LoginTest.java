package ru.mirapolis.Login;

import org.junit.Test;

public class LoginTest extends WebDriverSettings{
    @Test(expected = Throwable.class)
    public void wrongLoginTest() throws InterruptedException {
        loginPage.fillLoginAndPassword("rwerwer", "jkjhljhl");
        loginPage.verifyAuthorization();
    }

    @Test
    public void successfulLoginTest() {
        loginPage.fillLoginAndPassword("fominaelena", "1P73BP4Z");
        loginPage.verifyAuthorization();
    }
}
