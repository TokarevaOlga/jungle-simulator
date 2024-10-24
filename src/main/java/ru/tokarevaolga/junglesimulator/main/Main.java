package ru.tokarevaolga.junglesimulator.main;

import ru.tokarevaolga.junglesimulator.entity.Tiger;
import ru.tokarevaolga.junglesimulator.util.EventSimulator;

public class Main {

    public static void main(String[] args) {
        Tiger tiger = new Tiger();
        EventSimulator eventSimulator = new EventSimulator(); // создаем объект класса, тк класс не static
        eventSimulator.startSimulation(tiger);
    }
}