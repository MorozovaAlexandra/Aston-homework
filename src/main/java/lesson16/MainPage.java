package lesson16;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainPage {
  private final WebDriver driver;
  private final WebDriverWait wait;
  public final By payWrapper = By.xpath("//div[@class='pay__wrapper']//h2");
  public final By bePaidIframe = By.xpath("//iframe[@class='bepaid-iframe']");
  public final By bePaidAppWrapper = By.xpath("//div[@class='app-wrapper__content']");
  public final By moreAboutServiceLink = By.linkText("Подробнее о сервисе");
  public final By connectionPhoneInput = By.xpath("//input[@id='connection-phone']");
  public final By connectionSumInput = By.xpath("//input[@id='connection-sum']");
  public final By connectionMailInput = By.xpath("//input[@id='connection-email']");
  public final By internetPhoneInput = By.xpath("//input[@id='internet-phone']");
  public final By internetSumInput = By.xpath("//input[@id='internet-sum']");
  public final By internetMailInput = By.xpath("//input[@id='internet-email']");
  public final By instalmentScoreInput = By.xpath("//input[@id='score-instalment']");
  public final By instalmentSumInput = By.xpath("//input[@id='instalment-sum']");
  public final By instalmentMailInput = By.xpath("//input[@id='instalment-email']");
  public final By arrearsScoreInput = By.xpath("//input[@id='score-arrears']");
  public final By arrearsSumInput = By.xpath("//input[@id='arrears-sum']");
  public final By arrearsMailInput = By.xpath("//input[@id='arrears-email']");
  public final By continueButton = By.cssSelector("#pay-connection > button");

  public MainPage(WebDriver driver) {
    this.driver = driver;
    wait = new WebDriverWait(driver, Duration.ofSeconds(10));
  }

  public String getBlockTitle() {
    return driver.findElement(payWrapper).getText();
  }

  public boolean isLogoDisplayed(String altText) {
    return wait.until(
            ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//div[@class='pay__partners']//img[@alt='" + altText + "']")))
        .isDisplayed();
  }

  public void clickReadMoreLink() {
    wait.until(ExpectedConditions.elementToBeClickable(moreAboutServiceLink)).click();
  }

  public void fillPhone(String phoneNumber) {
    wait.until(ExpectedConditions.elementToBeClickable(connectionPhoneInput)).clear();
    wait.until(ExpectedConditions.elementToBeClickable(connectionPhoneInput)).sendKeys(phoneNumber);
  }

  public void fillSum(String sum) {
    wait.until(ExpectedConditions.elementToBeClickable(connectionSumInput)).clear();
    wait.until(ExpectedConditions.elementToBeClickable(connectionSumInput)).sendKeys(sum);
  }

  public void clickContinueButton() {
    wait.until(ExpectedConditions.elementToBeClickable(continueButton)).click();
  }

  public boolean isModalWindowDisplayed() {
    wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(bePaidIframe)).switchTo();
    wait.until(ExpectedConditions.visibilityOfElementLocated(bePaidAppWrapper));

    return driver.findElement(bePaidAppWrapper).isDisplayed();
  }
}
