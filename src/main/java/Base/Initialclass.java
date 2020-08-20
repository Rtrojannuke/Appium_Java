package Base;
import org.testng.annotations.Test;
import io.appium.java_client.MobileElement;

public class Initialclass extends TestBase{
	
	@Test
public void launchscreen() {
		MobileElement skiptoLogin = (MobileElement) driver.findElementsByXPath(OR.getProperty("skipToLogin"));
		skiptoLogin.click();
		
		MobileElement logintoaccnt = driver.findElementByXPath(OR.getProperty("logintoaccnt"));
		logintoaccnt.click();
		
	}

}
