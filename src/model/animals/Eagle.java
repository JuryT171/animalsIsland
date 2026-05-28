package model.animals;

import model.Animal;
import model.AnimalType;
import model.Island;
import model.Location;

public class Eagle extends Animal {
    public Eagle(Island island, Location location){
        super(AnimalType.EAGLE,island,location);
    }
    @Override
    protected Animal createNewAnimal(Island island,Location location){
        return new Eagle(island,location);
    }
}
