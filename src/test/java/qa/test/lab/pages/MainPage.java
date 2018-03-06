package qa.test.lab.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage {
    private WebDriver driver;
    private WebDriverWait wait;

    public MainPage(WebDriver driver, WebDriverWait wait){
        this.driver = driver;
        this.wait = wait;
    }

    private By icon_img = By.className("employee_avatar_small");
    private By logout_button = By.id("header_logout");
    private By emailField = By.id("email");

    public void logout(){
        driver.findElement(icon_img).click();
        driver.findElement(logout_button).click();
        wait.until(ExpectedConditions.elementToBeClickable(emailField));

    }

}
