/** Goal: Use the Google Keep app to add a note.
a. Open the Google Keep app.
b. Click the Create New Note button to add a new Note.
c. Add a title for the note and add a small description.
d. Press the back button and make an assertion to ensure that the note was added
 */
package AppiumTesting;

import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import junit.framework.Assert;

import org.testng.annotations.BeforeClass;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;

public class Project2_Google {
	AppiumDriver<MobileElement> driver = null;
  @BeforeClass
  public void beforeClass() throws MalformedURLException {
	//set desired Capability
	  DesiredCapabilities caps = new DesiredCapabilities();
	  caps.setCapability("deviceId", "d22ad3957ce5");
	  caps.setCapability("platformName", "Android");
	  caps.setCapability("appPackage", "com.google.android.keep");
	  caps.setCapability("appActivity", ".activities.BrowseActivity");
	  caps.setCapability("noReset", true);
	  
	  // Instantiate Appium Driver
      URL appServer = new URL("http://0.0.0.0:4723/wd/hub");
      driver = new AndroidDriver<MobileElement>(appServer, caps);
  }
  
  @Test
  public void mainTest() throws InterruptedException {
	  Thread.sleep(3000);
	  driver.findElementById("new_note_button").click();
	  Thread.sleep(5000);
	  driver.findElementByXPath("//android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.EditText").sendKeys("New Title");
	  driver.findElementByXPath("//android.support.v7.widget.RecyclerView/android.widget.LinearLayout[1]/android.widget.FrameLayout/android.widget.EditText").sendKeys("Add Sample Note");
	  driver.findElementByXPath("//android.widget.ImageButton[@content-desc=\"Open navigation drawer\"]").click();
	  String title = driver.findElementByXPath("//android.widget.LinearLayout/android.widget.LinearLayout/android.widget.TextView[1]").getText();
	  System.out.println(title);
	  Assert.assertEquals(title, "New Title");
  }

  @AfterClass
  public void afterClass() {
	  driver.quit();
  }

}
