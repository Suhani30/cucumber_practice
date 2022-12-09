import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pages.Login;

import java.util.concurrent.TimeUnit;

public class StepDefinitions {
    public WebDriver driver;

    @Given("User visited to the ecommerce site")
    public void user_visited_to_the_ecommerce_site() {
        System.setProperty("webdriver.gecko.driver", "./src/test/resources/geckodriver.exe");
        driver=new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://automationpractice.com");
    }

    @When("User inputs valid {string} and {string}")
    public void user_inputs_valid_username_and_password(String email,String password) {
        Login login=new Login(driver);
        //login.doLogin("salman@test.com","P@ssword123");
        login.doLogin(email, password);
    }

    @Then("User can logged in successfully")
    public void user_can_logged_in_successfully() {
        driver.findElement(By.xpath("//a[@class='logout']")).click();
        driver.close();
    }
}
