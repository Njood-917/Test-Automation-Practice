package pages;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;

public class Login extends Pages {

    // login locators

    private final By userNameLocator = By.id("user-name");
    private final By passwordLocator = By.id("password");
    private final By loginBtn = By.id("login-button");
    private final By errorMessageLocator = By.cssSelector("h3");
    String ValidUser = "standard_user";
    String Password = "secret_sauce";
    String invalidUser = "abc";


    public Login(SHAFT.GUI.WebDriver driver) {
        super(driver);
    }

    // Login functionality
    public Login login(String userName, String password) {
        driver.element().type(userNameLocator, userName);
        driver.element().type(passwordLocator, password);
        driver.element().click(loginBtn);
        return this;
    }

    public Products validLogin(){
        login(ValidUser , Password);
        return new Products(driver);
    }
    public String invalidLogin(){
        login(invalidUser , Password);
        return driver.element().getText(errorMessageLocator);
    }

//    // Method to get the error message text
//        public String getErrorMessage () {
//
//        }
    }



