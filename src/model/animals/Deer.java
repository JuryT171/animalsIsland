package model.animals;

import model.Animal;
import model.AnimalType;
import model.Island;
import model.Location;

public class Deer extends Animal {
    public Deer(Island island, Location location){
        super(AnimalType.DEER,island,location);
    }
    @Override
    protected Animal createNewAnimal(Island island,Location location){
        return new Deer(island,location);
    }
}
