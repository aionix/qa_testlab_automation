package qa.test.lab.tests;
import org.testng.annotations.Test;
import qa.test.lab.TestBase;
import qa.test.lab.helpers.NumbersGenerator;

import static qa.test.lab.helpers.NumbersGenerator.*;

public class ProductsTest extends TestBase {

    @Test
    void addNewProduct(){
        loginPage.login();
        mainPage.hoverToLeftSideMenu("Каталог");
        mainPage.selectSubMenuFromLeftSideMenu("товары");
        productsPage.addNewProduct("TestProduct "+ getCurrentTime(), randomNumber1To100(), randomNumber1To100());
    }

}
