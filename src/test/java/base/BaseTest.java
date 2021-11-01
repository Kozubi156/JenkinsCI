package base;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.HomePage;
import utils.EventReporter;
import utils.WindowManager;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;


public class BaseTest {

  public HomePage homePage;
  private WebDriver driver;
  static final String APP_URL = "https://the-internet.herokuapp.com/";
  static final String HOST_URL = "http://localhost:4444/wd/hub";

  @BeforeClass
  public void setUp() {
//    System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
////    driver = new EventFiringWebDriver(new ChromeDriver(getChromeOptions()));
////    driver.register(new EventReporter());
//    try {
//      driver = new RemoteWebDriver(new URL(APP_URL), getChromeOptions());
//    } catch (MalformedURLException e) {
//      e.printStackTrace();
//    }
    driver = new ChromeDriver();
    goHomePage();

//    setCookie();
  }

  @BeforeMethod
  public void goHomePage() {driver.get(APP_URL);
  homePage = new HomePage(driver);
};


  @AfterMethod
  public void recordFailure(ITestResult result){
    if(ITestResult.FAILURE == result.getStatus())
    {
      var camera = (TakesScreenshot)driver;
      File screenshot = camera.getScreenshotAs(OutputType.FILE);
      try{
        com.google.common.io.Files.move(screenshot, new File("resources/screenshots/" + result.getName() + ".png"));
      }catch(IOException e){
        e.printStackTrace();
      }
    }
  }

  @AfterClass
  public void tearDown() {
    driver.quit();
  }

  public WindowManager getWindowManager(){
    return new WindowManager(driver);
  }

  private ChromeOptions getChromeOptions(){
    ChromeOptions options = new ChromeOptions();
//    options.addArguments("disable-infobars");
    //options.setHeadless(true);
    return options;
  }

  private void setCookie(){
    Cookie cookie = new Cookie.Builder("tau","123").domain("https://the-internet.herokuapp.com").build();
    driver.manage().addCookie(cookie);
  }
}
