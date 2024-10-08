package pages;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;

public class Cart extends Pages{
    private final By cartItemName = By.className("inventory_item_name");
    private final By continueBtn = By.id("continue-shopping");
    private final By checkoutBtn = By.xpath("//button [contains(@class,'checkout_button')]");

    public Cart(SHAFT.GUI.WebDriver driver) {

        super(driver);
    }
    public String getCartItemName(){

        return driver.element().getText(cartItemName);
    }
    public boolean isProductInCart(String productName) {
        driver.element().waitToBeReady(cartItemName);
        String cartItem = driver.element().getText(cartItemName);
        return productName.equals(cartItem);
    }
    public boolean areButtonsClickable (){
        driver.element().isElementClickable(continueBtn);
        driver.element().isElementClickable(checkoutBtn);
        return true;

    }
    // Method to click the "Continue Shopping" button and return a ProductPage instance
    public Products continueShopping(){
        driver.element().click(continueBtn);
        return new Products(driver);

    }
    public CheckoutPage goToCheckout() {
        System.out.println( "hello");
        driver.element().isElementDisplayed(checkoutBtn);
        driver.getDriver().findElement(checkoutBtn).click();
        System.out.println( "hi");
        return new CheckoutPage(driver); // Returning a Checkout page object
    }

}
