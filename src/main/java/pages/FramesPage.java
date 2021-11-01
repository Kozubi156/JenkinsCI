package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FramesPage {

  private WebDriver driver;
  private By linkToNestedFrames = By.linkText("Nested Frames");

  public FramesPage(WebDriver driver) {
    this.driver = driver;
  }

  public NestedFramePage clickLinkToNestedFrames(){
    driver.findElement(linkToNestedFrames).click();
    return new NestedFramePage(driver);
  }


}
