package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.WaitUtils;

public class ProductPage {
    private WebDriver driver;

    @FindBy(css = "button[routerlink*='cart']")
    private WebElement cartButton;

    public ProductPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void addProductToCart(String productName) {
        String xpath = "//b[text()='" + productName + "']/parent::h5/parent::div/button[2]";
        WebElement addToCartButton = driver.findElement(org.openqa.selenium.By.xpath(xpath));
        WaitUtils.waitForElementToBeClickable(driver, addToCartButton);
        addToCartButton.click();
        WaitUtils.waitForSpinnerToDisappear(driver);
        WaitUtils.waitForToastContainerToDisappear(driver);
    }

    public void goToCart() {
        WaitUtils.waitForElementToBeClickable(driver, cartButton);
        cartButton.click();
    }
} 