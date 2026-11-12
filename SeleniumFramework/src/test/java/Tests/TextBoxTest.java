package Tests;

import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Baseclass.BaseTest;
import PomRepo.ElementsPage;
import PomRepo.TextBoxPage;

public class TextBoxTest extends BaseTest {
	
	
ElementsPage ep;
TextBoxPage tp;
	
	@Parameters({"browser","env"})
	@BeforeClass
	public void initialize(String browser,String env) throws IOException
	{
		setUp(browser,env);
		ep=new ElementsPage(driver);
		tp=new TextBoxPage(driver);
	}
	
	@Test
	public void validateTextBox() {
		ep.clickOnElementTab();
		ep.clickOntextBox();
		tp.entername("govind");
		tp.enterEmail("govind@gmail.com");
	}

}
