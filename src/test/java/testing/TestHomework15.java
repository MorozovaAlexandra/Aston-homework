package testing;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestHomework15 {
  private static WebDriver driver;
  private static WebDriverWait wait;

  @BeforeAll
  public static void setUp() {
    System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
    driver = new ChromeDriver();
    driver.manage().window().maximize();
    driver.get("https://www.mts.by/");
    wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    try {
      wait.until(
          ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='cookie__wrapper']")));

      wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id='cookie-agree']")))
          .click();

    } catch (Exception e) {
      System.out.println("Модальное окно с cookies не обнаружено");
    }
  }

  /*
   Необходимо написать автотесты для сайта mts.by. Суть тестов заключается в проверке блока «Онлайн пополнение
   без комиссии»:
   1. Проверить название указанного блока;
   2. Проверить наличие логотипов платёжных систем;
   3. Проверить работу ссылки «Подробнее о сервисе»;
   4. Заполнить поля и проверить работу кнопки «Продолжить» (проверяем только вариант «Услуги связи», номер
   для теста 297777777)
  */
  @Test
  @DisplayName("Проверка названия блока 'Онлайн пополнение без комиссиии'")
  public void testCheckBlockTitle() {

    WebElement searchBlock = driver.findElement(By.xpath("//div[@class='pay__wrapper']"));
    String actualTitle = searchBlock.findElement(By.tagName("h2")).getText();

    String expectedTitle = "Онлайн пополнение\nбез комиссии";

    assertEquals(
        expectedTitle,
        actualTitle,
        "Название блока «Онлайн пополнение без комиссии» не соответствует ожидаемому");
  }

  @Test
  @DisplayName("Проверка наличия логотипов платежных систем")
  public void testCheckLogos() {
    WebElement paymentLogos =
        wait.until(
            ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//div[@class='pay__partners']")));

    String[] expectedAlts = {
      "Visa", "Verified By Visa", "MasterCard", "MasterCard Secure Code", "Белкарт"
    };

    for (String altText : expectedAlts) {
      WebElement logo = paymentLogos.findElement(By.xpath(".//img[@alt='" + altText + "']"));
      assertTrue(logo.isDisplayed(), "Логотип с alt-текстом '" + altText + "' не найден");
    }
  }

  @Test
  @DisplayName("Проверка работы ссылки 'Подробнее о сервисе'")
  public void testCheckLink() {
    WebElement link =
        wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Подробнее о сервисе")));
    link.click();
    assertTrue(
        Objects.requireNonNull(driver.getCurrentUrl())
            .contains("https://www.mts.by/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/"),
        "Переход по ссылке 'Подробнее о сервисе' не привел к ожидаемому URL");
  }

  @Test
  @DisplayName("Проверка работы кнопки 'Продолжить'")
  public void testCheckButton() {
    WebElement phoneInputField =
        wait.until(
            ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='connection-phone']")));
    phoneInputField.clear();
    phoneInputField.sendKeys("297777777");

    WebElement sumInputField =
        wait.until(
            ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='connection-sum']")));
    sumInputField.clear();
    sumInputField.sendKeys("1");

    wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#pay-connection > button")))
        .click();

    wait.until(
            ExpectedConditions.frameToBeAvailableAndSwitchToIt(
                By.xpath("//iframe[@class='bepaid-iframe']")))
        .switchTo();

    WebElement modalWindow =
        wait.until(
            ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//div[@class='app-wrapper__content']")));

    assertTrue(modalWindow.isDisplayed(), "Модальное окно не появилось");
  }

  @AfterEach
  public void returnToStart() {
    driver.get("http://mts.by");
  }

  @AfterAll
  public static void tearDown() {
    if (driver != null) {
      driver.quit();
    }
  }
}
