package model.animals;

import model.Animal;
import model.AnimalType;
import model.Island;
import model.Location;

public class Mouse extends Animal {
    public Mouse(Island island, Location location){
        super(AnimalType.MOUSE,island,location);
    }
    @Override
    protected Animal createNewAnimal(Island island,Location location){
        return new Mouse(island,location);
    }
}
