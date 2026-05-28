package model.animals;

import model.Animal;
import model.AnimalType;
import model.Island;
import model.Location;

public class Sheep extends Animal {
    public Sheep(Island island, Location location){
        super(AnimalType.SHEEP,island,location);
    }
    @Override
    protected Animal createNewAnimal(Island island,Location location){
        return new Sheep(island,location);
    }
}
