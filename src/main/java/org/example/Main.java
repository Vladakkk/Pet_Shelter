package org.example;


public class Main {
    public static void main(String[] args) {
        PetShelter shelter = new PetShelter();
        UserInterface ui = new UserInterface(shelter);
        ui.start();
    }
}