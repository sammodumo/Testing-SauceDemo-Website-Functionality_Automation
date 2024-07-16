package stepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import pages.InvalidLoginPage;
import pages.LoginPage;

public class InvalidLoginStep {

    private WebDriver driver;
    private InvalidLoginPage invalidLoginPage;

    @Given("I am on the SauceDemo login page")
    public void I_am_on_the_SauceDemo_login_page() throws InterruptedException {
        WebDriver driver = WebDriverManager.chromedriver().create();
        driver.get("https://www.saucedemo.com/");
        Thread.sleep(2000);
        invalidLoginPage = new InvalidLoginPage(driver);
    }

    @When("I enter invalid username and invalid password\"")
    public void iEnterInvalidUsernameAndInvalidPassword() throws InterruptedException {
       invalidLoginPage.enterInvalidUsername();
       Thread.sleep(2000);
       invalidLoginPage.enterInvalidPassword();
       Thread.sleep(2000);
    }

    @And("I click on the Login button")
    public void iClickOnTheLoginButton() throws InterruptedException {
        invalidLoginPage.clickLoginButton();
        Thread.sleep(2000);
    }

    @Then("I should see an error message {string}")
    public void iShouldSeeAnErrorMessage(String arg0) throws InterruptedException {
        invalidLoginPage.getErrorMessage();
        Thread.sleep(2000);
    }
}

