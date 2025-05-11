package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.WaitUtils;

import java.util.List;

public class CartPage {
    private WebDriver driver;

    @FindBy(xpath = "//button[text()='Checkout']")
    private WebElement checkoutButton;

    @FindBy(css = ".cartSection h3")
    private List<WebElement> productName;

    @FindBy(xpath = "//div[@Class='cartSection']/p[2]")
    private List<WebElement> subTotal;

    @FindBy(xpath = "//li[@class='totalRow']/span[text()='Total']/following-sibling::span")
    private WebElement totalAmount;

    public CartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getProductName() {
        WaitUtils.waitForElementVisible(driver, productName.get(0));
        return productName.get(0).getText();
    }

    public String getProductName(int i) {
        System.out.println("Index is :"+i);
        WaitUtils.waitForElementVisible(driver, productName.get(i));
        System.out.println(productName.get(i).getText());
        return productName.get(i).getText();
    }

    public String getTotalAmount() {
        WaitUtils.waitForElementVisible(driver, totalAmount);
        return totalAmount.getText();
    }

    public void proceedToCheckout() {
        WaitUtils.waitForSpinnerToDisappear(driver);
        WaitUtils.waitForToastContainerToDisappear(driver);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", checkoutButton);
        WaitUtils.waitForElementToBeClickable(driver, checkoutButton);

        checkoutButton.click();
    }

    public int getCalculatedSubTotalAmount() {
        int total = 0;

        for (WebElement element : subTotal) {
            String text = element.getText(); // e.g., "MRP $ 31500"
            String numericValue = text.replaceAll("[^0-9]", ""); // removes all non-digits
            int amount = Integer.parseInt(numericValue);
            total += amount;
        }
        return total;
    }
}