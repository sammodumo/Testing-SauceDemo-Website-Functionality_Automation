package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProductBrowsingPage extends LoginPage{
    public ProductBrowsingPage(WebDriver webDrivers) {
        super(webDrivers);
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//*[@id=\"user-name\"]")
    private WebElement userName;

    @FindBy(xpath = "//*[@id=\"password\"]")
    private WebElement password;

    @FindBy(xpath = "//*[@id=\"login-button\"]")
    private WebElement logInBtn;

    @FindBy(xpath = "//*[@id=\"item_4_title_link\"]/div")
    private WebElement productClick;

    @FindBy(xpath = "//*[@id=\"inventory_item_container\"]/div/div/div[2]/div[2]")
    private WebElement productDetails;

    @FindBy(xpath = "//*[@id=\"add-to-cart-sauce-labs-backpack\"]")
    private WebElement addToCartBtn;

    @FindBy(xpath = "//*[@id=\"shopping_cart_container\"]/a")
    private WebElement CartIcon;

    @FindBy(xpath = "//*[@id=\"shopping_cart_container\"]/a/span")
    private WebElement CartBadge;

    @FindBy(xpath = "//*[@id=\"remove-sauce-labs-backpack\"]")
    private WebElement RemoveFromCard;

    //Methods

    public void enterUsername(){
        userName.sendKeys("performance_glitch_user");
    }

    public void enterPassword(){
        password.sendKeys("secret_sauce");
    }

    public void clickLoginButton(){
        logInBtn.click();
    }

    public void selectProduct(){
        productClick.click();
    }

    public void assertProductDetails() {

        String expectedDetails = "carry.allTheThings() with the sleek, streamlined Sly Pack that melds uncompromising style with unequaled laptop and tablet protection.";

        String actualDetails = productDetails.getText().trim();

        Assert.assertTrue("Product details do not match", actualDetails.contains(expectedDetails));
    }

    public void clickAddToCartBtn(){
        addToCartBtn.click();
    }

    public void verifyCartIconUpdated(int expectedItemCount) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(CartBadge));

        try {
            String badgeText = CartBadge.getText().trim();
            int actualItemCount = Integer.parseInt(badgeText);
            Assert.assertEquals("Cart icon did not update correctly.", expectedItemCount, actualItemCount);
        } catch (NumberFormatException e) {
            Assert.fail("Badge text is not a valid number: " + CartBadge.getText().trim());
        }
    }

    public void clickRemoveFromCartBtn(){
        RemoveFromCard.click();
    }

    public void verifyCartIconUpdatedAfterRemoval(int expectedItemCount) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Wait for the cart badge to be visible
        wait.until(ExpectedConditions.visibilityOf(CartBadge));

        try {
            // Get the text of the cart badge (number of items in cart)
            String badgeText = CartBadge.getText().trim();

            // Parse the text to get the actual item count
            int actualItemCount = Integer.parseInt(badgeText);

            // Assert that the cart icon updates correctly after removal
            Assert.assertEquals("Cart icon did not update correctly after product removal.", expectedItemCount, actualItemCount);
        } catch (NumberFormatException e) {
            // If the badge text is not a valid number, fail the test
            Assert.fail("Badge text is not a valid number: " + CartBadge.getText().trim());
        }
    }


}
