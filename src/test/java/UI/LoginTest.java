package UI;

import org.testng.Assert;
import pages.Login;
import org.testng.annotations.Test;
import pages.Products;
import utilites.Tests;

public class LoginTest extends Tests {




@Test

public void TC01() {
    //display the title of product to ensure on the product page
  String actualText = new Login(driver).validLogin().readTitle();
    Assert.assertEquals(actualText, "Sauce Labs Backpack");
}
    @Test
    public void TC02(){
        String actualErrorMessage = new Login(driver).invalidLogin();
        Assert.assertEquals(actualErrorMessage,"Epic sadface: Username and password do not match any user in this service");

    }


}
