package com.java.design.patterns.decorator;

/*
Decorator pattern -  IF you want to change the behavior of an object but without changing its code.
You wrap the object whose behavior you want to change with the object that contains the change that you want.
Decorator pattern helps to add more "decorators" without changing the code of the existing components
Also it prevents class explosion.
 */

interface IComponent {
    String getDescription();
    double getPrice();
}

//you can have more base pizza types, in this example there is only one base type
//you can consider this as the base case in a recursive loop
class BasePizza implements IComponent {

    public String getDescription() {
        return "Base Pizza ";
    }

    public double getPrice() {
        return 2.0D;
    }

}

//decorator is a component and has a component
//it implements IComponent, and the object we wrap also implements IComponent
class PepperoniDecorator implements IComponent {

    private IComponent decoratedComponent;

    PepperoniDecorator(IComponent decoratedComponent) {
        this.decoratedComponent = decoratedComponent;
    }

    public String getDescription() {
        return decoratedComponent.getDescription() + " Pepperoni ";
    }

    public double getPrice() {
        return decoratedComponent.getPrice() + 1.0D;
    }

}

//it implements IComponent, and the object we wrap also implements IComponent
class MushroomDecorator implements IComponent {

    private IComponent decoratedComponent;

    MushroomDecorator(IComponent decoratedComponent) {
        this.decoratedComponent = decoratedComponent;
    }

    public String getDescription() {
        return decoratedComponent.getDescription() + " Mushrooms ";
    }

    public double getPrice() {
        return decoratedComponent.getPrice() + 3.0D;
    }

}



public class DecoratorImpl {
    public static void main(String[] args) {
        //Creating the base case (From recursive point of view, the recursion loop stops here)
        IComponent basePizza = new BasePizza();
        //create decorators.
        //The decorator IS A component, and it HAS A component.
        //pepperoni decorator wraps the base pizza component
        IComponent pepperoniDecorator = new PepperoniDecorator(basePizza);
        //mushroom decorator wraps the pepperoni decorator, which in turn wraps the base pizza.
        IComponent mushroomDecorator = new MushroomDecorator(pepperoniDecorator);
        System.out.println(mushroomDecorator.getDescription()); //Base Pizza  Pepperoni  Mushrooms
        System.out.println(mushroomDecorator.getPrice()); // 6.0
    }
}
