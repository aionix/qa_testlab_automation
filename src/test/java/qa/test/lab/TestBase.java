package qa.test.lab;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import qa.test.lab.pages.CategoriesPage;
import qa.test.lab.pages.LoginPage;
import qa.test.lab.pages.MainPage;

public abstract class TestBase {
    private EventFiringWebDriver wd;
    private WebDriverWait wait;
    protected LoginPage loginPage;
    protected MainPage mainPage;
    protected CategoriesPage categoriesPage;

     EventFiringWebDriver initDriver(String driver) {
        if (driver.equals("chrome")) {
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/drivers/chromedriver.exe");
            System.out.println("root path is: " + System.getProperty("user.dir"));
            wd =  new EventFiringWebDriver(new ChromeDriver()).register(new EventHandler());
        }else if (driver.equals("IE")){
            System.setProperty("webdriver.ie.driver", System.getProperty("user.dir") + "/drivers/IEDriverServer.exe");
            wd = new EventFiringWebDriver(new InternetExplorerDriver()).register(new EventHandler());
        }
        return null;
    }

    @BeforeClass
    public void starterPage() {
         initDriver("chrome");
         wait = new WebDriverWait(wd, 15);
         loginPage = new LoginPage(wd, wait);
         mainPage = new MainPage(wd, wait);
         categoriesPage = new CategoriesPage(wd, wait);
         wd.manage().window().maximize();
         wd.get("http://prestashop-automation.qatestlab.com.ua/admin147ajyvk0/");
    }

    @AfterClass(alwaysRun = true)
    public void closeDriver(){
        this.wd.quit();
    }
}
//loginPage = PageFactory.initElements(driver, BasePage.class);