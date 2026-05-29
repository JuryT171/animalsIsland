package model.animals.predators;

import model.Animal;
import model.AnimalType;
import model.Island;
import model.Location;
import model.animals.Predator;

public class Boar extends Predator {
    public Boar(Island island, Location location){
        super(AnimalType.BOAR,island,location);
    }
    @Override
    protected Animal createNewAnimal(Island island,Location location){
        return new Boar(island,location);
    }
}
