package TestingApi;

import io.restassured.RestAssured;
import org.junit.jupiter.api.*;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class TestLesson17 {

  @BeforeEach
  public void setUp() {
    RestAssured.baseURI = "https://postman-echo.com";
  }

  @Test
  @Order(1)
  @DisplayName("id_1. Проверка GET-запроса")
  public void testGetRequest() {
    given()
        .queryParam("foo1", "bar1")
        .queryParam("foo2", "bar2")
        .when()
        .get("/get")
        .then()
        .log()
        .body()
        .statusCode(200)
        .body("args.foo1", equalTo("bar1"))
        .body("args.foo2", equalTo("bar2"))
        .body("url", equalTo("https://postman-echo.com/get?foo1=bar1&foo2=bar2"));
  }

  @Test
  @Order(2)
  @DisplayName("id_2. Проверка POST-запроса (Raw Text)")
  public void testPostRawTextRequest() {
    String requestBody = "This is expected to be sent back as part of response body.";
    given()
        .body(requestBody)
        .when()
        .post("/post")
        .then()
        .log()
        .body()
        .statusCode(200)
        .body("data", equalTo(requestBody))
        .body("url", equalTo("https://postman-echo.com/post"));
  }

  @Test
  @Order(3)
  @DisplayName("id_3. Проверка POST-запроса (Form Data)")
  public void testPostFormDataRequest() {
    given()
        .header("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8")
        .formParam("foo1", "bar1")
        .formParam("foo2", "bar2")
        .when()
        .post("/post")
        .then()
        .log()
        .body()
        .statusCode(200)
        .body("form.foo1", equalTo("bar1"))
        .body("form.foo2", equalTo("bar2"))
        .body("json.foo1", equalTo("bar1"))
        .body("json.foo2", equalTo("bar2"))
        .body("url", equalTo("https://postman-echo.com/post"));
  }

  @Test
  @Order(4)
  @DisplayName("id_4. Проверка PUT-запроса")
  public void testPutRequest() {
    String requestBody = "This is expected to be sent back as part of response body.";
    given()
        .header("Content-Type", "text/plain")
        .body(requestBody)
        .when()
        .put("/put")
        .then()
        .log()
        .body()
        .statusCode(200)
        .body("data", equalTo(requestBody))
        .body("url", equalTo("https://postman-echo.com/put"));
  }

  @Test
  @Order(5)
  @DisplayName("id_5. Проверка PATCH-запроса")
  public void testPatchRequest() {
    String requestBody = "This is expected to be sent back as part of response body.";
    given()
        .header("Content-Type", "text/plain")
        .body(requestBody)
        .when()
        .patch("/patch")
        .then()
        .log()
        .body()
        .statusCode(200)
        .body("data", equalTo(requestBody))
        .body("url", equalTo("https://postman-echo.com/patch"));
  }

  @Test
  @Order(6)
  @DisplayName("id_6. Проверка DELETE-запроса")
  public void testDeleteRequest() {
    String requestBody = "This is expected to be sent back as part of response body.";
    given()
        .header("Content-Type", "text/plain")
        .body(requestBody)
        .when()
        .delete("/delete")
        .then()
        .log()
        .body()
        .statusCode(200)
        .body("data", equalTo(requestBody))
        .body("url", equalTo("https://postman-echo.com/delete"));
  }
}
