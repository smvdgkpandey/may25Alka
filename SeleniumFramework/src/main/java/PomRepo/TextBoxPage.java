package PomRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Baseclass.BaseTest;

public class TextBoxPage extends BaseTest {
	
	
	WebDriver driver;
	public TextBoxPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(id="fullname1")
	private WebElement fullnameText;
	
	@FindBy(id="fullemail1")
	private WebElement emeilText;
	
	
	public void entername(String name) {
		enterValue(fullnameText, name);
	}
	
	public void enterEmail(String email) {
		enterValue(emeilText, email);
	}

}
