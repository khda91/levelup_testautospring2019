package api.testing;

import static io.restassured.RestAssured.given;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.response.Response;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.core.IsEqual.equalTo;
import org.testng.annotations.Test;


public class SimpleExample {

    @Test
    public void getUserInfoTest() {
        given()
                .baseUri("http://khda91.fvds.ru/mantisbt/api/rest")
                .header(new Header("Authorization", "XNd5tIXXB7U8FV4C8w0nao0WYr5S0nN7"))
        .when()
                .get("/users/me")
        .then()
                .statusCode(200)
                .body("name", equalTo("api_user"))
                .body("email", equalTo("api@api.com"));
    }

    @Test
    public void createUserTest() {
        Response response = given()
                .baseUri("http://khda91.fvds.ru/mantisbt/api/rest")
                .header(new Header("Authorization", "XNd5tIXXB7U8FV4C8w0nao0WYr5S0nN7"))
                .contentType(ContentType.JSON)
                .body("{\n" +
                        "  \"username\": \"vtest1013\",\n" +
                        "  \"password\": \"p@ssw0rd\",\n" +
                        "  \"real_name\": \"Victor Test10\",\n" +
                        "  \"email\": \"m@mmmm.com\",\n" +
                        "  \"access_level\": { \"name\": \"updater\" },\n" +
                        "  \"enabled\": true,\n" +
                        "  \"protected\": false\n" +
                        "}\n" +
                        "\n")
                .when()
                .post("/users");

        String userCreatedWithId = response.then()
                .statusCode(201)
                .statusLine(containsString("User created with id"))
                .extract()
                .statusLine();

        String[] splitStatusLine = userCreatedWithId.split(" ");
        String id = splitStatusLine[splitStatusLine.length - 1];
        System.out.println("id -> " + id);
        // TODO запрос в БД
    }
}
