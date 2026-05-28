package model.animals;

import model.Animal;
import model.AnimalType;
import model.Island;
import model.Location;

public class Goat extends Animal {
    public Goat(Island island, Location location){
        super(AnimalType.GOAT,island,location);
    }
    @Override
    protected Animal createNewAnimal(Island island,Location location){
        return new Goat(island, location);
    }
}
