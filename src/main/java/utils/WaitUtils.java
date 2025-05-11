package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitUtils {
    private static final By SPINNER_OVERLAY = By.cssSelector("div.ngx-spinner-overlay");
    private static final By TOAST_CONTAINER = By.id("toast-container");

    public static void waitForSpinnerToDisappear(WebDriver driver, int timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(SPINNER_OVERLAY));
    }

    public static void waitForSpinnerToDisappear(WebDriver driver) {
        waitForSpinnerToDisappear(driver, 10);
    }

    public static void waitForToastContainerToDisappear(WebDriver driver, int timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(TOAST_CONTAINER));
    }
    public static void waitForToastContainerToDisappear(WebDriver driver) {
        waitForToastContainerToDisappear(driver, 10);
    }

    public static WebElement waitForElementVisible(WebDriver driver, By locator, int timeoutInSeconds) {
        return new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds))
                .until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public static WebElement waitForElementVisible(WebDriver driver, By locator) {
        return waitForElementVisible(driver, locator, 10);
    }


    public static void waitForElementToBeClickable(WebDriver driver, WebElement element, int timeoutInSeconds) {
        new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds))
                .until(ExpectedConditions.elementToBeClickable(element));
    }

    public static void waitForElementToBeClickable(WebDriver driver, WebElement element) {
        waitForElementToBeClickable(driver, element, 10);
    }
    public static void waitForElementVisible(WebDriver driver, WebElement element, int timeoutInSeconds) {
        new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds))
                .until(ExpectedConditions.visibilityOf(element));
    }

    public static void waitForElementVisible(WebDriver driver, WebElement element) {
        waitForElementVisible(driver, element, 10);
    }
}
