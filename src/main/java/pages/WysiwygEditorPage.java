package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WysiwygEditorPage {

  private WebDriver driver;
  private String editorIframeId = "mce_0_ifr";
  private By textArea = By.id("tinymce");
  private By increaseIndentButton = By.cssSelector("button[title='Increase indent']");

  public WysiwygEditorPage(WebDriver driver) {
    this.driver = driver;
  }

  public void celearTextArea(){
    switchToEditArea();
    driver.findElement(textArea).clear();
    switchToMainPage();
  }

  public void setTextArea(String text){
    switchToEditArea();
    driver.findElement(textArea).sendKeys(text);
    switchToMainPage();
  }

  public String getTextFromEditor(){
    switchToEditArea();
    String textFromEditor = driver.findElement(textArea).getText();
    switchToMainPage();
    return textFromEditor;
  }

  public void increaseIndent(){
    driver.findElement(increaseIndentButton).click();
  }

  private void switchToEditArea(){
    driver.switchTo().frame(editorIframeId);
  }

  private void switchToMainPage(){
    driver.switchTo().parentFrame();
  }

}
