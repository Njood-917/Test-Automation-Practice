package pages;

import com.shaft.driver.SHAFT;

public abstract class Pages {
    final SHAFT.GUI.WebDriver driver;

    public Pages(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }


}
