package stepdefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DateFieldValidation {

    WebDriver driver = Hooks.driver;

    @When("the user books appointment without selecting Visit Date")
    public void theUserBooksAppointmentWithoutSelectingVisitDate() {
        WebElement buttonMakeAppointment = driver.findElement(By.id("btn-make-appointment"));
        buttonMakeAppointment.click();
        System.out.println("Current Page URL: " + driver.getCurrentUrl());
            WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement visitDate= wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("txt_visit_date")));
            String visitDateValue= visitDate.getAttribute("value");
            Assert.assertTrue("Value is not Empty", visitDateValue.isEmpty());
    }

    @Then("the visit date field should be required")
    public void theVisitDateFieldShouldBeRequired() {
        WebElement buttonMakeAppointment = driver.findElement(By.id("btn-make-appointment"));
        buttonMakeAppointment.click();
        WebElement visitDate= driver.findElement(By.id("txt_visit_date"));
        String requiredField=visitDate.getAttribute("required");

        Assert.assertNotNull("Visit Date should be a required field",requiredField);

    }


}
