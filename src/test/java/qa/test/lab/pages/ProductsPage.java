package qa.test.lab.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductsPage {
    private EventFiringWebDriver driver;
    private WebDriverWait wait;

    public ProductsPage(EventFiringWebDriver driver, WebDriverWait wait){
        this.driver = driver;
        this.wait = wait;
    }
    private By addProductButton = By.cssSelector("a[id='page-header-desc-configuration-add']");

    //Add productPage
    private  By productNameInput = By.id("form_step1_name_1");
    private By quantityOfProduct = By.id("form_step1_qty_0_shortcut");
    private By priceInput = By.id("form_step1_price_shortcut");
    private By activateSwitch = By.cssSelector(".switch-input.-checked");
    private By succesActivationMessage = By.cssSelector(".growl.growl-notice.growl-medium");


    public void addNewProduct(String name, String quantity, String price){
        wait.until(ExpectedConditions.elementToBeClickable(addProductButton));
        driver.findElement(addProductButton).click();
        wait.until(ExpectedConditions.elementToBeClickable(productNameInput));
        driver.findElement(productNameInput).sendKeys(name);
        driver.findElement(quantityOfProduct).clear();
        driver.findElement(quantityOfProduct).sendKeys(quantity);
        driver.findElement(priceInput).clear();
        driver.findElement(priceInput).sendKeys(quantity);
        driver.findElement(activateSwitch).click();

    }
}
