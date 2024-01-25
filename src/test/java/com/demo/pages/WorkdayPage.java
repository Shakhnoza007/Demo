package com.demo.pages;

import com.demo.utilities.BrowserUtils;
import com.demo.utilities.ConfigurationReader;
import com.demo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class WorkdayPage {

    //#1- Create the constructor and initialize the driver with object
    public WorkdayPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    //#2- Use @FindBy instead of findElement()
    @FindBy(id = "input-4")
    public WebElement username_input;

    @FindBy(id = "input-5")
    public WebElement password_input;

    @FindBy(xpath = "//div[@aria-label='Sign In']")
    public WebElement sign_in_button;

    @FindBy(xpath = "//h2[.='Welcome, Eva Tukhtaboeva']")
    public WebElement welcome_text;

    @FindBy(xpath = "//button[.='Search for Jobs']")
    public WebElement search_for_jobs_button;

    @FindBy(xpath = "//button[.='Candidate Home']")
    public WebElement candidate_home_button;

    @FindBy(xpath = "//button[.='Job Alerts']")
    public WebElement job_alerts_button;

    @FindBy(xpath = "//p[@id='error1-']")
    public WebElement error_message;

    @FindBy(xpath = "//nav[@class='css-1hafuyi']/button")
    public List<WebElement> allTopModules;

    public void login(){
        username_input.sendKeys(ConfigurationReader.getProperty("eva_username"));
        password_input.sendKeys(ConfigurationReader.getProperty("eva_password"));
        BrowserUtils.sleep(2);
        sign_in_button.click();
    }

    public void login(String username, String password){
        username_input.sendKeys(username);
        password_input.sendKeys(password);
        BrowserUtils.sleep(2);
        sign_in_button.click();
    }


}
