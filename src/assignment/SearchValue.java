package assignment;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class SearchValue {

	static WebDriver driver = null;

	public static void openBrowser() {
		try {

			DesiredCapabilities capabilities = null;
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

			System.setProperty("webdriver.chrome.driver", "D:\\Automation_Projects\\drivers\\chromedriver.exe");
			capabilities = DesiredCapabilities.chrome();
			capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
			try {
				driver = new RemoteWebDriver(new URL("http://127.0.0.1:4444/wd/hub"), capabilities);

			} catch (MalformedURLException e) {
				e.printStackTrace();
			}
			// Open URL https://the-internet.herokuapp.com
			System.out.println("Enter Application URL: ");
			// String url = ;
			driver.get(reader.readLine());

			System.out.println("1. Application URL open Successfully.");

		} catch (Exception e) {
			System.out.println("Error Found: " + e.getMessage());
		}
	}

	public static void main(String[] args) {
		try {
			openBrowser();

			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Enter Search Value");
			String search= reader.readLine();

			List<WebElement> tableEle = driver.findElements(By.xpath("//*[@id=\"content\"]/ul"));
			boolean found = false;
			for (WebElement ulEle : tableEle) {
				List<WebElement> li = null;
				li = ulEle.findElements(By.tagName("li"));
				for (WebElement liElement : li) {
					if (liElement.getText().equalsIgnoreCase(search)) {
						List<WebElement> a = liElement.findElements(By.tagName("a"));
						for (WebElement aLink : a) {
							aLink.click();
							System.out.println("Value Search Successfully.");
							found = true;
							break;
						}
					} else {
						found= false;
					}
				}
			}
			if (found == true) {
				System.out.println("Search Funcationality working Successful. :" + search);
				driver.quit();
			} else {
				System.out.println("Value not Found" + search);
				driver.quit();
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
