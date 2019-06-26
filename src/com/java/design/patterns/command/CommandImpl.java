package com.java.design.patterns.command;

/*
The idea behind this Command pattern is, each command object is encapsulated with the action and the object upon which
it needs to act within the command object.
Then you can assign this command object to any invoker, or put it in a queue and batch process it.

In this example, we have an ICommand interface with two methods "turnOn" and "turnOff".
Any command, must implement these methods.

The receiver is a network connected light bulb, and the command object is injected with this receiver at creation time
 */

import java.util.Arrays;
import java.util.List;

interface ICommand {
    void setReceiver(Receiver receiver);
    void Do();
    void Undo();
}

class turnOnLightCommand implements ICommand {
    Receiver receiver;
    public void setReceiver(Receiver receiver) {
        this.receiver = receiver;
    }
    public void Do() {
        if(this.receiver != null) {
            receiver.turnOn();
        }
    }
    public void Undo() {
        if(this.receiver != null) {
            receiver.turnOff();
        }
    }
}

class turnOffLightCommand implements ICommand {
    Receiver receiver;
    public void setReceiver(Receiver receiver) {
        this.receiver = receiver;
    }
    public void Do() {
        if(this.receiver != null) {
            receiver.turnOff();
        }
    }
    public void Undo() {
        if(this.receiver != null) {
            receiver.turnOn();
        }
    }
}

interface Receiver {
    void turnOn();
    void turnOff();
}

class LightBulb implements Receiver {

    boolean flag;

    public void turnOn() {
        if(flag){
            System.out.println("The light is already on");
        } else {
            System.out.println("Turning on the light");
            flag = true;
        }
    }

    public void turnOff() {
        if(flag) {
            System.out.println("Turning off the light");
            flag = false;
        } else {
            System.out.println("The light is already turned off");
        }
    }
}

//Invoker. This piece is not really part of this design pattern.
//THe invoker can simply be a method that receives a set of commands to be executed sequentially
class Invoker {
    List<ICommand> commands;

    Invoker(List<ICommand> commands) {
        this.commands = commands;
    }

    //although the invoke method just invokes the "Do" method of the ICommand
    //you can always make it call either Do or the Undo or any mixture of it based on the need
    public void invoke() {
        commands.forEach(cmd -> cmd.Do());
    }
}

public class CommandImpl {
    public static void main(String[] args) {
        //create a list of commands first
        Receiver bulb = new LightBulb();
        ICommand cmd1 = new turnOnLightCommand();
        cmd1.setReceiver(bulb);
        ICommand cmd2 = new turnOnLightCommand();
        cmd2.setReceiver(bulb);
        ICommand cmd3 = new turnOffLightCommand();
        cmd3.setReceiver(bulb);
        ICommand cmd4 = new turnOffLightCommand();
        cmd4.setReceiver(bulb);
        ICommand cmd5 = new turnOnLightCommand();
        cmd5.setReceiver(bulb);
        ICommand cmd6 = new turnOffLightCommand();
        cmd6.setReceiver(bulb);
        List<ICommand> listOfCommands = Arrays.asList(cmd1, cmd2, cmd3, cmd4, cmd5, cmd6);

        Invoker invoker = new Invoker(listOfCommands);
        invoker.invoke();
    }
}
