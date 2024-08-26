package UI;

import Pojos.FormData;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Login;
import utilites.Tests;

public class CheckoutPageTest extends Tests {
    @Test
    public void TC09(){
    // The test checks whether the form is disabled as expected
  boolean isFormDisabled = new Login(driver).validLogin().goToCart().goToCheckout().disabledForm();
  Assert.assertTrue(isFormDisabled);

    }



    @Test
    public void TC10(){
        String expectedErrorMessage = "Error: First Name is required";
        String actualErrorMessage =
                new Login(driver).
                        validLogin().
                        goToCart().
                        goToCheckout().
                        clickContinueBtn().getErrorMessage();
        Assert.assertEquals(expectedErrorMessage,actualErrorMessage);

    }

    @Test
    // Test to verify that the user information sent during checkout matches the information retrieved.
    public void TC11(){
        FormData formData =  new Login(driver).validLogin().goToCart().goToCheckout().sendInformation();
        Assert.assertEquals(formData.getFirstName(), "john");
        Assert.assertEquals(formData.getLastName(), "Doe");
        Assert.assertEquals(formData.getPostalCode(), "123456");

    }
}
