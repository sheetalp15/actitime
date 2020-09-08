package grid;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class Grid1 {

	public static void main(String[] args) throws MalformedURLException {
		// TODO Auto-generated method stub
        String hub = "http://192.168.1.199:4444/wd/hub";
        String url =  "http://www.google.com";
        
        System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
        
        //ChromeOptions options = new ChromeOptions();
        DesiredCapabilities cap = DesiredCapabilities.chrome();
        //cap.setCapability(ChromeOptions.CAPABILITY,options);
        WebDriver driver = new RemoteWebDriver(new URL(hub),cap);
        
        driver.navigate().to(url);
        
        
	}

}
