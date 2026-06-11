package model.animals.herbivores;

import model.Animal;
import model.AnimalType;
import model.Island;
import model.Location;
import model.animals.Herbivore;
//лошадь
public class Horse extends Herbivore {
    public Horse(Island island, Location location){
        super(AnimalType.HORSE,island,location);
    }
    @Override
    protected Animal createNewAnimal(Island island, Location location){
        return new Horse(island,location);
    }
}
