package ru.levelup.patterns.test.builder;

import org.testng.annotations.Test;
import ru.levelup.patterns.builder.User;

import java.util.ArrayList;
import java.util.List;

public class UserBuilderTest {

    @Test
    public void testCreateUserObject() {
        List<User> list = new ArrayList<>();
        list.add(User.getBuilder().setUsername("").setFirstName("").build());
        list.add(User.getBuilder().setUsername("").setFirstName("").build());
        list.add(User.getBuilder().setUsername("").setFirstName("").build());
        list.add(User.getBuilder().setAge(20).setUsername("").setFirstName("").build());
        list.add(User.getBuilder().setPassword("").setFirstName("").build());
        list.add(User.getBuilder().setSecondName("").setFirstName("").build());
        list.add(User.getBuilder().setUsername("").setFirstName("").build());
        list.add(User.getBuilder().setUsername("").setFirstName("").build());
        list.add(User.getBuilder().setUsername("").setFirstName("").setAge(10).build());

        for (User user : list) {
            createUserMethod(user);
        }
    }

    private User createUserMethod(User user) {
        user.getEmail();
        user.getFirstName();
        return User.getBuilder().build();
    }

    @Test
    public void builderTest() {
        User user1 = User.getBuilder()
                .setUsername("username1")
                .setFirstName("first1")
                .setEmail("email1")
                .build();

        User user2 = User.getBuilder()
                .setPassword("password2")
                .setFirstName("first2")
                .setSecondName("second2")
                .build();

        User user3 = User.getBuilder()
                .setUsername("username3")
                .setEmail("email3")
                .setAge(34)
                .build();

        System.out.println(user1);
        System.out.println();
        System.out.println(user2);
        System.out.println();
        System.out.println(user3);
    }
}
