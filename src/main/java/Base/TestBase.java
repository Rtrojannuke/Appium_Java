package Base;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;

public class TestBase {
	public String projectpath = System.getProperty("user.dir");
    public String path = projectpath + "/src/main/resources/OR.properties";
    public AppiumDriver<MobileElement> driver;
    DesiredCapabilities caps = new DesiredCapabilities();
    public Properties OR = new Properties();
    FileInputStream read;

   

   @BeforeSuite
    public void setup() throws IOException {

        // DEVICE SETTINGS
        caps.setCapability("DeviceName", "Nokia 5.1");
        caps.setCapability("udid", "CO2ID18092100019");
        caps.setCapability("platformName", "Android");
        caps.setCapability("platformVersion", "9.0");
        
        // APP CAPABILITIES
        caps.setCapability(MobileCapabilityType.APP, "com.hc_hub/.MainActivity");

        caps.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.hc_hub");

        caps.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.hc_hub.MainActivity");
        
     // APPIUM SERVER SETTINGS
        URL link =  new URL("http://localhost:4723/wd/hub");
        driver = new AppiumDriver<MobileElement>(link,caps);
        
 if (driver==null) {
  			
  			try {
  				read = new FileInputStream (System.getProperty(path));
  			} catch (FileNotFoundException e) {
  				// TODO Auto-generated catch block
  				e.printStackTrace();
  			}
  			try {
  				OR.load(read);
  			} catch (IOException e) {
  				// TODO Auto-generated catch block
  				e.printStackTrace();
  			}
  			
  			
  		}
        

    }  
   
   @AfterSuite
   public void Down()  {

       driver.quit();

       System.out.println("Report URL: "+ driver.getCapabilities().getCapability("reportUrl"));

   }



        }