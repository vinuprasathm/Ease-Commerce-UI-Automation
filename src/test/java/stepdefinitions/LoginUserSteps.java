package stepdefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import pages.DashboardPage;
import pages.LoginPage;
import pages.TasksPage;
import utils.BaseTest;
import utils.ConfigReader;

public class LoginUserSteps {
    WebDriver driver = BaseTest.getDriver();
    LoginPage loginPage = new LoginPage(driver);
    DashboardPage dashboardPage = new DashboardPage(driver);
    TasksPage tasksPage = new TasksPage(driver);
    ConfigReader config = new ConfigReader();

    @Given("the user is on the login page")
    public void theUserIsOnTheLoginPage() {
        driver.get("https://easecommerce.in/app/login");
    }

    @When("the user enters valid credentials")
    public void theUserEntersValidCredentials() {
        loginPage.enterEmail(config.getUsername());
        loginPage.enterPassword(config.getPassword());
    }

    @When("clicks the login button")
    public void clicksTheLoginButton() {
        loginPage.clickLogin();
    }

    @Then("the user should be redirected to the dashboard")
    public void theUserShouldBeRedirectedToTheDashboard() {
        dashboardPage.verifyDashboardIsDisplayed();
    }

    @When("the user switches to Employee Mode")
    public void theUserSwitchesToEmployeeMode() {
        dashboardPage.openSettings();
        dashboardPage.switchToEmployeeMode();
    }

    @When("clicks on Add Task")
    public void clicksOnAddTask() {
        tasksPage.clickAddTask();
    }

    @Then("the task should be added successfully")
    public void theTaskShouldBeAddedSuccessfully() {
        tasksPage.verifyTaskAdded();
        System.out.println("✅ Task added successfully.");
    }
}
