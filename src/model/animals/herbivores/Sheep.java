package model.animals.herbivores;

import model.Animal;
import model.AnimalType;
import model.Island;
import model.Location;
import model.animals.Herbivore;

public class Sheep extends Herbivore {
    public Sheep(Island island, Location location){
        super(AnimalType.SHEEP,island,location);
    }
    @Override
    protected Animal createNewAnimal(Island island,Location location){
        return new Sheep(island,location);
    }
}
