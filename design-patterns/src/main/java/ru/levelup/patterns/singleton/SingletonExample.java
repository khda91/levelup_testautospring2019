package ru.levelup.patterns.singleton;

public class SingletonExample {

    private int d = 6;

    private static SingletonExample instance;

    private SingletonExample() {
    }

    public static SingletonExample getInstance() {
        if (instance == null) {
            instance = new SingletonExample();
            return instance;
        }
        return instance;
    }

    public void setD(int d) {
        this.d = d;
    }

    @Override
    public String toString() {
        return "SingletonExample{" +
                "d=" + d +
                '}';
    }
}
