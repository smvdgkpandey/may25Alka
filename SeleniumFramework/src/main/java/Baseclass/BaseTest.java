package Baseclass;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utils.ExcelReader;
import Utils.PropertiesUtil;
import Utils.commonUtils;

public class BaseTest implements PropertiesUtil ,commonUtils,ExcelReader{

	//String qapath="C:\\Users\\HP\\eclipse-workspace\\SeleniumFramework\\src\\test\\resources\\ConfigData\\qa.properties";
	String configpath="C:\\Users\\HP\\eclipse-workspace\\SeleniumFramework\\src\\test\\resources\\ConfigData\\config.properties";
	
	protected WebDriver driver;
	WebDriverWait wait;
	public void setUp(String browser,String env) throws IOException {
		
		if(browser.equalsIgnoreCase("chrome")) {
			 driver=new ChromeDriver();
		}else if(browser.contentEquals("edge")) {
			 driver=new EdgeDriver();
		}
		if(env.equalsIgnoreCase("qa")) {
			driver.get(getDataFromProperty(configpath,"QAURL"));
		}else if(env.equalsIgnoreCase("uat")) {
			driver.get(getDataFromProperty(configpath,"UATURL"));
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	
	
public void tearDown() {
	driver.quit();
}
	
	

	
	
	
	
	public  String getDataFromProperty(String path, String key) throws IOException {
		FileInputStream fis=new FileInputStream(path);
		Properties p=new Properties();
		p.load(fis);
		return p.getProperty(key);
	}
	
	
	



	@Override
	public void clickEle(WebElement ele) {
		wait=new WebDriverWait(driver,Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(ele)).click();
		
	}



	@Override
	public void enterValue(WebElement ele, String value) {
		// TODO Auto-generated method stub
		wait=new WebDriverWait(driver,Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(ele)).sendKeys(value);
		
		
	}



	@Override
	public String readExcelData(String path, String sheet, int row, int col) throws IOException {
		FileInputStream fis=new FileInputStream(path);
		XSSFWorkbook wb=new XSSFWorkbook(fis);
		XSSFSheet sh =wb.getSheet(sheet);
		return sh.getRow(row).getCell(col).getStringCellValue();
	}

}
