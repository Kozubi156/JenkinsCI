package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class HorizontalSliderPage {

  private WebDriver driver;
  private By horizontalSlider = By.cssSelector("input[type='range']");
  private By sliderValue = By.cssSelector("span[id='range']");

  public HorizontalSliderPage(WebDriver driver) {
    this.driver = driver;
  }

  public void setSliderValue(String value){
    while (!getHorizontalSliderValue().equals(value)) {
      driver.findElement(horizontalSlider).sendKeys(Keys.ARROW_RIGHT);
    }}

  public String getHorizontalSliderValue(){
    return  driver.findElement(sliderValue).getText();
  }

}


