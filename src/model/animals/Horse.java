package model.animals;

import model.Animal;
import model.AnimalType;
import model.Island;
import model.Location;

public class Horse extends Animal {
    public Horse(Island island, Location location){
        super(AnimalType.HORSE,island,location);
    }
    @Override
    protected Animal createNewAnimal(Island island, Location location){
        return new Horse(island,location);
    }
}
