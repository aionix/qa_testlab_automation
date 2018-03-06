package qa.test.lab;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import qa.test.lab.pages.LoginPage;

public abstract class TestBase {
    public WebDriver wd;
    public WebDriverWait wait;
    protected LoginPage loginPage;

     WebDriver initDriver(String driver) {
        if (driver.equals("chrome")) {
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/drivers/chromedriver.exe");
            System.out.println("root path is: " + System.getProperty("user.dir"));
            wd =  new ChromeDriver();
        }else if (driver.equals("IE")){
            System.setProperty("webdriver.ie.driver", System.getProperty("user.dir") + "/drivers/IEDriverServer.exe");
            wd = new InternetExplorerDriver();
        }
        return null;
    }

    @BeforeClass
    public void starterPage() {
         initDriver("chrome");
         wait = new WebDriverWait(wd, 15);
         loginPage = new LoginPage(wd, wait);
         wd.manage().window().maximize();
         wd.get("http://prestashop-automation.qatestlab.com.ua/admin147ajyvk0/");
    }

    @AfterClass(alwaysRun = true)
    public void closeDriver(){
        this.wd.quit();
    }
}
//loginPage = PageFactory.initElements(driver, BasePage.class);