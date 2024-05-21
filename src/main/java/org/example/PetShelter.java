package org.example;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PetShelter {
    private List<Pet> pets;
    private static final String DATA_FILE = "src/main/resources/pets.json";
    private ObjectMapper mapper;

    public PetShelter() {
        mapper = new ObjectMapper();
        pets = new ArrayList<>();
    }

    public void addPet(Pet pet) {
        pets.add(pet);
    }

    public void showAllPets() {
        if (pets.isEmpty()) {
            System.out.println("No pets in the shelter.");
        } else {
            for (int i = 0; i < pets.size(); i++) {
                System.out.println(i + ". " + pets.get(i));
            }
        }
    }

    public void removePet(int index) {
        if (index >= 0 && index < pets.size()) {
            pets.remove(index);
            System.out.println("Pet removed.");
        } else {
            System.out.println("Invalid index.");
        }
    }

    public List<Pet> searchPets(String keyword) {
        return pets.stream()
                .filter(p -> p.getName().equalsIgnoreCase(keyword) || p.getBreed().equalsIgnoreCase(keyword))
                .collect(Collectors.toList());
    }

    public Pet getPet(int index) {
        if (index >= 0 && index < pets.size()) {
            return pets.get(index);
        }
        return null;
    }

    public void savePets() {
        try {
            mapper.writeValue(new File(DATA_FILE), pets);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadPets() {
        try {
            File file = new File(DATA_FILE);
            if (file.exists()) {
                pets = mapper.readValue(file, new TypeReference<List<Pet>>() {});
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Pet> getPets() {
        return pets;
    }
}