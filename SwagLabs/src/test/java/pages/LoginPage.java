package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    WebDriver driver;

    public LoginPage(WebDriver webDrivers){
        driver = webDrivers;
        PageFactory.initElements(driver,this);
    }
    // Locators

    @FindBy(xpath = "//*[@id=\"user-name\"]")
    private WebElement userName;

    @FindBy(xpath = "//*[@id=\"password\"]")
    private WebElement password;

    @FindBy(xpath = "//*[@id=\"login-button\"]")
    private WebElement logInBtn;

    @FindBy(xpath = "//*[@id=\"item_4_title_link\"]/div")
    private WebElement firstItem;

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

    public void clickFirstItem(){
        firstItem.click();
    }
}
