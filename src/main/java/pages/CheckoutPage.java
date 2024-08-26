package pages;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;
import  Pojos.FormData;

public class CheckoutPage extends Pages{

    private final By form = By.xpath("//div[@class=\"checkout_info\"]");
    private final By firstName = By.id("first-name");
    private final By lastName = By.id("last-name");
    private final By postalCode = By.id("postal-code");
    private final By continueBtn = By.id("continue");
    private final By errorMessage = By.className("error-message-container error");

    public CheckoutPage(SHAFT.GUI.WebDriver driver) {

        super(driver);
    }
    // Method to verify if we are on the checkout page
    public boolean isCheckoutPage() {
        String currentUrl = driver.getDriver().getCurrentUrl();
        return currentUrl.equals("https://www.saucedemo.com/checkout-step-one.html");
    }

    // Method to verify if the form is disabled
    public boolean disabledForm() {
        driver.element().isElementDisplayed(form);
        return true;

    }
   public CheckoutPage clickContinueBtn(){
        driver.element().click(continueBtn);
        return this;
   }
    public String getErrorMessage() {
        return driver.element().getText(errorMessage);
    }
    // Method to verify if the input fields can send keys
    public FormData sendInformation(){
        driver.element().type(firstName ,"john");
        driver.element().type(lastName ,"Doe");
        driver.element().type(postalCode ,"123456");
        return new FormData(driver.element().getAttribute(firstName,"value"),
                driver.element().getAttribute(lastName,"value"),
                driver.element().getAttribute(postalCode,"value"));
    }
}
