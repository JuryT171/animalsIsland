package model.animals.predators;

import model.Animal;
import model.AnimalType;
import model.Island;
import model.Location;
import model.animals.Predator;
//медведь
public class Bear extends Predator {
    public Bear(Island island, Location location){
        super(AnimalType.BEAR,island,location);
    }
    @Override
    protected Animal createNewAnimal(Island island,Location location){
        return new Bear(island,location);
    }
}
