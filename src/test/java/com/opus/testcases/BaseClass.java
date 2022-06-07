package com.opus.testcases;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.opus.utilities.ReadConfig;

public class BaseClass {
	// Create ReadConfig class object
	ReadConfig readconfig = new ReadConfig();
	public String baseURL = readconfig.getApplication();
	public String username = readconfig.getUsername();
	public String password = readconfig.getPassword();
	
	// Opus Admin Login Details:
	public String OPUSUrl = readconfig.getOpusApplication();
	public String adminUsername = readconfig.getAdminUsername();
	public String adminPassword = readconfig.getAdminPassword();
	
	// Opus Vendor Login Details:
	public String vendorUsername = readconfig.getVendorUsername();
	public String vendorPassword = readconfig.getVendorPassword();

	// iBridge Cat Login Details
	public String catRoleUsername = readconfig.getSuperUserCatUsername();
	public String catRolePassword = readconfig.getSuperUserCatPassword();
	
	public static WebDriver driver;
	public static Logger logger;
	
	@Parameters("browser")
	@BeforeClass
	public void setup(String br) {
		logger = Logger.getLogger("Opus"); // import right package Apache POI logger
		PropertyConfigurator.configure(System.getProperty("user.dir") + "/log4j.properties");
		// PropertyConfigurator.configure("log4j.properties");

		if (br.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", readconfig.getChromePath());
			driver = new ChromeDriver();
			//driver = new ChromeDriver(new ChromeOptions().setHeadless(true));
			
		} else if (br.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", readconfig.getFirefoxPath());
			driver = new FirefoxDriver();
		} else if (br.equals("ie")) {
			System.setProperty("webdriver.ie.driver", readconfig.getIePath());
			driver = new InternetExplorerDriver();
		}
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(baseURL);// it is copy to TestCase_001
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
		// driver.close();
	}
	// If you want to catch failed test cases you will have to add "captureScreen"
	// method.

	public void captureScreen(WebDriver driver, String tname) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir") + "/Screenshots/" + tname + ".png");
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot taken");
	}
}
