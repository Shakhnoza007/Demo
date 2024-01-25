package com.demo.step_definitions;

import com.demo.pages.WorkdayPage;
import com.demo.utilities.BrowserUtils;
import com.demo.utilities.ConfigurationReader;
import com.demo.utilities.Driver;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Workday_StepDefinitions {

    String workday_URL = ConfigurationReader.getProperty("workday_URL");
    String username = ConfigurationReader.getProperty("eva_username");
    String password = ConfigurationReader.getProperty("eva_password");

    WorkdayPage workdayPage = new WorkdayPage();

    @Given("user is on the login page of the Workday Jobs application")
    public void user_is_on_the_login_page_of_the_workday_jobs_application() {
        Driver.getDriver().get(workday_URL);
    }
    @When("user enters eva username")
    public void user_enters_eva_username() {
        workdayPage.username_input.sendKeys(username);

    }
    @When("user enters eva password")
    public void user_enters_eva_password() {
        workdayPage.password_input.sendKeys(password);

    }

    @And("user clicks Sign In button")
    public void user_Clicks_Sign_In_Button() {

        BrowserUtils.sleep(2);
        workdayPage.sign_in_button.click();

    }

    @Then("user should see the Welcome text")
    public void user_should_see_the_Welcome_text() {
        // Write code here that turns the phrase above into concrete actions
        assert workdayPage.welcome_text.isDisplayed();

    }

    @Given("user logs in to Clarivate Workday")
    public void user_logs_in() {
        Driver.getDriver().get(workday_URL);
        workdayPage.login();
    }

    @When("the user login with {string},{string}")
    public void the_user_login_with(String username, String password) {
        workdayPage.login(username, password);
    }

    @Then("the user should not be able to log in")
    public void the_user_should_not_be_able_to_log_in() {
        assert workdayPage.error_message.isDisplayed();
    }

    @Then("user should be able to see following modules")
    public void user_should_be_able_to_see_following_modules(List<String> expectedModules) {
        BrowserUtils.sleep(3);

        List<String> actualModules = new ArrayList<>();   // creating empty list of Strings

        for (WebElement eachModule : workdayPage.allTopModules) {

            actualModules.add(eachModule.getText());   // adding modules' text to an empty list of Strings
        }

        Assert.assertEquals(expectedModules,actualModules);  // comparing if expected modules are the same as actual modules
    }
}
