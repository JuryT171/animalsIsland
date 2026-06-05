package model;

import model.animals.Plant;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public abstract class Animal {
    protected AnimalType type;
    protected double currentWeight;
    protected boolean isAlive;
    protected double hungerLevel;
    protected Island island;
    protected Location location;

    public Animal(AnimalType type, Island island, Location location) {
        this.type = type;
        this.island = island;
        this.location = location;
        this.currentWeight = type.getWeight();
        this.isAlive = true;
        this.hungerLevel = type.getFoodNeeded();
    }
    // передвижение
    public void move() {
        if (!isAlive) return;

        int maxSteps = type.getSpeed();
        int actualSteps = ThreadLocalRandom.current().nextInt(maxSteps + 1); // рандом кол-во шагов

        for (int i = 0; i < actualSteps; i++) {
            List<Location> neighbors = island.getNeighbors(location); // список соседей
            if (neighbors.isEmpty()) break;
            Location target = neighbors.get(ThreadLocalRandom.current().nextInt(neighbors.size())); // выбираем клетку

            if (target.addAnimal(this)) { // пытаемся добавить животное,если клетки переполнены,остаемся в старой
                location.removeAnimal(this);  // удаляемся из старой клетки
                location = target; // записываемся в новую
            }
        }
    }

    public abstract void eat(); /* {
         if (!isAlive) return;

        // если голоден - охотится
        if (hungerLevel < type.getFoodNeeded()) {
            // поедание травы
             if (type.getDiet().containsKey(AnimalType.PLANT)) { // проверка на еду травы
                List<Plant> plants = location.getPlants();
                if (!plants.isEmpty()) {
                    Plant plant = plants.get(0); //берем первое
                    location.removePlant(plant); // обновляем
                    hungerLevel += plant.getWeight(); // уровень сытости
                }
            }
            // проверяем хищники\нет
            List<Animal> animalsInCell = location.getAnimals();
            for (Animal prey : animalsInCell) { // цикл по списку животных
                if (prey == this || !prey.isAlive()) continue; // условия

                int chance = type.getChanceToEat(prey.getType());
                if (chance > 0) {
                    if (ThreadLocalRandom.current().nextInt(100) < chance) {  // рандомное число
                        prey.die(); // съедаем
                        location.removeAnimal(prey);  // обновляем
                        hungerLevel += prey.getCurrentWeight();
                        prey.getType();
                    }
                }
            }
            // уменьшаем жизнь, если не поели
            hungerLevel -= (type.getFoodNeeded() * 0.1);
        }
        metabolize();
        if (hungerLevel <= 0) {
            die();
            location.removeAnimal(this);
        }
    } */

    // размножение
    public void reproduce() {
        if (!isAlive) return;

        // ограничиваем условия размножения
        if (hungerLevel < type.getFoodNeeded() * 0.5) return;

        List<Animal> animalsInCell = location.getAnimals(); // берем всех животных в клетке
        long sameSpeciesCount = animalsInCell.stream()
                .filter(a -> a.getType() == this.type && a != this && a.isAlive)
                .count(); // тот же тип, не я, и живой, считаем

        if (sameSpeciesCount >= 1) {
            if (Math.random() < 0.2) { // 20% вероятность
                Animal baby = createNewAnimal(island, location); // рождение
                if (location.addAnimal(baby)) { // добавляем в клетку
                }
                if (location.addAnimal(baby)) {
                    AnimalType.incrementBorn();
                }
            }
        }

    }
    public void die() {
        this.isAlive = false;
        AnimalType.incrementDied();
    }
    // голодание
    protected void metabolize() {
        double energyCost = type.getFoodNeeded() * 0.01;
        hungerLevel -= energyCost;
    }

    // фабричный метод создания животного
    protected abstract Animal createNewAnimal(Island island, Location location);

    public AnimalType getType() {
        return type;
    }

    public Location getLocation() {
        return location;
    }

    public double getCurrentWeight() {
        return currentWeight;
    }

    public boolean isAlive() {
        return isAlive;
    }
    @Override
    public String toString() {
        return type.getIcon();
    }
}

