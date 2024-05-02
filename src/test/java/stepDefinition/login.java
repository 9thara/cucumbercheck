package stepDefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class login {
	
	WebDriver driver;
	
	@Given("Application is laucnhed")
	public void launchApplication() {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("https://onlinetestinghelp.com/projects/banking/");
	}
	
	@When("^User enters the (.*)$")
	public void userenteruserID(String uderid) {
		driver.findElement(By.name("email")).sendKeys(uderid);
	}
	
	@When("User enter the wrong password")
	public void userenterPassword() {
		driver.findElement(By.name("password")).sendKeys("admin");
	}
	
	@When("User click the submit button")
	public void clickssubmitButton() throws InterruptedException {
		Thread.sleep(4000);
		driver.findElement(By.xpath("//*[cotnains(text(),'Login')]")).click();
	}
	
	@Then("User will be navigated to the home page")
	public void verifyHomePageisDisplayed() {
		if(driver.findElements(By.xpath("//i[contains(text(),'Incorrect email or password')]")).size()>0){
			System.out.println("Error message is displayed");
		}
	}
	   
	  
	  

}
