package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage {
    private WebDriver driver;

    @FindBy(css = "input[placeholder='Select Country']")
    private WebElement countryInput;

    @FindBy(css = "button.ta-item")
    private WebElement countryOption;

    @FindBy(css = "a.action__submit")
    private WebElement placeOrderButton;

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void fillMandatoryInfo(String country) {
        countryInput.sendKeys(country);
        countryOption.click();
    }

    public void placeOrder() {
        placeOrderButton.click();
    }
} 