package com.examples.ui;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class LoginSteps {

    WebDriver driver;

    @Given("I go to login page")
    public void iGoToLoginPage() {
        // Configure chrome driver.
        WebDriverManager.chromedriver().setup();

        // Initialize chrome driver.
        driver = new ChromeDriver();

        // Load URL.
        driver.get("https://www.pivotaltracker.com/signin");
    }

    @When("I enter {string} in username field")
    public void iEnterInUsernameField(String username) {
        // Locate Username webelement
        WebElement usernameTextBox = driver.findElement(By.cssSelector("#credentials_username"));

        // Fill username on webelement
        usernameTextBox.sendKeys(username);
    }

    @And("I click on Next button")
    public void iClickOnNextButton() {
        // Locate action button
        WebElement actionButton = driver.findElement(By.cssSelector(".app_signin_action_button"));

        // Clicks on action button
        actionButton.click();
    }

    @And("I enter {string} in password field")
    public void iEnterInPasswordField(String password) {
        // Locate Password webelement
        WebElement passwordTextBox = driver.findElement(By.cssSelector("#credentials_password"));

        // Fill password on webelement
        passwordTextBox.sendKeys(password);
    }

    @And("I click on Sign In")
    public void iClickOnSignIn() {
        // Locate login button
        WebElement loginButton = driver.findElement(By.cssSelector(".app_signin_action_button"));

        // Click on login
        loginButton.click();
    }

    @Then("I verify that the error message is {string}")
    public void iVerifyThatTheErrorMessageIs(String expectedMessage) {
        // Locate message error
        WebElement errorMessage = driver.findElement(By.cssSelector(".app_signin_error"));

        // Assert message error
        String actualErrorMessage = errorMessage.getText();
        Assert.assertEquals(actualErrorMessage, expectedMessage);
    }

    @Then("I verify that username {string} is displayed on dashboard")
    public void iVerifyThatUsernameIsDisplayedOnDashboard(String expectedUsername) {
        // Locate profile dropdown
        WebElement profileDropdown = driver.findElement(By.cssSelector("*[aria-label='Profile Dropdown']"));

        // Assert username
        String actualUsername = profileDropdown.getText();
        Assert.assertTrue(expectedUsername.equalsIgnoreCase(actualUsername));
    }
}
