package UI;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Login;
import pages.Products;
import utilites.Tests;

public class CartPageTest extends Tests {

    @Test

    public void TC06(){
       boolean areButtonsClickable =  new Login(driver).validLogin().goToCart().areButtonsClickable();
        Assert.assertTrue(areButtonsClickable);
    }
    @Test
    public void TC07(){
        Products products = new Login(driver).validLogin().goToCart().continueShopping();
        Assert.assertTrue(products.isAtProductPage());
    }
}
