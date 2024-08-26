package UI;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CheckoutPage;
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

    @Test
    //TC08 ,TC09,TC10,TC11 it was working before ,but I think there was some broken in the website
    public void TC08(){
        CheckoutPage checkout = new Login(driver).validLogin().goToCart().goToCheckout();
        Assert.assertTrue(checkout.isCheckoutPage());
    }


}
