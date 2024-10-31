package testing;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.Duration;
import java.util.Objects;
import lesson16.MainPage;
import lesson16.ModalWindow;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestLesson18 {
  private static WebDriver driver;
  private static MainPage mainPage;
  ModalWindow modalWindow = new ModalWindow(driver);

  @BeforeEach
  public void start() {
    System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
    driver = new ChromeDriver();
    mainPage = new MainPage(driver);
    driver.manage().window().maximize();
    driver.get("https://www.mts.by/");
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    try {
      wait.until(
          ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='cookie__wrapper']")));

      wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id='cookie-agree']")))
          .click();

    } catch (Exception e) {
      System.out.println("Модальное окно с cookies не обнаружено");
    }
  }

  // Проверить название указанного блока.
  @Test
  @DisplayName("Проверка названия блока 'Онлайн пополнение без комиссиии'")
  public void testCheckBlockTitle() {
    assertEquals(
        "Онлайн пополнение\nбез комиссии",
        mainPage.getBlockTitle(),
        "Название блока «Онлайн пополнение без комиссии» не соответствует ожидаемому");
  }

  // Проверить наличие логотипов платёжных систем.
  @Test
  @DisplayName("Проверка наличия логотипов платежных систем")
  public void testCheckLogos() {
    String[] expectedAlts = {
      "Visa", "Verified By Visa", "MasterCard", "MasterCard Secure Code", "Белкарт"
    };

    for (String altText : expectedAlts) {
      assertTrue(
          mainPage.isLogoDisplayed(altText), "Логотип с alt-текстом '" + altText + "' не найден");
    }
  }

  // Проверить работу ссылки «Подробнее о сервисе».
  @Test
  @DisplayName("Проверка работы ссылки 'Подробнее о сервисе'")
  public void testCheckLink() {
    mainPage.clickReadMoreLink();
    assertTrue(
        Objects.requireNonNull(driver.getCurrentUrl())
            .contains("https://www.mts.by/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/"),
        "Переход по ссылке 'Подробнее о сервисе' не привел к ожидаемому URL");
  }

  /*
   Заполнить поля и проверить работу кнопки «Продолжить» (проверяем только вариант «Услуги связи», номер
   для теста 297777777).
  */
  @Test
  @DisplayName("Проверка работы кнопки 'Продолжить'")
  public void testCheckButton() {
    mainPage.fillPhone("297777777");
    mainPage.fillSum("1");
    mainPage.clickContinueButton();
    assertTrue(mainPage.isModalWindowDisplayed(), "Модальное окно не появилось");
  }

  /*
   Проверить надписи в незаполненных полях каждого варианта оплаты услуг: услуги связи, домашний интернет,
   рассрочка, задолженность.
  */
  @Test
  @DisplayName(
      "Проверка надписей в незаполненных полях каждого варианта оплаты услуг: услуги связи")
  public void testCheckPlaceholdersCommunicationServices() {
    String expectedPhonePlaceholder = "Номер телефона";
    String expectedSumPlaceholger = "Сумма";
    String expectedMailPlaceholder = "E-mail для отправки чека";

    String actualPhonePlaceholder =
        driver.findElement(mainPage.connectionPhoneInput).getAttribute("placeholder");
    String actualSumPlaceholder =
        driver.findElement(mainPage.connectionSumInput).getAttribute("placeholder");
    String actualMailPlaceholder =
        driver.findElement(mainPage.connectionMailInput).getAttribute("placeholder");
    assertEquals(expectedPhonePlaceholder, actualPhonePlaceholder);
    assertEquals(expectedSumPlaceholger, actualSumPlaceholder);
    assertEquals(expectedMailPlaceholder, actualMailPlaceholder);
  }

  @Test
  @DisplayName(
      "Проверка надписей в незаполненных полях каждого варианта оплаты услуг: домашний интернет")
  public void testCheckPlaceholdersHomeInternet() {
    String expectedPhonePlaceholder = "Номер абонента";
    String expectedSumPlaceholger = "Сумма";
    String expectedMailPlaceholder = "E-mail для отправки чека";

    String actualPhonePlaceholder =
        driver.findElement(mainPage.internetPhoneInput).getAttribute("placeholder");
    String actualSumPlaceholder =
        driver.findElement(mainPage.internetSumInput).getAttribute("placeholder");
    String actualMailPlaceholder =
        driver.findElement(mainPage.internetMailInput).getAttribute("placeholder");
    assertEquals(expectedPhonePlaceholder, actualPhonePlaceholder);
    assertEquals(expectedSumPlaceholger, actualSumPlaceholder);
    assertEquals(expectedMailPlaceholder, actualMailPlaceholder);
  }

  @Test
  @DisplayName("Проверка надписей в незаполненных полях каждого варианта оплаты услуг: рассрочка")
  public void testCheckPlaceholdersInstallmentPlan() {
    String expectedPhonePlaceholder = "Номер счета на 44";
    String expectedSumPlaceholger = "Сумма";
    String expectedMailPlaceholder = "E-mail для отправки чека";

    String actualPhonePlaceholder =
        driver.findElement(mainPage.instalmentScoreInput).getAttribute("placeholder");
    String actualSumPlaceholder =
        driver.findElement(mainPage.instalmentSumInput).getAttribute("placeholder");
    String actualMailPlaceholder =
        driver.findElement(mainPage.instalmentMailInput).getAttribute("placeholder");
    assertEquals(expectedPhonePlaceholder, actualPhonePlaceholder);
    assertEquals(expectedSumPlaceholger, actualSumPlaceholder);
    assertEquals(expectedMailPlaceholder, actualMailPlaceholder);
  }

  @Test
  @DisplayName(
      "Проверка надписей в незаполненных полях каждого варианта оплаты услуг: задолженность")
  public void testCheckPlaceholdersDebt() {
    String expectedPhonePlaceholder = "Номер счета на 2073";
    String expectedSumPlaceholger = "Сумма";
    String expectedMailPlaceholder = "E-mail для отправки чека";

    String actualPhonePlaceholder =
        driver.findElement(mainPage.arrearsScoreInput).getAttribute("placeholder");
    String actualSumPlaceholder =
        driver.findElement(mainPage.arrearsSumInput).getAttribute("placeholder");
    String actualMailPlaceholder =
        driver.findElement(mainPage.arrearsMailInput).getAttribute("placeholder");
    assertEquals(expectedPhonePlaceholder, actualPhonePlaceholder);
    assertEquals(expectedSumPlaceholger, actualSumPlaceholder);
    assertEquals(expectedMailPlaceholder, actualMailPlaceholder);
  }

  /*
   Для варианта «Услуги связи» заполнить поля в соответствии с пререквизитами из предыдущей темы, нажать
   кнопку «Продолжить» и в появившемся окне проверить корректность отображения суммы (в том числе на кнопке),
   номера телефона, а также надписей в незаполненных полях для ввода реквизитов карты, наличие иконок платёжных
   систем.
  */
  @Test
  @DisplayName(
      "Проверка корректности отображения суммы, номера телефона, надписей в незаполненных полях, наличие иконок платежных систем.")
  void testCheckModalWindow() {
    mainPage.fillPhone("297777777");
    mainPage.fillSum("1");
    mainPage.clickContinueButton();
    assertTrue(mainPage.isModalWindowDisplayed(), "Модальное окно не появилось");

    String expectedSumInModalWindow = "1.00";
    String expectedPhoneInModalWindow = "297777777";
    String expectedCardNumberInputText = "Номер карты";
    String expectedExpirationDateInputText = "Срок действия";
    String expectedCvcInputText = "CVC";
    String expectedNameInputText = "Имя держателя (как на карте)";
    String expectedSumInButtonModalWindow = "1.00";

    String actualCardNumberInputText =
        driver.findElement(modalWindow.cardNumberInputLabel).getText();
    String actualExpirationDateInputText =
        driver.findElement(modalWindow.expirationDateInputLabel).getText();
    String actualCvcInputText = driver.findElement(modalWindow.cvcInputLabel).getText();
    String actualNameInputText = driver.findElement(modalWindow.nameInputLabel).getText();

    assertTrue(
        driver
            .findElement(modalWindow.sumInModalWindow)
            .getText()
            .contains(expectedSumInModalWindow));
    assertTrue(
        driver
            .findElement(modalWindow.phoneInModalWindow)
            .getText()
            .contains(expectedPhoneInModalWindow));
    assertTrue(driver.findElement(modalWindow.googlePayButton).isDisplayed());
    assertTrue(driver.findElement(modalWindow.yandexPayButton).isDisplayed());
    assertTrue(driver.findElement(modalWindow.visaIcon).isDisplayed());
    assertTrue(driver.findElement(modalWindow.mastercardIcon).isDisplayed());
    assertTrue(driver.findElement(modalWindow.belcartIcon).isDisplayed());
    assertTrue(driver.findElement(modalWindow.mirIcon).isDisplayed());
    assertEquals(expectedCardNumberInputText, actualCardNumberInputText);
    assertEquals(expectedExpirationDateInputText, actualExpirationDateInputText);
    assertEquals(expectedCvcInputText, actualCvcInputText);
    assertEquals(expectedNameInputText, actualNameInputText);
    assertTrue(
        driver
            .findElement(modalWindow.sumInButtonModalWindow)
            .getText()
            .contains(expectedSumInButtonModalWindow));
  }

  @AfterEach
  public void tearDown() {
    if (driver != null) {
      driver.quit();
    }
  }
}
