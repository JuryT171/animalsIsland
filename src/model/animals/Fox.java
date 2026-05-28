package model.animals;

import model.Animal;
import model.AnimalType;
import model.Island;
import model.Location;

public class Fox extends Animal {
    public Fox(Island island, Location location){
         super (AnimalType.SNAKE,island,location);
    }
    @Override
    protected Animal createNewAnimal(Island island,Location location){
        return new Fox(island,location);
    }
}
