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

public class Project1_Google {
	AppiumDriver<MobileElement> driver = null;
  
  @BeforeClass
  public void beforeClass() throws MalformedURLException {
	//set desired Capability
	  DesiredCapabilities caps = new DesiredCapabilities();
	  caps.setCapability("deviceId", "d22ad3957ce5");
	  caps.setCapability("platformName", "Android");
	  caps.setCapability("appPackage", "com.google.android.apps.tasks");
	  caps.setCapability("appActivity", ".ui.TaskListsActivity");
	  caps.setCapability("noReset", true);
	  
	  // Instantiate Appium Driver
      URL appServer = new URL("http://0.0.0.0:4723/wd/hub");
      driver = new AndroidDriver<MobileElement>(appServer, caps);
  }
  
  @Test
  public void mainTest() throws InterruptedException {
	  Thread.sleep(5000);
	  driver.findElementById("tasks_fab").click();
	  Thread.sleep(3000);
	  driver.findElementByXPath("//android.widget.ScrollView/android.widget.LinearLayout/android.widget.EditText").sendKeys("Complete Activity with Google Tasks");
	  driver.findElementById("add_task_done").click();
	  String text = driver.findElementByXPath("//android.widget.LinearLayout/android.widget.TextView").getText();
	  System.out.println(text);
	  Assert.assertEquals(text, "Complete Activity with Google Tasks");
	  Thread.sleep(3000);
	  driver.findElementById("tasks_fab").click();
	  Thread.sleep(5000);
	  //driver.findElementByXPath("//android.widget.FrameLayout/android.view.ViewGroup/android.support.v7.widget.RecyclerView").click();
	  driver.findElementByXPath("//android.widget.ScrollView/android.widget.LinearLayout/android.widget.EditText").sendKeys("Complete Activity with Google Keep");
	  driver.findElementById("add_task_done").click();
	  Thread.sleep(3000);
	  String text2 = driver.findElementByXPath("//android.widget.LinearLayout/android.widget.TextView").getText();
	  System.out.println(text2);
	  Assert.assertEquals(text2, "Complete Activity with Google Keep");
	  Thread.sleep(3000);
	  driver.findElementById("tasks_fab").click();
	  Thread.sleep(3000);
	  driver.findElementByXPath("//android.widget.ScrollView/android.widget.LinearLayout/android.widget.EditText").sendKeys("Complete the second Activity Google Keep");
	  driver.findElementById("add_task_done").click();
	  Thread.sleep(3000);
	  String text3 = driver.findElementByXPath("//android.widget.LinearLayout/android.widget.TextView").getText();
	  System.out.println(text3);
	  Assert.assertEquals(text3, "Complete the second Activity Google Keep");
  }

  @AfterClass
  public void afterClass() {
	  driver.quit();
  }

}
