package com.java.design.patterns.strategy;

/*
This pattern is used, to swap business algorithm independent of the client.
In this example the business logic are the interfaces IFly and ISpeak.
IFly interface define the type of flight (Fly an NoFly classes).
ISpeak interface define the type of speach (Quack and Squeek).
When you create a Duck, you can inject the business logic you want. In this case
you can inject (through the constructor - composition) the ducks' type of flight and the type
of speach. If you want you can have setter methods (in Duck) and swap out the speak and flight logic at any point.
 */

//business logic - 1
interface IFly {
    void fly();
}

//implementation of business logic - 1
class Fly implements IFly {
    @Override
    public void fly() {
        System.out.println("I am a regular duck and i fly like a regular duck");
    }
}

//another implementation of business logic - 1
class NoFly implements IFly {
    @Override
    public void fly() {
        System.out.println("I am a rubber duck and i do not fly");
    }
}

//business logic - 2
interface ISpeak {
    void speak();
}

//implementation of business logic - 2
class Quack implements ISpeak {
    @Override
    public void speak() {
        System.out.println("I am a regular duck and i QUACK");
    }
}

//another implementation of business logic - 2
class Squeek implements ISpeak {
    @Override
    public void speak() {
        System.out.println("I am a rubber duck and i SQUEAK");
    }
}

//client interface that will use these business logic
interface IDuck {
    void speak();
    void fly();
}

class Duck implements IDuck {

    private IFly aFly;
    private ISpeak aSpeak;

    //instead of fixing the flight and speak behavior at the point of construction
    //you can have setter methods and swap out the logic at any point.
    Duck(IFly fly, ISpeak speak) {
        this.aFly = fly;
        this.aSpeak = speak;
    }

    @Override
    public void fly() {
        aFly.fly();
    }

    @Override
    public void speak() {
        aSpeak.speak();
    }
}

public class StrategyImpl {

    public static void main(String[] args) {
        Duck regularDuck = new Duck(new Fly(), new Quack());
        regularDuck.fly();
        regularDuck.speak();
        Duck rubberDuck = new Duck(new NoFly(), new Squeek());
        rubberDuck.fly();
        rubberDuck.speak();
    }

}
