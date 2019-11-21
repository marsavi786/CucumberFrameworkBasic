package CucumberFramework.steps;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.*;

public class Login {
	
	WebDriver driver;
	
	@Before
	public void setup(){
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\ARVIND\\Desktop\\Cucumber_Framework\\CucumberFramework\\src\\test\\java\\CucumberFramework\\resources\\chromedriver.exe");
		this.driver = new ChromeDriver();
		this.driver.manage().window().maximize();
		this.driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		this.driver.manage().timeouts().setScriptTimeout(60, TimeUnit.SECONDS);
		
	}
	
	@After
	public void tearDown() throws InterruptedException{
		Thread.sleep(2000);
		this.driver.manage().deleteAllCookies();
		this.driver.quit();
		this.driver = null;
	}
	
	@Given("^User navigates to flight ticket booking website$")
	public void user_navigates_to_flight_ticket_booking_website() throws Throwable {
	     driver.get("http://newtours.demoaut.com/");

	}

	@And("^User clicks on the sign-on link$")
	public void user_clicks_on_the_sign_on_link() throws Throwable {
		Thread.sleep(2000);
		 driver.findElement(By.xpath("//a[contains(.,'SIGN-ON')]")).click();
	}

	@And("^User enters a valid username$")
	public void user_enters_a_valid_username() throws Throwable {
		 Thread.sleep(2000);
		 driver.findElement(By.xpath("//input[contains(@name,'userName')]")).sendKeys("mercury");
	}

	@And("^User enters a valid password$")
	public void user_enters_a_valid_password() throws Throwable {
          Thread.sleep(2000);
          driver.findElement(By.xpath("//input[@name='password']")).sendKeys("mercury");
	}

	@When("^User clicks on the login button$")
	public void user_clicks_on_the_login_button() throws Throwable {
		 Thread.sleep(2000);
		 driver.findElement(By.xpath("//input[contains(@name,'login')]")).click();
	}

	@Then("^User should be taken to the successful login page$")
	public void user_should_be_taken_to_the_successful_login_page() throws Throwable {
         Thread.sleep(3000);
         WebElement cont = driver.findElement(By.xpath("//input[contains(@name,'findFlights')]"));
         Assert.assertEquals(true, cont.isDisplayed());
 
	}



}
