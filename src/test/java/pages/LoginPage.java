package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(id="username")
	private WebElement uName;
	
	
	@FindAll({
		@FindBy(id="password"),
		@FindBy(name="password")
	})
	private WebElement pwd;
	
	@FindAll({
		@FindBy(id="login"),
		@FindBy(className="button"),
		@FindBy(name="login_button")
	})
	private WebElement loginBtn;
	public void enterUsername(String user) {
		uName.sendKeys(user);
	}
	
	public void enterPassword(String pass) {
		pwd.sendKeys(pass);
	}
	public void clickLgnBtn() {
		loginBtn.click();
	}

}
