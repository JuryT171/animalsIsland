package model.animals.herbivores;

import model.Animal;
import model.AnimalType;
import model.Island;
import model.Location;
import model.animals.Herbivore;
import model.animals.Plant;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Duck extends Herbivore {
    public Duck(Island island, Location location){
        super(AnimalType.DUCK,island,location);
    }
    @Override
    protected Animal createNewAnimal(Island island,Location location){
        return new Duck(island,location);
    }
    @Override
    public void eat() {
        if (!isAlive) return;
        if (hungerLevel >= getType().getFoodNeeded()) {
            metabolize();
            checkDeath();
            return;
        }

        //сначала едим как травоядное
        List<Plant> plants = location.getPlants();
        if (!plants.isEmpty()) {
            Plant plant = plants.get(0);
            location.removePlant(plant);
            hungerLevel += plant.getWeight();
        }

        //  охотимся на гусеницу
        if (hungerLevel < getType().getFoodNeeded()) {
            hunt(AnimalType.CATERPILLAR);
        }
        metabolize();
        checkDeath();
    }
    // вспомогательный метод охоты
    private void hunt(AnimalType preyType) {
        List<Animal> animals = location.getAnimals();
        for (Animal prey : animals) {
            if (prey == this || !prey.isAlive()) continue;

            if (prey.getType() == preyType) {
                int chance = getType().getChanceToEat(preyType);
                if (ThreadLocalRandom.current().nextInt(90) < chance) {
                    prey.die();
                    location.removeAnimal(prey);
                    hungerLevel += prey.getCurrentWeight();
                    return;
                }
            }
        }
    }

    private void checkDeath() {
        if (hungerLevel <= 0) {
            die();
            location.removeAnimal(this);
        }
    }
}

