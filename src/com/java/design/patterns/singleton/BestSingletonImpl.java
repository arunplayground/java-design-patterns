package com.java.design.patterns.singleton;

/*
In this case the singleton we need is not eagerly created, it is created only when the end user wants to use it.

In this case the private static inner class (SingletonGenerator) holds a singleton instance of the outer class (BestSingleton).
Because the BestSingleton class has a private constructor, no one can directly create an instance of it.
Because the SingletonGenerator is a private inner class, no one can access it directly or create an instance of it.
Only when the end user calls the getInstance static method (of the BestSingleton class), the singleton instance
(of BestSingleton class) is created.
by
*/

public class BestSingletonImpl {
    public static void main(String[] args) {
        BestSingleton instance1 = BestSingleton.getInstance();
        BestSingleton instance2 = BestSingleton.getInstance();
        System.out.println(instance1 == instance2);
    }
}

class BestSingleton {

    private BestSingleton() {
        //private constructor
    }

    private static final class SingletonGenerator {

        //private constructor - you dont need this constructor because the static inner class is private
        private SingletonGenerator(){
        }

        private static final BestSingleton _instance = new BestSingleton();

    }

    public static BestSingleton getInstance() {
        return SingletonGenerator._instance;
    }

}
