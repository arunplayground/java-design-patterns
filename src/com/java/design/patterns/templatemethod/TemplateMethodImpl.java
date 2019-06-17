package com.java.design.patterns.templatemethod;

/*
Making a pizza is like a template. Except, certain steps in making a pizza might be slightly different
for the type of pizza you are making.
You just follow the steps in the template, but override (implement) certain steps which can be different
for different types of pizza
 */

abstract class TemplatePizza {

    //this method is the "template" to make a pizza, which should not be modifiable.
    //you cannot override it when you extend this abstract class
    final void makePizza() {
        System.out.println("Step 1 - prepare dough");
        System.out.println("Step 2 - roll out the dough to a circle with thicker edge for the crust");
        System.out.println("Step 3 - pre heat the oven to a set temperature");
        addToppings();
        System.out.println("Step 5 - bake the pizza for 30 minutes");
        //i am not sure what you do here :). But anyway this is one of the steps in the makePizza template.
        garnishPizza();
    }

    abstract void addToppings();
    abstract void garnishPizza();
}

class BBQChickenPizza extends TemplatePizza {

    //just implement the unimplemented methods from the abstract class
    void addToppings() {
        System.out.println("Step 4 - Toppings added - sauce, cheese, BBQ Chicken, ham, peppers, tomato");
    }

    void garnishPizza() {
        System.out.println("Step 6 - garnishing the pizza");
    }

}

public class TemplateMethodImpl {
    //lets make a pizza
    public static void main(String[] args) {
        TemplatePizza bbqChicken = new BBQChickenPizza();
        //calling the template method
        bbqChicken.makePizza();
    }

}
