package alerts;

import base.BaseTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class AlertTest extends BaseTest {

  @Test
  public void testAcceptAlert(){
    var alertsPage = homePage.clickJavaScriptAlerts();
    alertsPage.triggerAlertPopUp();
    alertsPage.alertClickToAccept();
    alertsPage.getResultsText();
    assertEquals(alertsPage.getResultsText(), "You successfully clicked an alert","Result text is incorrect");
  }

  @Test
  public void testGetTextFromAlert(){
    var alertsPage = homePage.clickJavaScriptAlerts();
    alertsPage.triggerConfirmedPopUp();
    String textOfAlert = alertsPage.alertGetText();
    alertsPage.alertClickToDismiss();
    assertEquals(textOfAlert, "I am a JS Confirm","Alert text is incorrect");
    assertEquals(alertsPage.getResultsText(), "You clicked: Cancel","Result text is incorrect");
  }

  @Test
  public void testSetInputInAlert(){
    var alertsPage = homePage.clickJavaScriptAlerts();
    alertsPage.triggerPromptPopUp();
    String text = "test text";
    alertsPage.alertSetInput(text);
    alertsPage.alertClickToAccept();
    assertEquals(alertsPage.getResultsText(), "You entered: " + text,"Result text is incorrect");
  }
}
