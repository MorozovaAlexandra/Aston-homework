package lesson18;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ModalWindow {
  public final WebDriver driver;

  public ModalWindow(WebDriver driver) {
    this.driver = driver;
  }

  public final By sumInModalWindow = By.xpath("//div[@class='pay-description__cost']");
  public final By phoneInModalWindow = By.xpath("//div[@class='pay-description__text']");
  public final By googlePayButton = By.xpath("//div[@id='google-pay-button']");
  public final By yandexPayButton = By.xpath("//div[@id='yandex-button']");
  public final By visaIcon = By.xpath("//img[contains(@src, 'visa-system')]");
  public final By mastercardIcon = By.xpath("//img[contains(@src, 'mastercard-system')]");
  public final By belcartIcon = By.xpath("//img[contains(@src, 'belkart-system')]");
  public final By mirIcon = By.xpath("//img[contains(@src, 'maestro-system')]");
  public final By cardNumberInputLabel =
      By.xpath("//input[@id='cc-number']/following-sibling::label");
  public final By expirationDateInputLabel =
      By.xpath("//input[contains(@class, 'date-input')]/following-sibling::label");
  public final By cvcInputLabel =
      By.xpath("//input[@name='verification_value']/following-sibling::label");
  public final By nameInputLabel =
      By.xpath("//input[@formcontrolname='holder']/following-sibling::label");
  public final By sumInButtonModalWindow = By.xpath("//button[@class='colored disabled']");
}
