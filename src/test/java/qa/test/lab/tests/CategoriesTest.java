package qa.test.lab.tests;

import org.testng.annotations.Test;
import qa.test.lab.TestBase;

import static qa.test.lab.helpers.NumbersGenerator.getCurrentTime;

public class CategoriesTest extends TestBase {

    @Test
    void addingNewCategory(){
        loginPage.login();
        mainPage.hoverToLeftSideMenu("Каталог");
        mainPage.selectSubMenuFromLeftSideMenu("категории");

        String categoryToCreate = "test_cat " + getCurrentTime();
        categoriesPage.addCategory(categoryToCreate);
        categoriesPage.findCategoryByName(categoryToCreate);
    }
}
