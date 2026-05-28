package model.animals;

import model.Animal;
import model.AnimalType;
import model.Island;
import model.Location;

public class Buffalo extends Animal {
    public Buffalo(Island island, Location location){
        super(AnimalType.BUFFALO,island,location);
    }
    @Override
    protected Animal createNewAnimal(Island island,Location location){
        return new Buffalo(island,location);
    }
}
