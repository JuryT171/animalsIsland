package model.animals.herbivores;

import model.Animal;
import model.AnimalType;
import model.Island;
import model.Location;
import model.animals.Herbivore;

public class Rabbit extends Herbivore {

    public Rabbit(Island island, Location location) {
        super(AnimalType.RABBIT, island, location);
    }

    @Override
    protected Animal createNewAnimal(Island island, Location location) {
        return new Rabbit(island, location);
    }
}
