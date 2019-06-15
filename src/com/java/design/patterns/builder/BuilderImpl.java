package com.java.design.patterns.builder;

/*
Builder pattern is very verbose.
Although the sample provided below does not actually warrant a builder patter, this is just a sample code on how
to actually implement it.
If the computer constructor has too many arguments, the client code that uses it may make a mistake, especially
if all the arguments are of the same type (the order of the parameters may be misplaced). The builder pattern helps here.
The way the computer object is constructed is masked by the Builder inner class.
Here the builder class just simply copes the String values to the Computers' fields.
It may be more complicated that that. For example, the computer object returned could be a JSON/XML object
 */

class Computer {
    private String motherboard;
    private String computerCase;
    private String soundCard;
    private String videoCard;
    private String HDD;
    private String RAM;
    private String powerSupply;

    //private constructor
    private Computer(String motherboard, String computerCase, String soundCard, String videoCard, String HDD, String RAM, String powerSupply) {
        this.motherboard = motherboard;
        this.computerCase = computerCase;
        this.soundCard = soundCard;
        this.videoCard = videoCard;
        this.HDD = HDD;
        this.RAM = RAM;
        this.powerSupply = powerSupply;
    }

    //only getter methods provided, no setter methods.
    public String getMotherboard() {
        return motherboard;
    }

    public String getComputerCase() {
        return computerCase;
    }

    public String getSoundCard() {
        return soundCard;
    }

    public String getVideoCard() {
        return videoCard;
    }

    public String getHDD() {
        return HDD;
    }

    public String getRAM() {
        return RAM;
    }

    public String getPowerSupply() {
        return powerSupply;
    }

    public static class Builder {
        private String motherboard;
        private String computerCase;
        private String soundCard;
        private String videoCard;
        private String HDD = "1TB"; //default value
        private String RAM = "16GB"; //default value
        private String powerSupply = "120V"; //default value

        //public constructor, which sets compulsory fields
        //assuming only the case and motherboard are compulsory fields
        public Builder(String motherBoard, String computerCase) {
            this.motherboard = motherBoard;
            this.computerCase = computerCase;
        }

        public Builder setSoundCard(String soundCard) {
            this.soundCard = soundCard;
            return this;
        }

        public Builder setVideoCard(String videoCard) {
            this.videoCard = videoCard;
            return this;
        }

        public Builder setHDD(String HDD) {
            this.HDD = HDD;
            return this;
        }

        public Builder setRAM(String RAM) {
            this.RAM = RAM;
            return this;
        }

        public Builder setPowerSupply(String powerSupply) {
            this.powerSupply = powerSupply;
            return this;
        }

        public Computer build() {
            return new Computer(motherboard, computerCase, soundCard, videoCard, HDD, RAM, powerSupply);
        }

    }
}

public class BuilderImpl {
    public static void main(String[] args) {
        Computer newComputer = new Computer.Builder("NEW MOTHER BOARD", "NEW CASE")
                .setSoundCard("NEW SOUND CARD").setVideoCard("GTI 1080").setPowerSupply("120 V").build();
        System.out.println(newComputer.getComputerCase());
        System.out.println(newComputer.getMotherboard());
        System.out.println(newComputer.getPowerSupply());
        System.out.println(newComputer.getSoundCard());
        System.out.println(newComputer.getVideoCard());
        System.out.println(newComputer.getHDD());
        System.out.println(newComputer.getRAM());
    }
}