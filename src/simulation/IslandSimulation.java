package simulation;

import model.Animal;
import model.AnimalType;
import model.Island;
import model.Location;
import model.animals.*;
import model.animals.herbivores.*;
import model.animals.predators.*;

import java.util.*;
import java.util.concurrent.*;

public class IslandSimulation {
    private final Island island;
    private final ScheduledExecutorService scheduler;
    private final ExecutorService animalExecutor; // Пул для животных
    private final int width = 100;
    private final int height = 20;

    public IslandSimulation() {
        this.island = new Island(width, height);
        // таймер
        this.scheduler = Executors.newScheduledThreadPool(1);
        // пул потоков на 4 животных
        this.animalExecutor = Executors.newFixedThreadPool(4);
    }

    public void start() {
        System.out.println("Остров начал жить!");
        populateIsland();

        // такт запуска 2 сек
        scheduler.scheduleAtFixedRate(this::runOneDay, 0, 2, TimeUnit.SECONDS);
    }

    private void runOneDay() {
        System.out.println("---Начался новый день---");

        growPlants();
        processAnimals();
        printStatistics();
    }

    private void growPlants() {
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                Location loc = island.getLocation(x, y);
                if (Math.random() < 0.7) {
                    loc.addPlant(new Plant()); //  выращиваем растение с 70% вероятностью
                }
            }
        }
    }

    private void processAnimals() {
        // собираем животных
        List<Animal> allAnimals = new ArrayList<>();
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                allAnimals.addAll(island.getLocation(x, y).getAnimals());
            }
        }

        // список задач животных
        List<Runnable> tasks = new ArrayList<>();
        for (Animal animal : allAnimals) {
            tasks.add(() -> {
                animal.eat();
                animal.move();
                animal.reproduce();
            });
        }
        // запускаем задачи в пуле и ждем завершения
        try {
            List<Future<?>> futures = new ArrayList<>();
            for (Runnable task : tasks) {
                futures.add(animalExecutor.submit(task));
            }
            // ждем, пока все звери закончат свои дела перед следующим днем
            for (Future<?> future : futures) {
                future.get(); // доделываем дела
            }
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }

    private void printStatistics() {
        System.out.println("===== Статистика острова =====");

        Map<String, Integer> stats = new HashMap<>();

        int totalAnimals = 0;
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                List<Animal> animals = island.getLocation(x, y).getAnimals();
                totalAnimals += animals.size();

                for (Animal animal : animals) {
                    String icon = animal.toString(); // получаем иконку
                    stats.put(icon, stats.getOrDefault(icon, 0) + 1); // кладем в мапу
                }
            }
        }
        // вывод
        for (Map.Entry<String, Integer> entry : stats.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }

        System.out.println("Всего животных: " + totalAnimals);
        System.out.println("==============================");
    }

    // Метод для первоначального заселения (создаем по паре каждого вида)
    private void populateIsland() {
        Random random = new Random();

        // Перебираем все виды животных из Enum
        for (AnimalType type : AnimalType.values()) {
            if (type == AnimalType.PLANT) continue; // Растения не заселяем здесь

            // создаем особи
            int countToCreate = random.nextInt(50) + 51;

            for (int i = 0; i < countToCreate; i++) {
                // Случайные координаты
                int x = random.nextInt(width);
                int y = random.nextInt(height);
                Location loc = island.getLocation(x, y);

                Animal animal = createAnimal(type, loc);

                if (animal != null) {
                    boolean added = loc.addAnimal(animal);
                    if (!added) {
                        // Если случайно попали в переполненную клетку, просто игнорируем
                    }
                }
            }
        }
        System.out.println("Остров заселен случайными животными.");
    }
    // фабрика
    private Animal createAnimal(AnimalType type, Location location) {
        switch (type) {
            case AnimalType.WOLF: return new Wolf(island, location);
            case AnimalType.RABBIT: return new Rabbit(island, location);
            case AnimalType.SNAKE: return new Snake(island,location);
            case AnimalType.FOX: return new Fox(island,location);
            case AnimalType.BEAR: return new Bear(island,location);
            case AnimalType.EAGLE: return new Eagle(island,location);
            case AnimalType.HORSE: return new Horse(island,location);
            case AnimalType.DEER: return new Deer(island,location);
            case AnimalType.MOUSE: return new Mouse(island,location);
            case AnimalType.GOAT: return new Goat(island,location);
            case AnimalType.SHEEP: return new Sheep(island,location);
            case AnimalType.BOAR: return new Boar(island,location);
            case AnimalType.BUFFALO: return new Buffalo(island,location);
            case AnimalType.DUCK: return new Duck(island,location);
            case AnimalType.CATERPILLAR: return new Caterpillar(island,location);

            default: return null; // если класс еще не создан, возвращаем null
        }
    }
}
