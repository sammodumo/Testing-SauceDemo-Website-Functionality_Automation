package stepDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import pages.ProductBrowsingPage;

import java.io.IOException;

public class ProductBrowsingStep {

    private WebDriver driver;
    private ProductBrowsingPage productBrowsingPage;

    @Given("I am logged into SauceDemo with username {string} and password {string}")
    public void i_am_logged_into_sauceDemo_with_credentials(String username, String password) throws InterruptedException {
        WebDriver driver = WebDriverManager.chromedriver().create();
        driver.get("https://www.saucedemo.com/");
        Thread.sleep(2000);
        productBrowsingPage = new ProductBrowsingPage(driver);

        productBrowsingPage.enterUsername();
        Thread.sleep(2000);
        productBrowsingPage.enterPassword();
        Thread.sleep(2000);
        productBrowsingPage.clickLoginButton();
        Thread.sleep(2000);
    }

    @When("I click on a specific product")
    public void iClickOnASpecificProduct() throws InterruptedException {
        productBrowsingPage.selectProduct();
        Thread.sleep(2000);
    }


    @Then("I should see the details of that product")
    public void iShouldSeeTheDetailsOfThatProduct() throws InterruptedException {
        productBrowsingPage.assertProductDetails();
        Thread.sleep(2000);

    }


    @Given("I am logged in and on the products page")
    public void iAmLoggedInAndOnTheProductsPage() throws InterruptedException {
        WebDriver driver = WebDriverManager.chromedriver().create();
        driver.get("https://www.saucedemo.com/");
        Thread.sleep(2000);
        productBrowsingPage = new ProductBrowsingPage(driver);

        productBrowsingPage.enterUsername();
        Thread.sleep(2000);
        productBrowsingPage.enterPassword();
        Thread.sleep(2000);
        productBrowsingPage.clickLoginButton();
        Thread.sleep(2000);
    }


    @When("I add a product to the cart")
    public void iAddAProductToTheCart() throws InterruptedException {
        productBrowsingPage.clickAddToCartBtn();
        Thread.sleep(2000);
    }


    @Then("the cart icon should update to reflect the added product")
    public void theCartIconShouldUpdateToReflectTheAddedProduct() throws InterruptedException, IOException {

        productBrowsingPage.verifyCartIconUpdated(1);
        Thread.sleep(2000);
    }


    @Given("I have products in my cart")
    public void iHaveProductsInMyCart() throws InterruptedException {
        productBrowsingPage.verifyCartIconUpdated(1);
        Thread.sleep(2000);
    }

    @When("I remove a product from the cart")
    public void iRemoveAProductFromTheCart() throws InterruptedException {
        productBrowsingPage.clickRemoveFromCartBtn();
        Thread.sleep(2000);
    }

    @Then("the cart should update to reflect the removed product")
    public void theCartShouldUpdateToReflectTheRemovedProduct() throws InterruptedException {
        productBrowsingPage.verifyCartIconUpdatedAfterRemoval(0);
        Thread.sleep(2000);
    }
}
