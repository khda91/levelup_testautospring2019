package ru.levelup.patterns.test.value.object;

import org.testng.annotations.Test;
import ru.levelup.patterns.value.object.User;

import java.util.ArrayList;
import java.util.List;

public class UserTest {

    @Test
    public void testCreateUserObject() {
        List<User> list = new ArrayList<>();
        list.add(new User("", "", "", "", ""));
        list.add(new User("", "", "", "", ""));
        list.add(new User("", "", "", "", ""));
        list.add(new User("", "", "", "", ""));
        list.add(new User("", "", "", "", ""));
        list.add(new User("", "", "", "", ""));
        list.add(new User("", "", "", "", ""));
        list.add(new User("", "", "", "", ""));
        list.add(new User("", "", "", "", ""));
        list.add(new User("", "", "", "", ""));
        list.add(new User("", null, null, "", null));

        User user1 = new User();
        user1.setUsername("");
        user1.setFirstName("");
//        user1.setEmail("");
        user1.setPassword("");

        for (User user : list) {
            createUserMethod(user);
        }
    }

    @Test
    public void testCreateUserFields() {
        String[][] list = new String[500][5];
        list[0] = new String[]{"", "", "", "", ""};
        list[1] = new String[]{"", "", "", "", ""};
        list[2] = new String[]{"", "", "", "", ""};
        list[3] = new String[]{"", "", "", "", ""};
        list[4] = new String[]{"", "", "", "", ""};
        list[5] = new String[]{"", "", "", "", ""};
        list[6] = new String[]{"", "", "", "", ""};

        for (String[] user : list) {
            createUserMethod(user[0], user[1], user[2], user[3], user[4]);
        }
    }

    private User createUserMethod(User user) {
        user.getEmail();
        user.getFirstName();
        return new User();
    }

    private User createUserMethod(String username, String password, String firstName, String secondName, String email) {
        return new User(username, password, firstName, secondName, email);
    }
}
