package qa.test.lab.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CategoriesPage {
    private EventFiringWebDriver driver;
    private WebDriverWait wait;

    public CategoriesPage(EventFiringWebDriver driver, WebDriverWait wait){
        this.driver = driver;
        this.wait = wait;
    }

    public By addCategoryButton = By.id("page-header-desc-category-new_category");
    public By categoryNameInput = By.id("name_1");
    public By successTitleCategoryCreation = By.xpath("//div[@class='alert alert-success']");
    public By categoryFormSubmitButton = By.id("category_form_submit_btn");

    public void addCategory(String name) {
        driver.findElement(addCategoryButton).click();
        wait.until(ExpectedConditions.elementToBeClickable(categoryNameInput));
        driver.findElement(categoryNameInput).clear();
        driver.findElement(categoryNameInput).sendKeys(name);
        driver.findElement(categoryFormSubmitButton).click();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(successTitleCategoryCreation)));
    }

    public void findCategoryByName(String name) {
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[name='categoryFilter_name']")));
        driver.findElement(By.name("categoryFilter_name")).clear();
        driver.findElement(By.name("categoryFilter_name")).sendKeys(name);
        driver.findElement(By.id("submitFilterButtoncategory")).click();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@class='panel-heading']"))));

        driver.findElement(By.xpath("//tr/td[@class='pointer'][contains(text(),'" + name + "')]"));
    }
}
