package alerts;

import base.BaseTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class ContextMenuTest extends BaseTest {

  @Test
  public void testContextMenu() {
    var contextMenuPage = homePage.clickContextMenu();
    contextMenuPage.rightMouseClickOnContextMenuBox();
    String popMessage = contextMenuPage.contextGetText();
    contextMenuPage.contextMenuClickToAccept();
    assertEquals(popMessage, "You selected a context menu", "Context menu text is incorrect");
  }
}
