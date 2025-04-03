package stepdefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import pages.DashboardPage;
import pages.LoginPage;
import pages.TasksPage;
import utils.BaseTest;
import utils.ConfigReader;

public class LoginUserSteps {
	WebDriver driver;
    LoginPage loginPage;
    DashboardPage dashboardPage;
    TasksPage tasksPage;
    ConfigReader config;

    @Given("the user is on the login page")
    public void theUserIsOnTheLoginPage() {
        this.driver = BaseTest.getDriver(); // Ensure driver is set before using it
        loginPage = new LoginPage(driver);
        dashboardPage = new DashboardPage(driver);
        tasksPage = new TasksPage(driver);
        config = new ConfigReader();

        System.out.println(" Navigating to Login Page...");
        driver.get("https://easecommerce.in/app/login");
    }

    @When("the user enters valid credentials")
    public void theUserEntersValidCredentials() {
        System.out.println(" Entering Credentials...");
        loginPage.enterEmail(config.getUsername());
        loginPage.enterPassword(config.getPassword());
    }

    @When("clicks the login button")
    public void clicksTheLoginButton() {
        System.out.println("🖱️ Clicking Login Button...");
        loginPage.clickLogin();
    }

    @Then("the user should be redirected to the dashboard")
    public void theUserShouldBeRedirectedToTheDashboard() {
        System.out.println("Verifying Dashboard Visibility...");
        dashboardPage.verifyDashboardIsDisplayed();
    }

    @When("the user switches to Employee Mode")
    public void theUserSwitchesToEmployeeMode() {
        System.out.println(" Switching to Employee Mode...");
        dashboardPage.openSettings();
        dashboardPage.switchToEmployeeMode();
    }

    @When("clicks on Add Task")
    public void clicksOnAddTask() {
        System.out.println(" Clicking 'Add Task'...");
        tasksPage.clickAddTask();
    }

    @Then("the task should be added successfully")
    public void theTaskShouldBeAddedSuccessfully() {
        System.out.println("Verifying Task Addition...");
        tasksPage.enterFormDetails();
        tasksPage.verifyTaskAdded();
    }

    @Then("submit button should be disabled")
    public void submitButtonShouldBeDisabled() throws InterruptedException {
        System.out.println(" Checking if Submit Button is Disabled...");
        tasksPage.submitButtonDisabled();
    }
}
