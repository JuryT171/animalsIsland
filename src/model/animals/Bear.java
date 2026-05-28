package model.animals;

import model.Animal;
import model.AnimalType;
import model.Island;
import model.Location;

public class Bear extends Animal {
    public Bear(Island island, Location location){
        super(AnimalType.BEAR,island,location);
    }
    @Override
    protected Animal createNewAnimal(Island island,Location location){
        return new Bear(island,location);
    }
}
