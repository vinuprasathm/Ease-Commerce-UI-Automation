package stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import utils.BaseTest;

public class Hooks {

    @Before
    public void setUp() {
        System.out.println("🔄 Initializing WebDriver...");
        BaseTest.setup();  // Ensures WebDriver is set up before any test runs
    }

    @After
    public void tearDown() {
        System.out.println("🛑 Closing WebDriver...");
        BaseTest.teardown(); // Ensures WebDriver quits after tests
    }
}
