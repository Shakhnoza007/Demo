package com.demo.step_definitions;

import com.demo.pages.WikiSearchPage;
import com.demo.utilities.BrowserUtils;
import com.demo.utilities.ConfigurationReader;
import com.demo.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class Wiki_StepDefinitions {

    WikiSearchPage wikiSearchPage = new WikiSearchPage();

    @Given("User is on Wikipedia home page")
    public void user_is_on_wikipedia_home_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("wiki_url"));
    }

    @When("User types {string} in the wiki search box")
    public void userTypesInTheWikiSearchBox(String searchValue) {

        wikiSearchPage.searchBox.sendKeys(searchValue);

    }

    @When("User clicks wiki search button")
    public void user_clicks_wiki_search_button() {

        wikiSearchPage.searchButton.click();

    }

    @Then("User sees {string} is in the wiki title")
    public void userSeesIsInTheWikiTitle(String expectedInTitle) {

        BrowserUtils.verifyTitleContains(expectedInTitle);

    }

    @Then("User sees {string} is in the main header")
    public void userSeesIsInTheMainHeader(String expectedText) {

        String actualHeaderText = wikiSearchPage.mainHeader.getText();

        Assert.assertEquals(actualHeaderText, expectedText);

    }

    @Then("User sees {string} is in the image header")
    public void userSeesIsInTheImageHeader(String expectedText) {


        Assert.assertEquals(wikiSearchPage.imageHeader.getText(), expectedText);

    }
}
