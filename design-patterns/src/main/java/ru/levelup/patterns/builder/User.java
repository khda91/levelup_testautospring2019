package ru.levelup.patterns.builder;

public class User {

    private String username;
    private String password;
    private String firstName;
    private String secondName;
    private String email;
    private int age;

    private User() {
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public String getEmail() {
        return email;
    }

    public int getAge() {
        return age;
    }

    public static UserBuilder getBuilder() {
        return new UserBuilder();
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                ", email='" + email + '\'' +
                ", age='" + age + '\'' +
                '}';
    }

    public static class UserBuilder {
        private String username;
        private String password;
        private String firstName;
        private String secondName;
        private String email;
        private int age;

        private UserBuilder() {
        }

        public UserBuilder setUsername(String username) {
            this.username = username;
            return this;
        }

        public UserBuilder setPassword(String password) {
            this.password = password;
            return this;
        }

        public UserBuilder setFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public UserBuilder setSecondName(String secondName) {
            this.secondName = secondName;
            return this;
        }

        public UserBuilder setEmail(String email) {
            this.email = email;
            return this;
        }

        public UserBuilder setAge(int age) {
            this.age = age;
            return this;
        }

        public User build() {
            User user = new User();
            user.username = this.username;
            user.password = this.password;
            user.firstName = this.firstName;
            user.secondName = this.secondName;
            user.email = this.email;
            user.age = this.age;
            return user;
        }
    }

}
