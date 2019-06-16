package com.java.design.patterns.proxy;

abstract class ISubject {
    abstract void doSomeWork();
}

class ConcreteObject {

    private ConcreteObject() {
        //private constructor
        //access to the ConcreteObject is only through ProxyObject inner class
    }

    private void doSomeWork() {
        System.out.println("Work done by concrete implementation");
    }

    public static class ProxyObject extends ISubject {
        private ConcreteObject concreteObj;
        //this is where we control the access to the concrete implementation
        //1. We can use the proxy object to control access
        //2. If the concrete implementation is a heavy object
        // we can use the proxy to do some light work until we really need the concrete implementation
        // We can use lazy initialization to initalize the heavy concrete implementation when needed
        //3. We can use the proxy to communicate with the concrete implementation in another address space
        public void doSomeWork() {
            if(concreteObj == null) {
                concreteObj = new ConcreteObject();
            }
            concreteObj.doSomeWork();
        }
    }
}

public class ProxyImpl {
    public static void main(String[] args) {
        ConcreteObject.ProxyObject proxy = new ConcreteObject.ProxyObject();
        proxy.doSomeWork();
    }
}
