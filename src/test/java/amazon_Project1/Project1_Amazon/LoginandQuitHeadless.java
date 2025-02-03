package amazon_Project1.Project1_Amazon;

import java.time.Duration;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class LoginandQuitHeadless {
	WebDriver driver;

	/**
	 * @BeforeMethod public void launchbrowser() { String browser = "chrome"; launchbrowser(browser); }
	 */
	// Multiple
	@Parameters({ "browser", "options" })
	@BeforeMethod
	public void launchbrowser(@Optional String browsername, @Optional String options) {
		if (browsername.equals("Edge")) {
			EdgeOptions edgeOpt = new EdgeOptions();
			edgeOpt.addArguments(options);
			driver = new EdgeDriver(edgeOpt);

		} else if (browsername.equals("firefox")) {
			FirefoxOptions ffoptions = new FirefoxOptions();
			ffoptions.addArguments(options);
			driver = new FirefoxDriver(ffoptions);

		} else if (browsername.equals("chrome") || StringUtils.isEmpty(browsername)) {
			ChromeOptions coptions = new ChromeOptions();
			coptions.addArguments(options);
			driver = new ChromeDriver(coptions);
		}

		driver.get("https://www.amazon.in");
		driver.manage().window().maximize();
		driver.navigate().refresh();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

	}

	@AfterMethod
	public void quit() {

		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.quit();
	}

	@DataProvider(name = "usernamepass")
	public Object[][] userpassfromexcel() {

		Object[][] d = new Object[2][2];
		// username1and passsword
		d[0][0] = DataExcel.readExcel(0, 0);
		d[0][1] = DataExcel.readExcel(0, 1);
		// username2and passsword
		d[1][0] = DataExcel.readExcel(1, 0);
		d[1][1] = DataExcel.readExcel(1, 1);
		// usernamepassword3
		// d[2][0] = readExcel(2, 0);
		// d[2][1] = readExcel(2, 1);
		return d;
	}
}
