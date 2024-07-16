package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddToCard extends LoginPage {
    public AddToCard(WebDriver webDrivers) {
        super(webDrivers);
        PageFactory.initElements(driver,this);
    }

    // Locators

    @FindBy(xpath = "//*[@id=\"user-name\"]")
    private WebElement userName;

    @FindBy(xpath = "//*[@id=\"password\"]")
    private WebElement password;

    @FindBy(xpath = "//*[@id=\"login-button\"]")
    private WebElement logInBtn;

    @FindBy(xpath = "//*[@id=\"add-to-cart-sauce-labs-backpack\"]")
    private WebElement addToCartBtn;

    @FindBy(className = "shopping_cart_link")
    private WebElement addToCartIcon;

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

    public void clickAddToCartBtn(){
        addToCartBtn.click();
    }

    public void clickCartIcon(){
        addToCartIcon.click();
    }


}

