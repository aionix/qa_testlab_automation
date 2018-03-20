package qa.test.lab.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage {
    private EventFiringWebDriver driver;
    private WebDriverWait wait;

    public MainPage(EventFiringWebDriver driver, WebDriverWait wait){
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

    public void hoverToLeftSideMenu(String menuName){
        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(By.xpath("//a[@class='title has_submenu']/span[contains(text(), '"+menuName+"')]"))).build().perform();
    }
    public void selectSubMenuFromLeftSideMenu(String subCategory){
        CategoriesPage categoriesPage = new CategoriesPage(driver, wait);
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//ul[@class='submenu']/li/a[contains(text(), '"+subCategory+"')]"))));
        driver.findElement(By.xpath("//ul[@class='submenu']/li/a[contains(text(), '"+subCategory+"')]")).click();
        //wait.until(ExpectedConditions.elementToBeClickable(categoriesPage.addCategoryButton));
    }



}
