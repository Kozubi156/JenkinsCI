package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AlertsPage {

  private WebDriver driver;
  private By triggerAlertButton = By.xpath(".//button[text()='Click for JS Alert']");
  private By triggerConfirmedButton = By.xpath(".//button[text()='Click for JS Confirm']");
  private By triggerPromptButton = By.xpath(".//button[text()='Click for JS Prompt']");
  private By resultsText = By.id("result");

  public AlertsPage(WebDriver driver) {
    this.driver = driver;
  }

  public void triggerAlertPopUp() {
    driver.findElement(triggerAlertButton).click();
  }

  public void triggerConfirmedPopUp() {
    driver.findElement(triggerConfirmedButton).click();
  }

  public void triggerPromptPopUp() {
    driver.findElement(triggerPromptButton).click();
  }

  public void alertClickToAccept() {
    driver.switchTo().alert().accept();
  }

  public String alertGetText(){
    return driver.switchTo().alert().getText();
  }

  public void alertClickToDismiss(){
    driver.switchTo().alert().dismiss();
  }

  public void alertSetInput(String text){
    driver.switchTo().alert().sendKeys(text);
  }

  public String getResultsText() {
    return driver.findElement(resultsText).getText();
  }
}
