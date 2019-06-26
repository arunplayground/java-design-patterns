package com.java.design.patterns.facade;

/*
Facade pattern is pretty simple. The example is nothing complicated, but in reality, the facade pattern
is applied when a lot of "object wiring" is required to get a single task done.
In this example a ComputerBuilder is the facade class.
You pass in the arguments to the facade (ComputerBuilder's build method), and it returns a Computer.
I have purposely created the ComputerCase, MotherBoard, SoundCard, VideoCard and PowerSupply classes
with different methods to "add" that component to the computer. Sometimes it is add, other cases it is a setter method,
sometimes with arguments.
The client need not know the APIs for all these classes, all the client needs to know is the API of the facade.
 */

class ComputerCase {
    public void enclose(MotherBoard mb, VideoCard vc, SoundCard sc, PowerSupply ps) {
        System.out.println("Putting it all in a case");
    }
}

class MotherBoard {
    public void setMotherBoard() {
        System.out.println("setting the mother board");
    }
}

class SoundCard {
    public void addSoundCard() {
        System.out.println("inserting the sound card");
    }
}

class VideoCard {
    public void insertVideoCard() {
        System.out.println("Inserting the video card");
    }
}

class PowerSupply {
    public void setPowerSupply(int volts) {
        System.out.println("power supply added for " + volts + "V");
    }
}

class Computer {
    public Computer buildComputer() {
        return new Computer();
    }
    //this is a stupid way to implement the toString method
    public String toString() {
        return "I am a new computer built using a facade pattern";
    }
}

//this is the facade class, that builds a computer and returns a computer instance
class ComputerBuilder {

    //the client who wants to build a computer, needs to know just this API, the facade
    public static Computer build(int volts) {
        ComputerCase ccase = new ComputerCase();
        MotherBoard mb = new MotherBoard();
        SoundCard sc = new SoundCard();
        VideoCard vc = new VideoCard();
        PowerSupply ps = new PowerSupply();
        mb.setMotherBoard();
        sc.addSoundCard();
        vc.insertVideoCard();
        ps.setPowerSupply(volts);
        ccase.enclose(mb, vc, sc, ps);
        Computer newComputer = new Computer();
        return newComputer;

    }
}

public class FacadeImpl {
    public static void main(String[] args) {
        Computer myComputer = ComputerBuilder.build(110);
        System.out.println(myComputer);
    }
}
