package com.java.design.patterns.singleton;

//this enum, has three different singletons.
enum SingletonGenerator {
    //values are by default public static final
    SINGLETON_ONE(1), SINGLETON_TWO(2), SINGLETON_THREE(3);

    //instance members of the enum values
    private int instaneField;

    //private constructor
    private SingletonGenerator(int in) {
        //the constructor can initialize more fields if needed to set the "state" of the singleton
        //only one fields is shown in this example
        instaneField = in;
    }

    //no setters
    public int getInstanceField() {
        return instaneField;
    }


}

public class EnumSingletonImpl {

    public static void main(String[] args) {
        SingletonGenerator ONE = SingletonGenerator.SINGLETON_ONE;
        SingletonGenerator TWO = SingletonGenerator.SINGLETON_TWO;
        SingletonGenerator THREE = SingletonGenerator.SINGLETON_THREE;
        System.out.println(ONE == TWO); //should print false
        SingletonGenerator ONE_ANOTHER = SingletonGenerator.SINGLETON_ONE;
        System.out.println(ONE == ONE_ANOTHER); //should print true
    }

}
