package pages;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;

public class Products extends Pages {
    private final By titlePage = By.id("item_4_title_link");
    private final By numberOfList = By.className("inventory_item");
    private final By selectMenu = By.xpath("//select[@class='product_sort_container']");
    private final By selectMenuOptions = By.xpath("//select[@class='product_sort_container']/option");
    private final By highToLowOption = By.xpath("//option [@value='hilo']");
    private final By lowToHighOption = By.xpath("//option [@value='lohi']");
    private final By zToaOption = By.xpath("//option [@value='za']");
    private final By aTozOption = By.xpath("//option [@value='az']");
    private final By firstItemName = By.cssSelector(".inventory_item:nth-of-type(1) .inventory_item_name");
    private final By priceItem = By.xpath("(//div [@class='inventory_item_price'])[1]");
    private final By addToCartBtn = By.id("add-to-cart-sauce-labs-bike-light");
    private final By removeBtn = By.id("remove-sauce-labs-bike-light");
    private final By cartLink = By.className("shopping_cart_link");
    private final By productName = By.cssSelector(".inventory_item:nth-of-type(2) .inventory_item_name");


    public Products(SHAFT.GUI.WebDriver driver) {
        super(driver);
    }


    public String readTitle() {

        return driver.element().getText(titlePage);
    }

    public int listOfItems() {
        return driver.element().getElementsCount(numberOfList);

    }

    // Method to click the select menu and return the number of options inside it
    public int listOfSelectMenu() {
        driver.element().click(selectMenu);
        return driver.element().getElementsCount(selectMenuOptions);
    }

    public boolean displayProduct(int index) {
        By detailOfProductAtIndex = By.xpath("(//div[@class='inventory_item_desc'])[" + index + "]");
        By imgOfProductAtIndex = By.xpath("(//div[@class='inventory_item_img'])[" + index + "]");
        By priceOfProductAtIndex = By.xpath("(//div[@class='inventory_item_price'])[" + index + "]");

        boolean isDetailDisplay = driver.element().isElementDisplayed(detailOfProductAtIndex);
        boolean isImgDisplay = driver.element().isElementDisplayed(imgOfProductAtIndex);
        boolean isPriceDisplay = driver.element().isElementDisplayed(priceOfProductAtIndex);
        return isDetailDisplay && isImgDisplay && isPriceDisplay;
    }

    public void addToCartAndVerifyButtonChange() {
        driver.element().click(addToCartBtn);
        driver.element().waitToBeReady(removeBtn).assertThat(removeBtn).isVisible();

    }

    public String getProductName() {

        return driver.element().getText(productName);
    }

    public Cart goToCart() {
        System.out.println( "before click ");
        driver.element().click(cartLink);
        System.out.println( "after click");
        return new Cart(driver);
    }

    // Method to verify if we are on the product page
    public boolean isAtProductPage() {
        String currentUrl = driver.getDriver().getCurrentUrl();
        return currentUrl.equals("https://www.saucedemo.com/inventory.html");
    }

    // because we use string method we compare it with ASCll schedule
    public String highPriceValue() {
        driver.element().click(selectMenu);
        driver.element().click(highToLowOption);
        return driver.element().getText(priceItem);

    }

    public String lowPriceValue() {
        driver.element().click(selectMenu);
        driver.element().click(lowToHighOption);
        return driver.element().getText(priceItem);

    }

    public boolean priceComparative(){
        String high = highPriceValue();
        String low = lowPriceValue();

        // Convert string prices to numeric values for accurate comparison
        double highPrice = Double.parseDouble(high.replace("$", ""));
        double lowPrice = Double.parseDouble(low.replace("$", ""));

        // Return true if the low price is actually lower than the high price
        return lowPrice < highPrice;

    }
    public String aToZFirstItem(){
        driver.element().click(selectMenu);
        driver.element().click(aTozOption);
        return driver.element().waitToBeReady(firstItemName).getText(firstItemName);

    }
    public String zToAFirstItem(){
        driver.element().click(selectMenu);
        driver.element().click(zToaOption);
        return driver.element().waitToBeReady(firstItemName).getText(firstItemName);
    }


    // Method to compare the first item names
    public boolean isSortedCorrectly() {
      String aToZ = aToZFirstItem();
        String zToA = zToAFirstItem();
        System.out.println("First item name (A to Z): " + aToZ);
        System.out.println("First item name (Z to A): " + zToA);
        return aToZ.compareTo(zToA)<0;
}
}