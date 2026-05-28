package model.animals;

import model.Animal;
import model.AnimalType;
import model.Island;
import model.Location;

public class Boar extends Animal {
    public Boar(Island island, Location location){
        super(AnimalType.BOAR,island,location);
    }
    @Override
    protected Animal createNewAnimal(Island island,Location location){
        return new Boar(island,location);
    }
}
