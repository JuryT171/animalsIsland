package model.animals.predators;

import model.Animal;
import model.AnimalType;
import model.Island;
import model.Location;
import model.animals.Predator;
//орел
public class Eagle extends Predator {
    public Eagle(Island island, Location location){
        super(AnimalType.EAGLE,island,location);
    }
    @Override
    protected Animal createNewAnimal(Island island,Location location){
        return new Eagle(island,location);
    }
}
