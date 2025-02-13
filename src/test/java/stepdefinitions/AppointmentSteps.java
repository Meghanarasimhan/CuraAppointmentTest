package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import org.junit.Assert;
import stepdefinitions.Hooks;

public class AppointmentSteps {

    WebDriver driver = Hooks.driver;

    @Given("I am on the Cura Healthcare homepage")
    public void iAmOnTheCuraHealthcareHomepage() {
        driver.get("https://katalon-demo-cura.herokuapp.com");
    }

    @When("I click on the {string} button")
    public void iClickOnTheButton(String buttonName) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement button = wait.until(ExpectedConditions.elementToBeClickable(By.id("btn-make-appointment")));
        button.click();
    }

    @And("I login with username {string} and password {string}")
    public void iLoginWithUsernameAndPassword(String username, String password) {
        driver.findElement(By.id("txt-username")).sendKeys(username);
        driver.findElement(By.id("txt-password")).sendKeys(password);
        driver.findElement(By.id("btn-login")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.urlContains("#appointment"));
        Assert.assertTrue("Login failed! Incorrect page after login.",
                driver.getCurrentUrl().contains("#appointment"));
         }

    @And("I fill the appointment form with facility {string}")
    public void iFillTheAppointmentFormWithFacility(String facility) {
        WebElement dropdown = driver.findElement(By.id("combo_facility"));
        dropdown.sendKeys(facility);
    }

    @And("I check the box for {string}")
    public void iCheckTheBoxFor(String option) {
        driver.findElement(By.id("chk_hospotal_readmission")).click();
    }

    @And("I choose {string} as the healthcare program")
    public void iChooseAsTheHealthcareProgram(String program) {
        switch (program) {
            case "Medicare":
                driver.findElement(By.id("radio_program_medicare")).click();
                break;
            case "Medicaid":
                driver.findElement(By.id("radio_program_medicaid")).click(); // Fixed ID
                break;
            case "None":
                driver.findElement(By.id("radio_program_none")).click();
                break;
        }
    }

    @And("I choose visit Date {string}")
    public void iChooseVisitDate(String date) {
        WebElement dateField = driver.findElement(By.id("txt_visit_date"));
        dateField.clear();
        dateField.sendKeys(date);
    }

    @And("I click the {string} button")
    public void iClickTheButton(String buttonName) {
        WebElement button = driver.findElement(By.id("btn-book-appointment"));
        button.click();
    }

    @Then("I should see the confirmation message {string}")
    public void iShouldSeeTheConfirmationMessage(String expectedMessage) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement confirmMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//h2[contains(text(),'Appointment Confirmation')]")
        ));
        Assert.assertTrue("Booking confirmation message not displayed!", confirmMsg.isDisplayed());
    }
}
