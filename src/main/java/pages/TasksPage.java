package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TasksPage {
    private WebDriver driver;

    public TasksPage(WebDriver driver) {
        this.driver = driver;
    }

    private By addTaskButton = By.xpath("//button[text()='Add Task']");
    private By selectSuperCategory = By.xpath("//input[@placeHolder='Select Super Category']/parent::div/div/button");

    public void clickAddTask() {
        driver.findElement(addTaskButton).click();
    }
    
    public void enterFormDetails() {
        driver.findElement(selectSuperCategory).click();
    }
    

    public void verifyTaskAdded() {
        // Add logic to verify if task is added
    }
}
