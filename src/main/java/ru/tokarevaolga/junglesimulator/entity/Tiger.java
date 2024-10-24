package ru.tokarevaolga.junglesimulator.entity;

public class Tiger {

    private int health = 100; // health points (сокращённо hp для статуса баланса)
    private int energy = 100;
    private final double fangs = 2.5; // fangs energy producing coefficient

    public void setHealth(int health) { // сюда приходит какое-то значение health
        this.health = health; // пришедшее нам health
    }

    public int getHealth() {
        return health;
    }

    public int getEnergy() {
        return energy;
    }

    public void setEnergy(int energy) {
        this.energy = energy;
    }

    public double getFangs() {
        return fangs;
    }

    public int levelCorrector(int x) { //новый метод для проверки/корректировки уровня energy/health
        if (x < 0) {
            x = 0;
        }
        if (x > 100) {
            x = 100;
        }
        return x;
    }
}
