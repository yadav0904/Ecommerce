package stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.en.*;
import io.cucumber.datatable.DataTable;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import pages.*;
import utils.ConfigReader;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.time.Duration;
import java.util.List;

public class EcommerceSteps {
    private WebDriver driver;
    private LoginPage loginPage;
    private ProductPage productPage;
    private CartPage cartPage;
    private CheckoutPage checkoutPage;
    private final ConfigReader configReader;
    private OrderSummary orderSummary;

    public EcommerceSteps() {
        configReader = new ConfigReader();
    }

    @Given("I am on the login page")
    public void iAmOnTheLoginPage() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(configReader.getBaseUrl());
        loginPage = new LoginPage(driver);
    }

    @When("I login with valid credentials")
    public void iLoginWithValidCredentials() {
        loginPage.login(configReader.getUsername(), configReader.getPassword());
        productPage = new ProductPage(driver);
    }

    @When("I add {string} to cart")
    public void iAddProductToCart(String productName) {
        productPage.addProductToCart(productName);
    }

    @When("I add the following products to cart:")
    public void iAddMultipleProductsToCart(DataTable products) {
        List<String> productList = products.asList();
        for (String product : productList) {
            productPage.addProductToCart(product);
        }
    }

    @When("I navigate to cart page")
    public void iNavigateToCartPage() {
        productPage.goToCart();
        cartPage = new CartPage(driver);
    }

    @Then("I should see the {string} in cart")
    public void iShouldSeeTheProductInCart(String productName) {
        Assert.assertTrue(cartPage.getProductName().contains(productName),
            "Product " + productName + " is not present in cart");
        System.out.println(productName + " is present in cart");
    }

    @Then("I should see all the following products in cart:")
    public void iShouldSeeAllProductsInCart(DataTable products) {
        List<String> productList = products.asList();

        for(int i=0;i<productList.size();i++){
            System.out.println("Current product is : "+productList.get(i));
            Assert.assertTrue(cartPage.getProductName(i).contains(productList.get(i)),
                "Product " + productList.get(i) + " is not present in cart");
            System.out.println(productList.get(i) + " is present in cart");
        }

    }

    @Then("the total amount should be correct")
    public void theTotalAmountShouldBeCorrect() {
        int subTotal = cartPage.getCalculatedSubTotalAmount();
        Assert.assertTrue(cartPage.getTotalAmount().contains("$"));
        int totalAmount = Integer.parseInt(cartPage.getTotalAmount().replaceAll("[^0-9]", ""));
        System.out.println("Calculated total of subTotal amounts is: "+subTotal);
        System.out.println("GUI total amount is :"+totalAmount);
        Assert.assertEquals(totalAmount, subTotal,
                "Total amount (" + totalAmount + ") does not match subtotal (" + subTotal + ").");
    }

    @When("I proceed to checkout")
    public void iProceedToCheckout() {
        cartPage.proceedToCheckout();
        checkoutPage = new CheckoutPage(driver);
    }

    @When("I fill in the mandatory information")
    public void iFillInTheMandatoryInformation() {
        checkoutPage.fillMandatoryInfo("India");
    }

    @When("I place the order")
    public void iPlaceTheOrder() {
        checkoutPage.placeOrder();
        orderSummary = new OrderSummary(driver);
    }

    @Then("I should see the order confirmation message")
    public void iShouldSeeTheOrderConfirmationMessage() {
        orderSummary.validateConfirmationMessage();
    }

    @After
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        if (driver != null) {
            driver.quit();
        }
    }
} 