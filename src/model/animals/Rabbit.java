package model.animals;

import model.Animal;
import model.AnimalType;
import model.Island;
import model.Location;

public class Rabbit extends Animal {

    public Rabbit(Island island, Location location) {
        super(AnimalType.RABBIT, island, location);
    }

    @Override
    protected Animal createNewAnimal(Island island, Location location) {
        return new Rabbit(island, location);
    }
}
