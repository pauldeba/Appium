/**Goal: Opening a page on the browser and testing a simple login page with correct and incorrect credentials
a. Open the Chrome app on your device.
b. Go to the following URL: https://www.training-support.net/selenium
c. Scroll to find the Login Form card and click it.
d. Once the page loads, find the username and password input fields on the page and enter the following credentials in it:
e. Username: admin
f. Password: password
g. Click on the Log in button to submit.
h. If the credentials are correct, the following message should appear:

i. If the credentials are incorrect, the following message appears:

j. Write a test case for each scenario - One with the correct credentials and one with incorrect credentials
k. Finally, write assertions for both test cases to verify results.
***************************/

package AppiumTesting;

import org.testng.annotations.Test;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import junit.framework.Assert;

import org.testng.annotations.BeforeClass;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;

public class Project2_Chrome {
  AndroidDriver<MobileElement> driver = null;
  @BeforeClass
  public void beforeClass() throws MalformedURLException {
	  DesiredCapabilities cap = new DesiredCapabilities();
	  cap.setCapability("deviceId", "emulator-5554");
	  cap.setCapability("platformName", "Android");
	  cap.setCapability("appPackage", "com.android.chrome");
	  cap.setCapability("appActivity", "com.google.android.apps.chrome.Main");
	  cap.setCapability("noReset", true);
	  driver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"),cap);
  }
  
  @Test
  public void mainTestInvalid() throws InterruptedException {
	  driver.manage().timeouts().implicitlyWait(600, TimeUnit.SECONDS);
	  driver.get("https://www.training-support.net/selenium");
	  driver.findElement(MobileBy.AndroidUIAutomator("UiScrollable(UiSelector().scrollable(true)).scrollIntoView(text(\"Login Form\"))")).click();
      driver.findElementByXPath("//android.view.View[3]/android.view.View/android.view.View/android.widget.EditText[1]").sendKeys("admin");
	  driver.findElementByXPath("//android.view.View[3]/android.view.View/android.view.View/android.widget.EditText[2]").sendKeys("passwor");
	  MobileElement bu1 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.widget.FrameLayout[2]/android.webkit.WebView/android.view.View/android.view.View[3]/android.view.View/android.view.View/android.widget.Button");
	  bu1.click();
	  Thread.sleep(3000);
	  MobileElement tl1 = (MobileElement) driver.findElementByXPath("//android.widget.FrameLayout[1]/android.widget.FrameLayout[2]/android.webkit.WebView/android.view.View/android.view.View[3]");
	  String text1 = tl1.getText();
	  System.out.println(text1);
	  Assert.assertEquals(text1, "Invalid Credentials");
  }
  
  @Test
  public void mainTestValid() throws InterruptedException {
	  driver.manage().timeouts().implicitlyWait(600, TimeUnit.SECONDS);
	  driver.get("https://www.training-support.net/selenium");
	  driver.findElement(MobileBy.AndroidUIAutomator("UiScrollable(UiSelector().scrollable(true)).scrollIntoView(text(\"Login Form\"))")).click();
	  driver.findElementByXPath("//android.view.View[3]/android.view.View/android.view.View/android.widget.EditText[1]").sendKeys("admin");
	  driver.findElementByXPath("//android.view.View[3]/android.view.View/android.view.View/android.widget.EditText[2]").sendKeys("password");
	  MobileElement bu1 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.widget.FrameLayout[2]/android.webkit.WebView/android.view.View/android.view.View[3]/android.view.View/android.view.View/android.widget.Button");
	  bu1.click();
	  Thread.sleep(3000);
	  MobileElement tl1 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.widget.FrameLayout[2]/android.webkit.WebView/android.view.View/android.view.View[3]");
	  String text1 = tl1.getText();
	  System.out.println(text1);
	  Assert.assertEquals(text1, "Welcome Back, admin");
  }

  @AfterClass
  public void afterClass() {
	  driver.quit();
  }

}
