package ru.levelup.patterns.test.builder;

import org.testng.annotations.Test;
import ru.levelup.patterns.builder.UserLombok;


public class UserBuilderLombokTest {

    @Test
    public void builderTest() {
        UserLombok user1 = UserLombok.builder()
                .username("username1")
                .firstName("first1")
                .email("email1")
                .build();

        UserLombok user2 = UserLombok.builder()
                .password("password2")
                .firstName("first2")
                .secondName("second2")
                .build();

        UserLombok user3 = UserLombok.builder()
                .username("username3")
                .email("email3")
                .age(34)
                .build();

        System.out.println(user1);
        System.out.println();
        System.out.println(user2);
        System.out.println();
        System.out.println(user3);
    }
}
