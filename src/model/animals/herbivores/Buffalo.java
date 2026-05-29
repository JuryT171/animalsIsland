package model.animals.herbivores;

import model.Animal;
import model.AnimalType;
import model.Island;
import model.Location;
import model.animals.Herbivore;

public class Buffalo extends Herbivore {
    public Buffalo(Island island, Location location){
        super(AnimalType.BUFFALO,island,location);
    }
    @Override
    protected Animal createNewAnimal(Island island,Location location){
        return new Buffalo(island,location);
    }
}
