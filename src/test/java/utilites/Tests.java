package utilites;

import com.shaft.driver.SHAFT;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class Tests {

    public SHAFT.GUI.WebDriver driver ;
     @BeforeMethod
    public void beforeMethod(){
         driver = new SHAFT.GUI.WebDriver();
         driver.browser().navigateToURL("https://www.saucedemo.com/");


     }
     @AfterMethod
    public void afterMethod(){
         driver.quit();
     }
}
