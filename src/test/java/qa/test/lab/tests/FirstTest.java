package qa.test.lab.tests;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import qa.test.lab.TestBase;
import qa.test.lab.pages.LoginPage;

public class FirstTest extends TestBase {

    @Test
    void loginAndLogoutTest(){
        loginPage.login();
        mainPage.logout();


}
}
