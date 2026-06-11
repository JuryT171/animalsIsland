package model.animals.herbivores;

import model.Animal;
import model.AnimalType;
import model.Island;
import model.Location;
import model.animals.Herbivore;
import model.animals.Plant;
import model.animals.Predator;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
//кабан
public class Boar extends Herbivore {
    public Boar(Island island, Location location){
        super(AnimalType.BOAR,island,location);
    }
    protected Animal createNewAnimal(Island island,Location location){
        return new Boar(island,location);
    }
    @Override
    public void eat() {
        if (!isAlive) return;
        if (hungerLevel >= getType().getFoodNeeded()) {
            metabolize();
            checkDeath();
            return;
        }

        // растения
        List<Plant> plants = location.getPlants();
        if (!plants.isEmpty()) {
            Plant plant = plants.get(0);
            location.removePlant(plant);
            hungerLevel += plant.getWeight();
        }

        // охота на мышь
        if (hungerLevel < getType().getFoodNeeded()) {
            hunt(AnimalType.MOUSE);
        }

        // охота на гусеницу
        if (hungerLevel < getType().getFoodNeeded()) {
            hunt(AnimalType.CATERPILLAR);
        }
        metabolize();
        checkDeath();
    }
    private void hunt(AnimalType preyType) {
        List<Animal> animals = location.getAnimals();
        for (Animal prey : animals) {
            if (prey == this || !prey.isAlive()) continue;
            if (prey.getType() == preyType) {
                int chance = getType().getChanceToEat(preyType);
                if (ThreadLocalRandom.current().nextInt(100) < chance) {
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
