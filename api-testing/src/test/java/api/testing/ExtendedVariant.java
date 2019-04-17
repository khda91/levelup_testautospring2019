package api.testing;

import static io.restassured.RestAssured.given;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.response.Response;
import static org.hamcrest.Matchers.containsString;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ExtendedVariant {

    @DataProvider
    public Object[][] userDataProvide() {
        return new Object[][] {
                {"vtest1014", "p@ssw0rd", "Victor Test10", "m@mmmm.com", "updater", true, false}
        };
    }

    @Test(dataProvider = "userDataProvide")
    public void createUserTest(String username, String password, String realName, String email, String accessLevelName, boolean enabled, boolean userProtected) {
        UserAccessLevel ual = new UserAccessLevel();
        ual.setName(accessLevelName);
        User user = new User();
        user.setAccessLevel(ual);
        user.setUsername(username);
        user.setPassword(password);
        user.setEmail(email);
        user.setRealName(realName);
        user.setUserProtected(userProtected);
        user.setEnabled(enabled);

        Response response = given()
                .baseUri("http://khda91.fvds.ru/mantisbt/api/rest")
                .header(new Header("Authorization", "XNd5tIXXB7U8FV4C8w0nao0WYr5S0nN7"))
                .contentType(ContentType.JSON)
                .body(user)
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
        // TODO actual user from database
        // TODO assertThat(actualUser, equalTo(user));
    }
}
