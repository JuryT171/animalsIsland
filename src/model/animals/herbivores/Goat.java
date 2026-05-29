package model.animals.herbivores;

import model.Animal;
import model.AnimalType;
import model.Island;
import model.Location;
import model.animals.Herbivore;

public class Goat extends Herbivore {
    public Goat(Island island, Location location){
        super(AnimalType.GOAT,island,location);
    }
    @Override
    protected Animal createNewAnimal(Island island,Location location){
        return new Goat(island, location);
    }
}
