package com.stepDefinition;

import static org.junit.Assert.assertEquals;

import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LoginPage;

public class Test_Steps {
    public static WebDriver driver ;
    LoginPage lgnPg;
	  public String expectedOutput = "Hello vasuvespag!";

	@Given("User is on HotelApp homepage")
	public void user_is_on_hotel_app_homepage() {
	    // Write code here that turns the phrase above into concrete actions
		 System.setProperty("webdriver.chrome.driver", "C:\\Mukesh\\drivers\\chromedriver_102win32\\chromedriver.exe");
		 driver = new ChromeDriver();
  
		 driver.get("http://adactinhotelapp.com");
	       driver.manage().window().maximize();		
			lgnPg = new LoginPage(driver);
			System.out.println("Inside hotel app homepage");
}

	@When("User enters Username")
	public void user_enters_username() {
	    // Write code here that turns the phrase above into concrete actions
		
//	       WebElement uname = driver.findElement(By.id("username"));
//	       uname.clear();
//	       uname.sendKeys("vasuvespag");
		lgnPg.enterUsername("vasuvespag");
		System.out.println("User enters username");

	}

	@When("User enters Password")
	public void user_enters_password() {
	    // Write code here that turns the phrase above into concrete actions
//		 driver.findElement(By.name("password")).clear();
//	       driver.findElement(By.name("password")).sendKeys("vasu1234");	
		lgnPg.enterPassword("vasu1234");
		}

	@When("User clicks on Login Button")
	public void user_clicks_on_login_button() {
	    // Write code here that turns the phrase above into concrete actions
	       lgnPg.clickLgnBtn();
	}

	@Then("Login is Successful")
	public void login_is_successful() {
	    // Write code here that turns the phrase above into concrete actions
		WebElement Greeting = driver.findElement(By.name("username_show"));
	    String actualOutput = Greeting.getAttribute("value");
	    assertEquals(expectedOutput, actualOutput);	}

	
	
	@When("User selects location from the dropdown")
	public void user_selects_location_from_the_dropdown() {
	    // Write code here that turns the phrase above into concrete actions
	       new Select(driver.findElement(By.cssSelector("#location"))).selectByIndex(1);
	}

	@When("User clicks on search button")
	public void user_clicks_on_search_button() {
	    // Write code here that turns the phrase above into concrete actions
	       driver.findElement(By.className("reg_button")).click();
	}

	@Then("List of hotels is displayed")
	public void list_of_hotels_is_displayed() {
	    // Write code here that turns the phrase above into concrete actions
		String expectedTitle = "Adactin.com - Select Hotel";
		String actualTitle = driver.getTitle();
		assertEquals(expectedTitle,actualTitle);
	}
	

@When("User selects a radio button")
public void user_selects_a_radio_button() {
    // Write code here that turns the phrase above into concrete actions
    driver.findElement(By.xpath("//*[@id=\"radiobutton_1\"]")).click();
}

@When("User clicks on continue button")
public void user_clicks_on_continue_button() {
    // Write code here that turns the phrase above into concrete actions
    driver.findElement(By.className("reg_button")).click();
}

@Then("Book a  hotel is displayed")
public void book_a_hotel_is_displayed() {
    // Write code here that turns the phrase above into concrete actions
	String expectedTitle = "Adactin.com - Book A Hotel";
	String actualTitle = driver.getTitle();
	assertEquals(expectedTitle,actualTitle);
}

@When("User enters username {string}")
public void user_enters_username_(String string) {
    // Write code here that turns the phrase above into concrete actions
	  WebElement uname = driver.findElement(By.id("username"));
    uname.clear();
     uname.sendKeys(string);}

@When("User enters password {string}")
public void user_enters_password_(String string) {
//    // Write code here that turns the phrase above into concrete actions
	 driver.findElement(By.name("password")).clear();
     driver.findElement(By.name("password")).sendKeys(string);}


@When("User enters Username as <{string}>")
public void user_enters_username_as(String string) {
    // Write code here that turns the phrase above into concrete actions
	 WebElement uname = driver.findElement(By.id("username"));
  uname.clear();
   uname.sendKeys(string);}

@When("User enters Password as <{string}>")
public void user_enters_password_as(String string) {
    // Write code here that turns the phrase above into concrete actions
	 driver.findElement(By.name("password")).clear();
   driver.findElement(By.name("password")).sendKeys(string);}
@When("User enters Username and Password")
public void user_enters_username_and_password(io.cucumber.datatable.DataTable userCredentials) {
    // Write code here that turns the phrase above into concrete actions
    // For automatic transformation, change DataTable to one of
    // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
    // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
    // Double, Byte, Short, Long, BigInteger or BigDecimal.
    //
    // For other transformations you can register a DataTableType.
//	List<List<String>> data = userCredentials.asLists(String.class);
//	String userName = data.get(0).get(0);
//	String password = data.get(0).get(1);
//	WebElement uname = driver.findElement(By.id("username"));
//    uname.clear();
//    uname.sendKeys(userName);
//    driver.findElement(By.name("password")).clear();
//    driver.findElement(By.name("password")).sendKeys(password);
	List<Map<String,String>> data = userCredentials.asMaps(String.class,String.class);
	for(Map<String,String> data1:data) {
		String userName = data1.get("username");
		WebElement uname = driver.findElement(By.id("username"));
    uname.clear();
    uname.sendKeys(userName);
   
		String password = data1.get("password");
		 driver.findElement(By.name("password")).clear();
	    driver.findElement(By.name("password")).sendKeys(password);
	}
}

}
