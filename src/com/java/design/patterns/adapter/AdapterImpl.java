package com.java.design.patterns.adapter;

/*
In this example, the font end code uses a payment gateway to process its payments.

So the front end creates an object of type CreditCard and sends that object to an implementation of CCProcessor
(CreditCardProcessor)interface.

Assume that the company has changed the payment gateway software to process its payments.

So instead of changing the front end code (assume that the front end code is too complex to change, because of bad design may be)
it uses an adaptor to do the conversion of CreditCard object to NewCreditCard object and uses an implementation of CCProcessor
(CreditCardProcessorAdpater) to process this payment
 */


//Credit card object
//fields are firstName, lastName and Credit card number
class CreditCard {

    String firstName;
    String lastName;
    String creditCardNumber;

    CreditCard(String firstName, String lastName, String creditCardNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.creditCardNumber = creditCardNumber;
    }
}

//class PaymentGateway - which takes in objects of type "CreditCard" and the "amount"
class PaymentGateway {
    public static void processPayment(CreditCard cc, double amount) {
        System.out.println("PayementGateway processing credit card for the amount " + amount + ", name is " + cc.firstName + " " + cc.lastName);
    }
}

//NewCreditCard object
//fields are fullName and credit card number (note the name is of the format "full name")
class NewCreditCard {
    String fullName;
    String creditCardNumber;

    NewCreditCard(String fullName, String creditCardNumber) {
        this.fullName = fullName;
        this.creditCardNumber = creditCardNumber;
    }
}

//NewPaymentGateway - replacing the old payment gateway
//it takes in only objects of "NewCreditCard" and amount
class NewPaymentGateway {
    public static void processPayment(NewCreditCard cc, double amount) {
        System.out.println("NewPaymentGateway processing credit card for the amount " + amount + ", name is " + cc.fullName);
    }
}

//the web front end which processes credit card payments have to use this interface CCProcessor
interface CCProcessor {
    void sendToPaymentGateway(CreditCard cc, double amount);
}

//implementation of the the CCProcessor interface
class CreditCardProcessor implements CCProcessor{
    public void sendToPaymentGateway(CreditCard cc, double amount) {
        PaymentGateway.processPayment(cc, amount);
    }
}

//assume that the company has decided to switch the payment gateway provider.
//The new provider of the gateway (NewPaymentGateway) has a method processPayment,
//but unlike the old PaymentGateway, the new gateway can accept only objects of type NewCreditCard
//instead of changing the front end code, we create an adaptor, which converts the old CreditCard objects
//to NewCreditCard objects
class CreditCardProcessorAdpater implements CCProcessor {
    public void sendToPaymentGateway(CreditCard cc, double amount) {
        //now that we want to process this same CreditCard through the NewPaymentGateway
        //we need to ADAPT the CreditCard object to NewCreditCard object
        String firstName = cc.firstName;
        String lastName = cc.lastName;
        String ccNumber = cc.creditCardNumber;
        //now construct the object of NewCreditCard
        NewCreditCard newCC = new NewCreditCard(firstName + " " + lastName, ccNumber);
        NewPaymentGateway.processPayment(newCC, amount);
    }
}


public class AdapterImpl {
    public static void main(String[] args) {
        //CreditCard object being processed through the PaymentGateway
        CreditCard oldCC = new CreditCard("John", "Doe", "44444444");
        double amount = 100.00;
        //company still using the old payment gateway software which needs an object of type CreditCard
        CreditCardProcessor oldCCProcessor = new CreditCardProcessor();
        oldCCProcessor.sendToPaymentGateway(oldCC, amount);

        //Now the company has changed the payment gateway software, which accepts only objects of type NewCreditCard
        CreditCardProcessorAdpater newCCProcessorAdapter = new CreditCardProcessorAdpater();
        newCCProcessorAdapter.sendToPaymentGateway(oldCC, amount);
    }
}
