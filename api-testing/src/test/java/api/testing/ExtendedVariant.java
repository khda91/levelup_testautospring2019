package api.testing;

import static io.restassured.RestAssured.given;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.commons.lang3.RandomStringUtils;
import static org.hamcrest.MatcherAssert.assertThat;
import org.hamcrest.Matchers;
import static org.hamcrest.Matchers.containsString;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ExtendedVariant {

    private static final String DB_URL = "jdbc:mysql://92.63.106.242:3306/bugtracker";
    private static final String USER = "test_user";
    private static final String PASSWORD = "P@ssw0rd";

    private Connection connection;
    private Statement statement;

    @BeforeSuite(alwaysRun = true)
    public void suiteSetUp() {
        try {
            Class.forName("com.mysql.jdbc.Driver").getDeclaredConstructor().newInstance();
            connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @BeforeMethod(alwaysRun = true)
    public void initStatement() {
        try {
            statement = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @DataProvider
    public Object[][] userDataProvide() {
        return new Object[][]{
                {RandomStringUtils.randomAlphabetic(10), "p@ssw0rd", RandomStringUtils.randomAlphabetic(10),
                        "m@mmmm.com", AccessLevel.UPDATER, true, false},
                {RandomStringUtils.randomAlphabetic(10), "p@ssw0rd", RandomStringUtils.randomAlphabetic(10),
                        "m@mmmm.com", AccessLevel.REPORTER, true, false},
                {RandomStringUtils.randomAlphabetic(10), "p@ssw0rd", RandomStringUtils.randomAlphabetic(10),
                        "m@mmmm.com", AccessLevel.DEVELOPER, true, false},
                {RandomStringUtils.randomAlphabetic(10), "p@ssw0rd", RandomStringUtils.randomAlphabetic(10),
                        "m@mmmm.com", AccessLevel.VIEWER, true, false}
        };
    }

    @Test(dataProvider = "userDataProvide")
    public void createUserTest(String username, String password, String realName, String email,
                               AccessLevel accessLevelName, boolean enabled, boolean userProtected) {
        UserAccessLevel ual = new UserAccessLevel();
        ual.setName(accessLevelName.getName());
        User user = new User();
        user.setAccessLevel(ual);
        user.setUsername(username);
        user.setPassword(password);
        user.setEmail(email);
        user.setRealName(realName);
        user.setUserProtected(userProtected);
        user.setEnabled(enabled);

        RequestSpecification request = given()
                .baseUri("http://khda91.fvds.ru/mantisbt/api/rest")
                .header(new Header("Authorization", "XNd5tIXXB7U8FV4C8w0nao0WYr5S0nN7"))
                .contentType(ContentType.JSON)
                .body(user);

        Response response = request.when()
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
        String query = String.format("select * from mantis_user_table where id='%s'", id);

        // TODO actual user from database
        ResultSet rs = null;
        User actualUser = new User();
        try {
            rs = statement.executeQuery(query);
            while (rs.next()) {
                actualUser.setUsername(rs.getString("username"));
                actualUser.setRealName(rs.getString(3));
                actualUser.setEmail(rs.getString("email"));
                actualUser.setEnabled(rs.getBoolean(6));
                actualUser.setUserProtected(rs.getBoolean("protected"));
                ual = new UserAccessLevel();
                ual.setName(AccessLevel.getNameById(rs.getInt("access_level")));
                actualUser.setAccessLevel(ual);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println("actual -> " + actualUser);
        // TODO assertThat(actualUser, equalTo(user));
        assertThat(actualUser, Matchers.samePropertyValuesAs(user, "password"));
    }

    @Test
    public void getCurrentUser() {
        Response response = given()
                .baseUri("http://khda91.fvds.ru/mantisbt/api/rest")
                .header(new Header("Authorization", "XNd5tIXXB7U8FV4C8w0nao0WYr5S0nN7"))
                .when()
                .get("/users/me");
        response.then()
                .statusCode(200);
        User user = response.as(User.class);

        System.out.println("current user -> " + user);
    }

    @AfterMethod(alwaysRun = true)
    public void closeStatement() {
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @AfterSuite(alwaysRun = true)
    public void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
