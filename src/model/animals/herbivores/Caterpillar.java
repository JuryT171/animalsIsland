package model.animals.herbivores;

import model.Animal;
import model.AnimalType;
import model.Island;
import model.Location;
import model.animals.Herbivore;
import model.animals.Plant;

import java.util.List;
// гусеница
public class Caterpillar extends Herbivore {
    public Caterpillar(Island island, Location location){
        super(AnimalType.CATERPILLAR,island,location);
    }
    @Override
    protected Animal createNewAnimal(Island island,Location location){
        return new Caterpillar(island,location);
    }
    @Override
    public void eat() {
        //растения
        List<Plant> plants = location.getPlants();
        if (!plants.isEmpty()) {
            Plant plant = plants.get(0);
            location.removePlant(plant);
            hungerLevel += plant.getWeight();
        }
        metabolize();
        if (hungerLevel <= 0) {
            die();
            location.removeAnimal(this);
        }
    }
}
