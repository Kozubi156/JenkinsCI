package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NestedFramePage {

  private WebDriver driver;
  public String topFrame = "frame-top";
  public String leftFrame = "frame-left";
  public String bottomFrame = "frame-bottom";
  public By leftFrameBody = By.tagName("body");

  public NestedFramePage(WebDriver driver) {
    this.driver = driver;
  }

  private void switchToFrame(String frameId) {
    driver.switchTo().frame(frameId);
  }

  private void switchToParentPage() {
    driver.switchTo().parentFrame();
  }

  public String getLeftTopFrameText(String parentFrameId, String childFrameId) {
    switchToFrame(parentFrameId);
    switchToFrame(childFrameId);
    String textInFrame = driver.findElement(leftFrameBody).getText();
    switchToParentPage();
    switchToParentPage();
    return textInFrame;
  }

  public String getBottomFrameText(String FrameId) {
    switchToFrame(FrameId);
    String textInFrame = driver.findElement(leftFrameBody).getText();
    switchToParentPage();
    return textInFrame;
  }


}
