package model.animals;

import model.Animal;
import model.AnimalType;
import model.Island;
import model.Location;

public class Wolf extends Animal {

    public Wolf(Island island, Location location) {
        super(AnimalType.WOLF, island, location);
    }

    // детеныш
    @Override
    protected Animal createNewAnimal(Island island, Location location) {
        return new Wolf(island, location);
    }
}
