/**Goal: Opening a page on the browser and testing a to-do list page
a. Open the Chrome app on your device.
b. Go to the following URL: https://www.training-support.net/selenium
c. Scroll to find the To-Do List card and click it.
d. Once the page loads, find the input field on the page and enter the following three tasks:
e. Add tasks to list
f. Get number of tasks
g. Clear the list
h. Click on each of the tasks added to strike them out.
i. Finally, clear the list.
j. Add assertions to verify that the test has passed or failed.
 */
package AppiumTesting;

import org.testng.annotations.Test;

import com.sun.tools.sjavac.Log;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import junit.framework.Assert;

import org.testng.annotations.BeforeClass;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;

public class Project1_Chrome {
	AndroidDriver<MobileElement> driver = null;
	WebDriverWait wait;
	
  @BeforeClass
  public void beforeClass() throws MalformedURLException {
	  DesiredCapabilities caps = new DesiredCapabilities();
	  caps.setCapability("deviceId", "emulator-5554");
	  caps.setCapability("platformName", "Android");
	  caps.setCapability("appPackage", "com.android.chrome");
	  caps.setCapability("appActivity","com.google.android.apps.chrome.Main");
	  caps.setCapability("noReset", true);
	  // Instantiate Appium Driver
      driver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), caps);
      wait = new WebDriverWait(driver, 600);
  }
  
  @Test
  public void mainTest() throws InterruptedException {
	  driver.manage().timeouts().implicitlyWait(600, TimeUnit.SECONDS);
	  
      driver.get("https://www.training-support.net/selenium");
      Thread.sleep(3000);
            
      //driver.findElement(MobileBy.AndroidUIAutomator("UiScrollable(UiSelector().scrollable(true)).scorllTextIntoView(\"To-Do List\")")).click();
      //driver.findElement(MobileBy.AndroidUIAutomator("UiScrollable(UiSelector().scrollForward().scrollable(true).instance(0)).scrollIntoView(text(\"Tab Opener\"))"));
      
      driver.findElement(MobileBy.AndroidUIAutomator("UiScrollable(UiSelector().scrollable(true)).scrollIntoView(text(\"To-Do List\"))")).click();;
      Thread.sleep(5000);
      
      MobileElement el1 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.view.View");
      el1.click();
      Thread.sleep(5000);
      MobileElement el2 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.widget.FrameLayout[2]/android.webkit.WebView/android.view.View/android.view.View[3]/android.view.View[1]/android.widget.EditText");
      el2.click();
      el2.sendKeys("Add tasks to list");
      
      MobileElement bu1 = (MobileElement) driver.findElementByXPath("//android.widget.FrameLayout[2]/android.webkit.WebView/android.view.View/android.view.View[3]/android.view.View[1]/android.widget.Button");
      bu1.click();
      Thread.sleep(3000);
      el2.click();
      el2.sendKeys("Get number of tasks");
      bu1.click();
      
      Thread.sleep(3000);
      el2.click();
      el2.sendKeys("Clear the list");
      bu1.click();
      
      driver.findElementByXPath("//android.view.View/android.view.View[3]/android.view.View[2]/android.view.View[2]").click();
      driver.findElementByXPath("//android.view.View/android.view.View[3]/android.view.View[2]/android.view.View[3]").click();
      driver.findElementByXPath("//android.view.View/android.view.View[3]/android.view.View[2]/android.view.View[4]").click();
      
      MobileElement bu2 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.widget.FrameLayout[2]/android.webkit.WebView/android.view.View/android.view.View[3]/android.view.View[3]/android.widget.TextView");
      bu2.click();
      
      String text = bu2.getText();
      Assert.assertEquals(" Clear List",text);
      
      String text2 = driver.findElementByXPath("//android.widget.FrameLayout[2]/android.webkit.WebView/android.view.View/android.widget.TextView").getText();
      Assert.assertEquals("To-Do List", text2);
      //System.out.println("Test is passed");
      
      
  }

  @AfterClass
  public void afterClass() {
	  driver.quit();
  }

}
