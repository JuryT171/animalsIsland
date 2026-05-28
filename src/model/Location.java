package model;

import model.animals.Plant;

import java.util.ArrayList;
import java.util.List;

public class Location {
    private final int x; // координаты клетки
    private final int y;
    private final List<Animal> animals = new ArrayList<>(); // животные
    private final List<Plant> plants = new ArrayList<>();  //  трава

    public Location(int x, int y) {
        this.x = x;
        this.y = y;
    }

    // синхронайзед,для потокобезопасности
    public synchronized boolean addAnimal(Animal animal) {
        int maxCount = animal.getType().getMaxPerCell(); // считаем кол-во животных, тип и макс кол-во на клетку

        long currentCount = animals.stream()
                .filter(a -> a.getType() == animal.getType())
                .count(); // считаем сколько животных в клетке

        if (currentCount < maxCount) {
            animals.add(animal); // если все ок, добавляем
            return true;
        }
        return false;
    }
    // метод удаления животного
    public synchronized void removeAnimal(Animal animal) {
        animals.remove(animal);
    }
    // метод добавление травы
    public synchronized void addPlant(Plant plant) {
        if (plants.size() < AnimalType.PLANT.getMaxPerCell()) {
            plants.add(plant);
        }
    }

    public synchronized void removePlant(Plant plant) {
        plants.remove(plant);
    }

    public synchronized List<Animal> getAnimals() {
        return new ArrayList<>(animals); // возвращаем копию, чтобы безопасно перебирать в процессе
    }

    public synchronized List<Plant> getPlants() {
        return new ArrayList<>(plants);
    }

    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
}
