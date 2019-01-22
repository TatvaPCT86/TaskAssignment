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

public class OpenBrowserURL {
	
	
	public static void main(String[] args) 
	{
		try 
		{

			WebDriver driver= null;
			DesiredCapabilities capabilities = null;
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
						
			System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");
			capabilities = DesiredCapabilities.chrome();
			capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
			try 
			{
				driver = new RemoteWebDriver(new URL("http://127.0.0.1:4444/wd/hub"), capabilities);

			} catch (MalformedURLException e) 
			{
				e.printStackTrace();
			}
			//Open URL https://the-internet.herokuapp.com
			System.out.println("Enter Application URL: ");
			//String url = ;
			driver.get(reader.readLine());
			
			System.out.println("1. Application URL open Successfully.");
			
		} 
		catch (Exception e) 
		{
			System.out.println("Error Found: "+e.getMessage());
		}

	}

}
