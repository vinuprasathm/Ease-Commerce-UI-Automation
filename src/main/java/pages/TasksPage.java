package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;
import org.openqa.selenium.support.ui.Select;
import utils.TestDataGenerator;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class TasksPage {
    private WebDriver driver;
    SoftAssert softAssert = new SoftAssert();

    public TasksPage(WebDriver driver) {
        this.driver = driver;
    }

    private By addTaskButton = By.xpath("//button[text()='Add Task']");
    private By selectSuperCategory = By.xpath("//input[@placeHolder='Select Super Category']/parent::div/div/button");
    private By selectSubCategory = By.xpath("//input[@placeHolder='Select Sub Category']/parent::div/div/button");
    private By selectPortals = By.xpath("//input[@placeHolder='Select Portals']/parent::div/div/button");
    private By selectProducts = By.xpath("//input[@placeHolder='Select Products']/parent::div/div/button");
    private By selectTask = By.xpath("//input[@placeHolder='Select Task Name']/parent::div/div/button");
    private By selectAssignee = By.xpath("//input[@placeHolder='Select Assignee']/parent::div/div/button");
    private By selectReviewers = By.xpath("//input[@placeHolder='Select Reviewers']/parent::div/div/button");
    private By selectPriority = By.xpath("//input[@placeHolder='Select Priority']/parent::div/div/button");
    private By description = By.xpath("//span[text()='Description']/parent::div//div[@class= 'ql-editor ql-blank']");
    private By submitButtonLocator = By.xpath("//button[text()='Submit']");
    

    public void clickAddTask() {
        driver.findElement(addTaskButton).click();
    }

    public void enterFormDetails() {
        WebElement selectSuperCategoryDropDown = driver.findElement(selectSuperCategory);
        selectSuperCategoryDropDown.click();
        Select select = new Select(selectSuperCategoryDropDown);
        select.selectByValue("Customer Support Services");
        
        WebElement selectSubCategoryDropdown = driver.findElement(selectSubCategory);
        selectSubCategoryDropdown.click();
        Select selectSub = new Select(selectSubCategoryDropdown);
        selectSub.selectByValue("Routine Customer Handling");
        
        WebElement selectPortalsDropdown = driver.findElement(selectPortals);
        selectSubCategoryDropdown.click();
        Select selectPortal = new Select(selectPortalsDropdown);
        selectPortal.selectByValue("Shopify");
        
        WebElement selectProductsDropdown = driver.findElement(selectProducts);
        selectProductsDropdown.click();
        Select selectProduct = new Select(selectProductsDropdown);
        selectProduct.selectByIndex(0);
        
        String uniqueTaskName = "Task_" + TestDataGenerator.generateRandomString(5);
        driver.findElement(selectTask).sendKeys(uniqueTaskName);
        
        WebElement selectAssigneeDropdown = driver.findElement(selectAssignee);
        selectAssigneeDropdown.click();
        Select selectAssignee = new Select(selectProductsDropdown);
        selectAssignee.selectByIndex(0);
        
        WebElement selectReviewersDropdown = driver.findElement(selectReviewers);
        selectReviewersDropdown.click();
        Select selectReviewers = new Select(selectReviewersDropdown);
        selectReviewers.selectByIndex(0);
        
        WebElement selectPriorityDropdown = driver.findElement(selectPriority);
        selectReviewersDropdown.click();
        Select selectPriority = new Select(selectPriorityDropdown);
        selectPriority.selectByIndex(0);
        
        String futureDate = LocalDate.now().plusDays(7).format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        driver.findElement(By.xpath("//input[@placeholder='DD/MM/YYYY']")).sendKeys(futureDate);
        
        String uniqueDescription = "Desc_" + TestDataGenerator.generateRandomString(5);
        driver.findElement(description).sendKeys(uniqueDescription);
        
        WebElement submitButton = driver.findElement(submitButtonLocator);
        submitButton.click();
    }

    public void submitButtonDisabled() throws InterruptedException {
        WebElement submitButton = driver.findElement(submitButtonLocator);
        submitButton.click();  // Click the button before checking its state
        Thread.sleep(5000);
        softAssert.assertFalse(submitButton.isEnabled(), "Submit button should be disabled after clicking");
        softAssert.assertAll();
    }

    public void verifyTaskAdded() {
        // Add logic to verify if task is added
    }
}
