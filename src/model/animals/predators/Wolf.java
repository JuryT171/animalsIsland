package model.animals.predators;

import model.Animal;
import model.AnimalType;
import model.Island;
import model.Location;
import model.animals.Predator;
//волк
public class Wolf extends Predator {

    public Wolf(Island island, Location location) {
        super(AnimalType.WOLF, island, location);
    }

    // детеныш
    @Override
    protected Animal createNewAnimal(Island island, Location location) {
        return new Wolf(island, location);
    }
}
