package model.animals;

import model.Animal;
import model.AnimalType;
import model.Island;
import model.Location;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;


public abstract class Predator extends Animal {

    public Predator(AnimalType type, Island island, Location location) {
        super(type, island, location);
    }

    @Override
    public void eat() {
        if (!isAlive) return;

        // если сыт, не охотимся
        if (hungerLevel >= type.getFoodNeeded()) {
            metabolize();
            checkDeath();
            return;
        }

        // охота
        List<Animal> animalsInCell = location.getAnimals();
        for (Animal prey : animalsInCell) {
            if (prey == this || !prey.isAlive()) continue;

            // проверяем,съедобно ли
            int chance = type.getChanceToEat(prey.getType());
            if (chance > 0) {
                if (ThreadLocalRandom.current().nextInt(100) < chance) {
                    prey.die();
                    location.removeAnimal(prey);
                    hungerLevel += prey.getCurrentWeight();
                    //съели одно и выходим
                    metabolize();
                    checkDeath();
                    return;
                }
            }
        }

        // не поели -> штраф голода + метаболизм
        hungerLevel -= (type.getFoodNeeded() * 0.01);
        metabolize();
        checkDeath();
    }

    private void checkDeath() {
        if (hungerLevel <= 0) {
            die();
            location.removeAnimal(this);
        }
    }
}
