package amazon_Project1.Project1_Amazon;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

public class LoginandQuitS {
	WebDriver driver;

	@BeforeMethod
	public void launchbrowser() {
		String browser = "chrome";
		launchbrowser(browser);
	}

	// @Parameters("browser")
	// @BeforeMethod
	public void launchbrowser(String browsername) {
		EdgeOptions edgeOpt = new EdgeOptions();
		// edgeOpt.addArguments("--headless");
		ChromeOptions chromeOpt = new ChromeOptions();
		// chromeOpt.addArguments("--headless=new");

		if (browsername.equals("chrome")) {
			driver = new ChromeDriver(chromeOpt);

		} else if (browsername.equals("Edge")) {
			driver = new EdgeDriver(edgeOpt);

		}

		driver.get("https://www.amazon.in");
		driver.manage().window().maximize();
		driver.navigate().refresh();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

	}

	@AfterMethod
	public void quit() {

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// driver.quit();
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
