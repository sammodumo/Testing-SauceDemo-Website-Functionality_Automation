package stepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;

import javax.swing.*;


public class LogInStep {
    private WebDriver driver;
    private LoginPage loginPage;

    @Given("I navigate to the SauceDemo login page")
    public void i_navigate_to_the_sauceDemo_login_page() throws InterruptedException {
        WebDriver driver = WebDriverManager.chromedriver().create();
        driver.get("https://www.saucedemo.com/");
        Thread.sleep(2000);
        loginPage = new LoginPage(driver);
    }

    @When("I enter valid username and password")
    public void I_enter_valid_username_and_password() throws InterruptedException {
        loginPage.enterUsername();
        Thread.sleep(2000);
        loginPage.enterPassword();
        Thread.sleep(2000);
    }

    @And("I click on the login button")
    public void i_click_on_the_login_button() throws InterruptedException {
        loginPage.clickLoginButton();
        Thread.sleep(2000);

    }

    @Then("I should be logged into the system and click first item")
    public void I_should_be_logged_into_the_system_and_click_first_item() throws InterruptedException {
     loginPage.clickFirstItem();
     Thread.sleep(2000);
    }


}
