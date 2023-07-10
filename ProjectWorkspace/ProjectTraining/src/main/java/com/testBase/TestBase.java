package com.testBase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class TestBase {
	
	public static WebDriver driver;
	public static Properties configProp;

	public TestBase() {
		// Reading Config File.
		try {
			configProp = new Properties();
			FileInputStream readConfigLoc = new FileInputStream(
					"C:\\Users\\Ranjima\\Desktop\\Repository Project\\TechmindzFebruary\\ProjectWorkspace\\ProjectTraining\\src\\main\\java\\com\\config\\config");
			configProp.load(readConfigLoc);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}
	
	

	// Initializing web browser
	@SuppressWarnings("deprecation")
	public static void initialization() {
		String browserName = configProp.getProperty("browser");

		if (browserName.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (browserName.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.get(configProp.getProperty("URL"));

	}
}

