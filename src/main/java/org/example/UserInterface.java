package org.example;

import java.util.Scanner;

public class UserInterface {
    private PetShelter shelter;
    private Scanner scanner;

    public UserInterface(PetShelter shelter) {
        this.shelter = shelter;
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        shelter.loadPets();

        while (true) {
            printMenu();
            String command = scanner.nextLine();

            if (command.equals("exit")) {
                shelter.savePets();
                System.out.println("Exiting program.");
                break;
            }

            handleCommand(command);
        }
    }

    private void printMenu() {
        System.out.println("1. Add pet (add pet)");
        System.out.println("2. Show all pets (show all)");
        System.out.println("3. Remove pet (take pet from shelter)");
        System.out.println("4. Exit (exit)");
        System.out.print("Enter your command: ");
    }

    private void handleCommand(String command) {
        switch (command) {
            case "add pet":
                addPet();
                break;
            case "show all":
                shelter.showAllPets();
                break;
            case "take pet from shelter":
                removePet();
                break;
            default:
                System.out.println("Unknown command.");
                break;
        }
    }

    private void addPet() {
        System.out.print("Enter pet name: ");
        String name = scanner.nextLine();
        System.out.print("Enter pet breed: ");
        String breed = scanner.nextLine();
        System.out.print("Enter pet age: ");
        int age = Integer.parseInt(scanner.nextLine());
        Pet pet = new Pet(name, breed, age);
        shelter.addPet(pet);
        System.out.println("Pet added.");
    }

    private void removePet() {
        shelter.showAllPets();
        System.out.print("Enter the index of the pet to remove: ");
        int index = Integer.parseInt(scanner.nextLine());
        shelter.removePet(index);
    }
}