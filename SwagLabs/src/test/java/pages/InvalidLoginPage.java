package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InvalidLoginPage extends LoginPage{

    public InvalidLoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    // Locators

    @FindBy(xpath = "//*[@id=\"user-name\"]")
    private WebElement InvalidUserName;

    @FindBy(xpath = "//*[@id=\"password\"]")
    private WebElement InvalidPassword;

    @FindBy(xpath = "//*[@id=\"login-button\"]")
    private WebElement logInBtn;

    @FindBy(xpath = "//*[@id=\"login_button_container\"]/div/form/div[3]/h3")
    private WebElement errorMassage;

    //Methods

    public void enterInvalidUsername(){
        InvalidUserName.sendKeys("invalid_user");
    }

    public void enterInvalidPassword(){
        InvalidPassword.sendKeys("invalid_password");
    }

    public void clickLoginButton(){
        logInBtn.click();
    }

    public String getErrorMessage(){
       return errorMassage.getText();
    }
}

