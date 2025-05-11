package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class OrderSummary {
    private final WebDriver driver;

    public OrderSummary(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(css = ".hero-primary")
    private WebElement confirmationMessage;

    public void validateConfirmationMessage() {
       String confirmationMessageText= confirmationMessage.getText();
        Assert.assertTrue(confirmationMessageText.equalsIgnoreCase( "Thankyou for the order."), "Order confirmation message is not as expected");

    }



}
