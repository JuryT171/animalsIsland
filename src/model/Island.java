package model;

import java.util.ArrayList;
import java.util.List;

public class Island {
    private final int width; // длина
    private final int height; // ширина
    private final Location[][] locations; // двумерный массив

    public Island(int width, int height) {
        this.width = width;
        this.height = height;
        this.locations = new Location[width][height];
        initializeIsland();
    }

    // метод заполняет массив
    private void initializeIsland() {
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                locations[x][y] = new Location(x, y);
            }
        }
        System.out.println("Остров создан: " + width + "x" + height);
    }

    // получить локацию по координатам с проверкой границ
    public Location getLocation(int x, int y) {
        if (isWithinBounds(x, y)) {
            return locations[x][y];
        }
        return null; // если координата за пределами острова
    }

    // проверка, не вышли ли мы за край карты
    public boolean isWithinBounds(int x, int y) {
        return x >= 0 && x < width && y >= 0 && y < height;
    }

    // получаем список соседних клеток куда можно идти
    public List<Location> getNeighbors(Location current) { // навигатор для перемещения
        List<Location> neighbors = new ArrayList<>();
        int x = current.getX(); // текущие координаты
        int y = current.getY();

        if (isWithinBounds(x, y - 1)) {
            neighbors.add(locations[x][y - 1]);
        }
        if (isWithinBounds(x, y + 1)) {
            neighbors.add(locations[x][y + 1]);
        }
        if (isWithinBounds(x - 1, y)) {
            neighbors.add(locations[x - 1][y]);
        }
        if (isWithinBounds(x + 1, y)) {
            neighbors.add(locations[x + 1][y]);
        }
        return neighbors;
    }

    public int getWidth() {
        return width;
    }
    public int getHeight() {
        return height;
    }
}
