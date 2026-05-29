package model.animals.herbivores;

import model.Animal;
import model.AnimalType;
import model.Island;
import model.Location;
import model.animals.Herbivore;

public class Deer extends Herbivore {
    public Deer(Island island, Location location){
        super(AnimalType.DEER,island,location);
    }
    @Override
    protected Animal createNewAnimal(Island island,Location location){
        return new Deer(island,location);
    }
}
