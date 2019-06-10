package com.java.design.patterns.singleton;

/*
In this case of creating a singleton, we use the Factory Pattern (i am using this term loosely, this is not even a GOF pattern)
We have to synchronize the code that actually creates the singleton instance.
We have to pay the price for threads and related context switching.
Although the instance is not created eagerly, still using threads is a bit heavy
*/

public class BetterSingletonImpl {
    public static void main(String[] args) {
        BetterSingleton instance1 = BetterSingleton.getInstance();
        BetterSingleton instance2 = BetterSingleton.getInstance();
        System.out.println(instance1 == instance2);
    }
}

class BetterSingleton {

    private static BetterSingleton instance = null;

    private BetterSingleton(){
        //private constructor
    }

    //you can make the whole method "synchronized" to avoid multiple threads initializing the same instance
    public static synchronized BetterSingleton getInstance() {
        if(instance == null) {
            instance = new BetterSingleton();
        }
        return instance;
    }

}
