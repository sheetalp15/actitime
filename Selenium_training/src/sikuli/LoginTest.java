package sikuli;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import org.sikuli.script.SikuliException;

public class LoginTest {

	public static void main(String[] args) throws SikuliException 
	{
        System.out.println("welcome");
        System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://localhost/login.do");
        Screen s1 = new Screen();
        Pattern unm = new Pattern("C:\\selenium\\Eclipse_WS\\Selenium_training\\Sikuli_Images\\unm.JPG");
        Pattern pwd = new Pattern("C:\\selenium\\Eclipse_WS\\Selenium_training\\Sikuli_Images\\pwd.JPG");
        Pattern login = new Pattern("C:\\selenium\\Eclipse_WS\\Selenium_training\\Sikuli_Images\\login.JPG");
        s1.type(unm, "admin");
        s1.type(pwd, "manager");
        s1.click(login);}
}
