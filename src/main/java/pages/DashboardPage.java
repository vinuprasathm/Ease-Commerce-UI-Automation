package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashboardPage {
    private WebDriver driver;

    public DashboardPage(WebDriver driver) {
        this.driver = driver;
    }

    private By settingsButton = By.xpath("//button[@aria-label='Open Settings']");
    private By switchToEmployee = By.xpath("//p[text()='Switch to Employee']");

    public void openSettings() {
        driver.findElement(settingsButton).click();
    }

    public void switchToEmployeeMode() {
        driver.findElement(switchToEmployee).click();
    }

    public void verifyDashboardIsDisplayed() {
        // Add verification logic if necessary
    }
}
