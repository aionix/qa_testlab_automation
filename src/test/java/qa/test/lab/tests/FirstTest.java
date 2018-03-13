package qa.test.lab.tests;
import org.testng.Assert;
import org.testng.annotations.Test;
import qa.test.lab.TestBase;
import static qa.test.lab.helpers.NumbersGenerator.*;

public class FirstTest extends TestBase {

    @Test
    void loginAndLogoutTest(){
        loginPage.login();
        mainPage.logout();
}


}
