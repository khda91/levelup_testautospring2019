package ru.levelup.patterns.builder;

import lombok.Builder;

@Builder
public class UserLombok {

    private String username;
    private String password;
    private String firstName;
    private String secondName;
    private String email;
    private int age;

}
