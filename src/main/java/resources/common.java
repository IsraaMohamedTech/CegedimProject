package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class common {
	public WebDriver driver;
	public Properties prop;

	public WebDriver initializeDriver() throws IOException {
		prop = new Properties();
		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\main\\java\\resources\\data.properties");
		prop.load(fis);
		String browserName = prop.getProperty("browser");
		if (browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
	}

	public ExtentReports getExtendReport() {
		String path = System.getProperty("user.dir") + "\\reports\\index.html";
		ExtentHtmlReporter sparkReporter = new ExtentHtmlReporter(path);
		ExtentReports report = new ExtentReports();
		report.attachReporter(sparkReporter);
		report.setSystemInfo("Tester", "Israa Mohamed");
		return report;
	}

	public String getSuccessScreenShot(String testCaseName, WebDriver driver) throws IOException {
		TakesScreenshot takeScreenShot = (TakesScreenshot) driver;
		File src = takeScreenShot.getScreenshotAs(OutputType.FILE);
		String destnation = System.getProperty("user.dir") + "\\reports2\\success\\" + testCaseName + ".png";
		FileUtils.copyFile(src, new File(destnation));
		return destnation;
	}

	public String getFaliureScreenShotPath(String testCaseNmae, WebDriver driver) throws IOException {
		TakesScreenshot takeScreen = (TakesScreenshot) driver;
		File src = takeScreen.getScreenshotAs(OutputType.FILE);
		String desFile = System.getProperty("user.dir") + "\\reports\\failed" + testCaseNmae + ".png";
		FileUtils.copyFile(src, new File(desFile));
		return desFile;
	}

}
