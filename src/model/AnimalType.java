package model;

import java.util.Map;
import java.util.HashMap;
//энумкласс
public enum AnimalType {
    // хищники
    WOLF(50.0, 30, 3, 8, "🐺") { //  параметры волка

        @Override
        public Map<AnimalType, Integer> getDiet() {  // возможность кого то сьесть
            Map<AnimalType, Integer> diet = new HashMap<>();
            diet.put(AnimalType.HORSE, 10);
            diet.put(AnimalType.DEER, 15);
            diet.put(AnimalType.RABBIT, 60);
            diet.put(AnimalType.MOUSE, 80);
            diet.put(AnimalType.GOAT, 60);
            diet.put(AnimalType.SHEEP, 70);
            diet.put(AnimalType.BOAR, 15);
            diet.put(AnimalType.BUFFALO, 10);
            diet.put(AnimalType.DUCK, 40);
            return diet;
        }
    },
    SNAKE(15.0, 20, 2, 3, "🐍") { // Удав

        @Override
        public Map<AnimalType, Integer> getDiet() {
            Map<AnimalType, Integer> diet = new HashMap<>();
            diet.put(AnimalType.FOX, 15);
            diet.put(AnimalType.RABBIT, 20);
            diet.put(AnimalType.MOUSE, 40);
            diet.put(AnimalType.DUCK, 10);
            return diet;
        }
    },
    FOX(8.0, 30, 2, 2, "🦊") {
        @Override
        public Map<AnimalType, Integer> getDiet() {
            Map<AnimalType, Integer> diet = new HashMap<>();
            diet.put(AnimalType.RABBIT, 70);
            diet.put(AnimalType.MOUSE, 90);
            diet.put(AnimalType.DUCK, 60);
            diet.put(AnimalType.CATERPILLAR, 40);
            return diet;
        }
    },
    BEAR(500.0, 5, 2, 80, "🐻") {
        @Override
        public Map<AnimalType, Integer> getDiet() {
            Map<AnimalType, Integer> diet = new HashMap<>();
            diet.put(AnimalType.SNAKE, 80);
            diet.put(AnimalType.HORSE, 40);
            diet.put(AnimalType.DEER, 80);
            diet.put(AnimalType.RABBIT, 80);
            diet.put(AnimalType.MOUSE, 90);
            diet.put(AnimalType.GOAT, 70);
            diet.put(AnimalType.SHEEP, 70);
            diet.put(AnimalType.BOAR, 50);
            diet.put(AnimalType.BUFFALO, 20);
            diet.put(AnimalType.DUCK, 10);
            return diet;
        }
    },
    EAGLE(6.0, 20, 3, 1, "🦅") {
        @Override
        public Map<AnimalType, Integer> getDiet() {
            Map<AnimalType, Integer> diet = new HashMap<>();
            diet.put(AnimalType.FOX, 10);
            diet.put(AnimalType.RABBIT, 90);
            diet.put(AnimalType.MOUSE, 90);
            diet.put(AnimalType.DUCK, 80);
            return diet;
        }
    },

    // травоядные
    HORSE(400.0, 20, 4, 60, "🐎") {
        @Override
        public Map<AnimalType, Integer> getDiet() {
            return Map.of(AnimalType.PLANT, 100);
        }
    },
    DEER(300.0, 20, 4, 50, "🦌") {
        @Override
        public Map<AnimalType, Integer> getDiet() {
            return Map.of(AnimalType.PLANT, 100);
        }
    },
    RABBIT(2.0, 130, 2, 0.45, "🐇") {
        @Override
        public Map<AnimalType, Integer> getDiet() {
            return Map.of(AnimalType.PLANT, 100);
        }
    },
    MOUSE(0.05, 500, 1, 0.01, "🐁") {
        @Override
        public Map<AnimalType, Integer> getDiet() {
            Map<AnimalType, Integer> diet = new HashMap<>();
            diet.put(AnimalType.PLANT, 100);
            diet.put(AnimalType.CATERPILLAR, 90);
            return diet;
        }
    },
    GOAT(60.0, 140, 3, 10, "🐐") {
        @Override
        public Map<AnimalType, Integer> getDiet() {
            return Map.of(AnimalType.PLANT, 100);
        }
    },
    SHEEP(70.0, 140, 3, 15, "🐑") {
        @Override
        public Map<AnimalType, Integer> getDiet() {
            return Map.of(AnimalType.PLANT, 100);
        }
    },
    BOAR(400.0, 50, 2, 50, "🐗") {
        @Override
        public Map<AnimalType, Integer> getDiet() {
            Map<AnimalType, Integer> diet = new HashMap<>();
            diet.put(AnimalType.MOUSE, 50);
            diet.put(AnimalType.CATERPILLAR, 90);
            diet.put(AnimalType.PLANT, 100);
            return diet;
        }
    },
    BUFFALO(700.0, 10, 3, 100, "🐃") {
        @Override
        public Map<AnimalType, Integer> getDiet() {
            return Map.of(AnimalType.PLANT, 100);
        }
    },
    DUCK(1.0, 200, 4, 0.15, "🦆") {
        @Override
        public Map<AnimalType, Integer> getDiet() {
            Map<AnimalType, Integer> diet = new HashMap<>();
            diet.put(AnimalType.CATERPILLAR, 90);
            diet.put(AnimalType.PLANT, 100);
            return diet;
        }
    },
    CATERPILLAR(0.01, 1000, 0, 0, "🐛") {
        @Override
        public Map<AnimalType, Integer> getDiet() {
            return Map.of(AnimalType.PLANT, 100);
        }
    },

    // растения
    PLANT(1.0, 200, 0, 0, "🌿") {
        @Override
        public Map<AnimalType, Integer> getDiet() {
            return new HashMap<>(); // растения никого не едят
        }
    };
    //поля
    private final double weight; // вес
    private final int maxPerCell; // макс колличество
    private final int speed; // скорость перемещения по клеткам
    private final double foodNeeded; // кол-во еды для насыщения
    private final String icon; // аватарка

    private static int eaten;
    private static int born;
    private static int died;

    public static int getEaten() {
        return eaten;
    }
    public static int getBorn() {
        return born;
    }
    public static int getDied() {
        return died;
    }

    // сброс счетчиков
    public static void resetStats() {
        eaten = 0;
        born = 0;
        died = 0;
    }
    // счетчики
    public static void incrementEaten() {
        eaten++;
    }

    public static void incrementBorn() {
        born++;
    }

    public static void incrementDied() {
        died++;
    }


    // конструктор
    AnimalType(double weight, int maxPerCell, int speed, double foodNeeded, String icon) {
        this.weight = weight;
        this.maxPerCell = maxPerCell;
        this.speed = speed;
        this.foodNeeded = foodNeeded;
        this.icon = icon;
    }

    // геттеры
    public double getWeight() {
        return weight;
    }

    public int getMaxPerCell() {
        return maxPerCell;
    }

    public int getSpeed() {
        return speed;
    }

    public double getFoodNeeded() {
        return foodNeeded;
    }

    public String getIcon() {
        return icon;
    }

    // абстрактный метод для животных
    public abstract Map<AnimalType, Integer> getDiet();

    // метод шанса сьесть кого то
    public int getChanceToEat(AnimalType prey) {
        return getDiet().getOrDefault(prey, 0);
    }
}

