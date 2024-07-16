package stepDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import pages.AddToCard;

public class AddToCartStep {

    private WebDriver driver;
    private AddToCard addToCardPage;

    @Given("I am logged in to SauceDemo")
    public void I_am_logged_in_to_SauceDemo() throws InterruptedException {
        WebDriver driver = WebDriverManager.chromedriver().create();
        driver.get("https://www.saucedemo.com/");
        Thread.sleep(2000);
        addToCardPage = new AddToCard(driver);

        addToCardPage.enterUsername();
        Thread.sleep(2000);
        addToCardPage.enterPassword();
        Thread.sleep(2000);
        addToCardPage.clickLoginButton();
        Thread.sleep(2000);
    }

    @When("I add a product to my cart")
    public void iAddAProductToMyCart() throws InterruptedException {
        addToCardPage.clickAddToCartBtn();
        Thread.sleep(2000);
    }

    @Then("the product should appear in my cart")
    public void theProductShouldAppearInMyCart() throws InterruptedException {
        addToCardPage.clickCartIcon();
        Thread.sleep(2000);
    }
}
