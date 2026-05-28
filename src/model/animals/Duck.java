package model.animals;

import model.Animal;
import model.AnimalType;
import model.Island;
import model.Location;

public class Duck extends Animal {
    public Duck(Island island, Location location){
        super(AnimalType.DUCK,island,location);
    }
    @Override
    protected Animal createNewAnimal(Island island,Location location){
        return new Duck(island,location);
    }
}
