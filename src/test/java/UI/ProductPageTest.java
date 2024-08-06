package UI;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.Cart;
import pages.Login;
import pages.Products;
import utilites.Tests;


public class ProductPageTest extends Tests {

    @Test
    public void TC03(){
        // display the products after login
        int numberOfProduct = new Login(driver).validLogin().listOfItems();
        Assert.assertEquals(numberOfProduct , 6);
    }
    @Test
    public void TC04(){
        new Login(driver).validLogin();
        Products products = new Products(driver);

        // Verify the display of the first product
        boolean areFirstElementDisplayed = products.displayProduct(1);
        boolean areSecondElementDisplayed = products.displayProduct(2);
        boolean areThirdElementDisplayed =products.displayProduct(3);

        // Use SoftAssert to collect all assertions
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(areFirstElementDisplayed, "First product elements are not displayed.");
        softAssert.assertTrue(areSecondElementDisplayed, "Second product elements are not displayed.");
        softAssert.assertTrue(areThirdElementDisplayed, "Third product elements are not displayed.");

        // Assert all to report any failures
        softAssert.assertAll();
    }
    @Test
    public void TC05(){
        // verify after click on addToCart the button change to Remove and the same product appear on Cart page
      new Login(driver).validLogin();
       Products productPage = new Products(driver);
        Cart cartPage = new Cart(driver);
        // Get the product name before adding to the cart
        String productNameBeforeAdd = productPage.getProductName();
        // Add product to the cart and verify button change
        productPage.addToCartAndVerifyButtonChange();
        // Go to the cart
        productPage.goToCart();
        // Verify that the product is in the cart
        Assert.assertTrue(cartPage.isProductInCart(productNameBeforeAdd),"Product should be present in the cart");


    }
    @Test
    public void TC06(){
        // Verify the number of options in the select menu
       int listOfSelectMenu =  new Login(driver).validLogin().listOfSelectMenu();
       Assert.assertEquals(listOfSelectMenu , 4);
    }

    @Test
    //Verify that the products are sorted correctly based on the selected sort order
    public void TC07(){
      boolean ProductPrices =   new Login(driver).validLogin().priceComparative();
      Assert.assertTrue(ProductPrices);

    }
    @Test
    //Verify Alphabetical Sorting Order of Items
    public void TC08(){
        boolean isCorrectlySorted = new Login(driver).validLogin().isSortedCorrectly();
        Assert.assertTrue(isCorrectlySorted,"Items are not sorted correctly from Z to A.");
    }


}

