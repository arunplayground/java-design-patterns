package com.java.design.patterns.singleton;

/*
Our singleton object (SimpleSingleton) is eagerly initialized as soon as this class is loaded by the JVM.
There is no guarantee that this singleton instance may actually be used by the client.
And the logic to create this instance may be very complicated and resource hungry (unlike the simple new operator used here).
A better way to create singleton is to create it only when the client actually wants to use it.
*/

public class SimpleSingletonImpl {

    public static void main(String[] args) {
        SimpleSingleton singleton1 = SimpleSingleton.getInstance();
        SimpleSingleton singleton2 = SimpleSingleton.getInstance();
        System.out.println(singleton1 == singleton2);
    }
}

class SimpleSingleton {

    private static SimpleSingleton singleInstance = new SimpleSingleton();

    //private constructor - no access to new operator
    private SimpleSingleton() {
    }

    public static SimpleSingleton getInstance() {
        return singleInstance;
    }

}