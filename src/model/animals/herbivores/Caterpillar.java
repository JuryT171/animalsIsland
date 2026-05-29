package model.animals.herbivores;

import model.Animal;
import model.AnimalType;
import model.Island;
import model.Location;
import model.animals.Herbivore;

public class Caterpillar extends Herbivore {
    public Caterpillar(Island island, Location location){
        super(AnimalType.CATERPILLAR,island,location);
    }
    @Override
    protected Animal createNewAnimal(Island island,Location location){
        return new Caterpillar(island,location);
    }
}
