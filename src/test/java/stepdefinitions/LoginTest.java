package stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest {
    WebDriver driver = Hooks.driver;

    @Given("the user is on the login page")
    public void the_user_is_on_the_login_page() {
        driver.get("https://katalon-demo-cura.herokuapp.com/profile.php#login");
    }

    @When("user enters invalid username {string} or password {string}")
    public void user_enters_invalid_username_or_password(String invalidUsername, String invalidPassword) {
        driver.findElement(By.id("txt-username")).sendKeys(invalidUsername);
        driver.findElement(By.id("txt-password")).sendKeys(invalidPassword);
    }

    @When("clicks on the login button")
    public void clicks_on_the_login_button() {
        driver.findElement(By.id("btn-login")).click();
    }

    @Then("the user should see an Error message {string}")
    public void the_user_should_see_an_error_message(String expectedErrorMessage) {
        WebElement errorMessage = driver.findElement(By.className("text-danger"));
        String actualErrorMsg = errorMessage.getText().trim();
        Assert.assertEquals(expectedErrorMessage, actualErrorMsg);
    }
}
