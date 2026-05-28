package model.animals;

import model.Animal;
import model.AnimalType;
import model.Island;
import model.Location;

public class Caterpillar extends Animal {
    public Caterpillar(Island island, Location location){
        super(AnimalType.CATERPILLAR,island,location);
    }
    @Override
    protected Animal createNewAnimal(Island island,Location location){
        return new Caterpillar(island,location);
    }
}
