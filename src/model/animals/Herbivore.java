package model.animals;

import model.Animal;
import model.AnimalType;
import model.Island;
import model.Location;

import java.util.List;

public abstract class Herbivore extends Animal {
    public Herbivore(AnimalType type, Island island, Location location) {
        super(type, island, location);
    }
    @Override
    public void eat() {
        if (!isAlive) return;

        // если сыт, не ищем еду
        if (hungerLevel >= type.getFoodNeeded()) {
            metabolize();
            checkDeath();
            return;
        }

        // только для растений
        List<Plant> plants = location.getPlants();
        if (!plants.isEmpty()) {
            Plant plant = plants.get(0);
            location.removePlant(plant);
            hungerLevel += plant.getWeight();
        }

        metabolize();
        checkDeath();
    }

    // проверка на смерть
    private void checkDeath() {
        if (hungerLevel <= 0) {
            die();
            location.removeAnimal(this);
        }
    }
}
