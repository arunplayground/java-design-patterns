package com.java.design.patterns.observer;

import java.util.ArrayList;
import java.util.List;

/*
Observer pattern is mostly used for push notification, rather than polling for changes
Multiple observers are monitoring a single subject. Any change in the value of the subject will
cause the change to be pushed to all the Observers that have registered itself with the subject
 */

interface ISubject<T> {
    void notifyObservers(T newValue);
    void add(IObserver<T> newObserver);
    void remove(IObserver<T> observer);
    void setValue(T newValue);
}

interface IObserver<T> {
    void update(T newValue);
}

class Subject<T> implements ISubject<T> {

    private T subjectValue;

    private List<IObserver<T>> observers = new ArrayList<>();

    @Override
    public void setValue(T newValue) {
        this.subjectValue = newValue;
        //notify the change in value to all the observers
        notifyObservers(subjectValue);
    }

    @Override
    public void notifyObservers(T newValue) {
        observers.forEach((ob) -> ob.update(newValue));
    }

    @Override
    public void add(IObserver<T> ob) {
        observers.add(ob);
    }

    @Override
    public void remove(IObserver old) {
        observers.forEach((ob) -> {
            //simple reference equality check.
            if(ob == old)
                observers.remove(old);
        });
    }
}

class Observer<T> implements IObserver<T> {

    @Override
    public void update(T newValue) {
        System.out.println("New value from the Subject is " + newValue.toString());
    }
}

public class ObserverImpl {

    public static void main(String[] args) {
        //Our subject
        ISubject<Integer> subject = new Subject<>();
        //no observers yet
        subject.setValue(10);
        IObserver<Integer> obsv1 = new Observer<>();
        subject.add(obsv1);
        IObserver<Integer> obsv2 = new Observer<>();
        subject.add(obsv2);
        subject.setValue(20);
    }

}
