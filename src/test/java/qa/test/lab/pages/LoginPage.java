package qa.test.lab.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static java.lang.Thread.sleep;

public class LoginPage {
    private WebDriver driver;
    private WebDriverWait wait;

    public LoginPage(WebDriver driver, WebDriverWait wait){
        this.driver = driver;
        this.wait = wait;
    }

    private By loginField = By.id("email");
    private By passField = By.id("passwd");
    private By enterButton = By.name("submitLogin");
    private By headerLogo = By.id("header_logo");

    public void login() {
        driver.findElement(loginField).sendKeys("webinar.test@gmail.com");
        driver.findElement(passField).sendKeys("Xcg7299bnSmMuRLp9ITw");
        driver.findElement(enterButton).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(headerLogo));

    }




}
