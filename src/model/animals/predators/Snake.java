package model.animals.predators;

import model.Animal;
import model.AnimalType;
import model.Island;
import model.Location;
import model.animals.Predator;

public class Snake extends Predator {
    public Snake(Island island, Location location){
        super(AnimalType.SNAKE,island,location);
    }
    @Override
    protected Animal createNewAnimal(Island island, Location location){
        return new Snake(island,location);
    }
}
