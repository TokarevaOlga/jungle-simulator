package ru.tokarevaolga.junglesimulator.util;

import ru.tokarevaolga.junglesimulator.entity.Tiger;

public class EventSimulator {

    public void startSimulation(Tiger tiger) {
        //Math.random - вероятность от 0 до 1. Приведём к процентной вероятности:
        //0.0 * 100 = 0
        //Например, 0.46 * 100 = 46.0 => (int) => 46
        //1.0 * 100 = 100
        while (checkStatus(tiger)) {
            int eventNumber = (int) (Math.random() * 100);
            if (eventNumber >= 0 && eventNumber < 20) {
                sleepEvent(tiger);
            } else if (eventNumber >= 20 && eventNumber < 30) {
                moveEvent(tiger);
            } else if (eventNumber >= 30 && eventNumber < 40) {
                eatBoarEvent(tiger);
            } else if (eventNumber >= 40 && eventNumber < 50) {
                eatMonkeyEvent(tiger);
            } else if (eventNumber >= 50 && eventNumber < 60) {
                eatFishEvent(tiger);
            } else if (eventNumber >= 60 && eventNumber < 65) {
                eatFruitEvent(tiger);
            } else if (eventNumber >= 65 && eventNumber < 80) {
                drinkEvent(tiger);
            } else if (eventNumber >= 80 && eventNumber < 85) {
                diseaseEvent(tiger);
            } else if (eventNumber >= 85 && eventNumber < 90) {
                fightEvent(tiger);
            } else if (eventNumber >= 90 && eventNumber < 100) {
                hunterAttackEvent(tiger);
            }
            try {
                Thread.sleep(1000); // Усыпление потока. Ошибка потребовала согласиться на try-catch
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("THE END! Тигр умер!");
    }

    private void sleepEvent(Tiger tiger) { // Событие 1. Тигр поспал.
        int energy = tiger.getEnergy();
        energy = energy + 7;
        /*if (energy > 100) {
            energy = 100;
        }*/
        energy = tiger.levelCorrector(energy);//новый метод
        tiger.setEnergy(energy);
        checkEnergy(tiger);
        System.out.println("Тигр поспал! +7 энергии. Текущая энергия: " + tiger.getEnergy());
    }

    private void moveEvent(Tiger tiger) { // Событие 2. Тигр побегал.
        int energy = tiger.getEnergy();
        energy = energy - 5;
        /*if (energy < 0) {
            energy = 0;
        }*/
        energy = tiger.levelCorrector(energy);//новый метод
        tiger.setEnergy(energy);
        checkEnergy(tiger);
        System.out.println("Тигр побегал! -5 энергии. Текущая энергия: " + tiger.getEnergy());
    }

    private void eatBoarEvent(Tiger tiger) { // Событие 3. Тигр съел кабана.
        int energy = tiger.getEnergy();
        int health = tiger.getHealth();
        energy = energy - 7;
       /* if (energy < 0) {
            energy = 0;
        }*/
        energy = tiger.levelCorrector(energy);//новый метод
        health = health + (int) (tiger.getFangs() * 4);
        /*if (health > 100) {
            health = 100;
        }*/
        health = tiger.levelCorrector(health);//новый метод
        tiger.setEnergy(energy);
        tiger.setHealth(health);
        checkEnergy(tiger);
        System.out.println("Тигр съел кабана! -7 энергии. Текущая энергия: " + tiger.getEnergy() + ". Улучшил здоровье до " + tiger.getHealth());
    }

    private void eatMonkeyEvent(Tiger tiger) { // Событие 4. Тигр съел обезьяну.
        int energy = tiger.getEnergy();
        int health = tiger.getHealth();
        energy = energy - 5;
       /* if (energy < 0) {
            energy = 0;
        }*/
        energy = tiger.levelCorrector(energy);//новый метод
        health = health + (int) (tiger.getFangs() * 3);
       /* if (health > 100) {
            health = 100;
        }*/
        health = tiger.levelCorrector(health);//новый метод
        tiger.setEnergy(energy);
        tiger.setHealth(health);
        checkEnergy(tiger);
        System.out.println("Тигр съел обезьяну! -5 энергии. Текущая энергия: " + tiger.getEnergy() + ". Улучшил здоровье до " + tiger.getHealth());
    }

    private void eatFishEvent(Tiger tiger) { // Событие 5. Тигр поймал и съел рыбу.
        int energy = tiger.getEnergy();
        int health = tiger.getHealth();
        energy = energy - 2;
        /*if (energy < 0) {
            energy = 0;
        }*/
        energy = tiger.levelCorrector(energy);//новый метод
        health = health + (int) (tiger.getFangs() * 2);
        /*if (health > 100) {
            health = 100;
        }*/
        health = tiger.levelCorrector(health);//новый метод
        tiger.setEnergy(energy);
        tiger.setHealth(health);
        checkEnergy(tiger);
        System.out.println("Тигр съел рыбу! -2 энергии. Текущая энергия: " + tiger.getEnergy() + ". Улучшил здоровье до " + tiger.getHealth());
    }

    private void eatFruitEvent(Tiger tiger) { // Событие 6. Тигр съел фрукт.
        int health = tiger.getHealth();
        health = health + (int) (tiger.getFangs() * 1);
       /* if (health > 100) {
            health = 100;
        }*/
        health = tiger.levelCorrector(health);//новый метод
        tiger.setHealth(health);
        checkEnergy(tiger);
        System.out.println("Тигр съел фрукт! Улучшил здоровье до " + tiger.getHealth());
    }

    private void drinkEvent(Tiger tiger) { // Событие 7. Тигр попил воды.
        int energy = tiger.getEnergy();
        int health = tiger.getHealth();
        energy = energy + 3;
       /* if (energy > 100) {
            energy = 100;
        }*/
        energy = tiger.levelCorrector(energy);//новый метод
        health = health + (int) (tiger.getFangs() * 2);
       /* if (health > 100) {
            health = 100;
        }*/
        health = tiger.levelCorrector(health);//новый метод
        tiger.setEnergy(energy);
        tiger.setHealth(health);
        checkEnergy(tiger);
        System.out.println("Тигр попил воды! +3 энергии. Текущая энергия: " + tiger.getEnergy() + ". Улучшил здоровье до " + tiger.getHealth());
    }

    private void diseaseEvent(Tiger tiger) { // Событие 8. Тигр заболел.
        int health = tiger.getHealth();
        health = health - 10;
        /*if (health < 0) {
            health = 0;
        }*/
        health = tiger.levelCorrector(health);//новый метод
        tiger.setHealth(health);
        checkEnergy(tiger);
        System.out.println("Тигр заболел! -10 здоровья. Текущее здоровье: " + tiger.getHealth());
    }

    private void fightEvent(Tiger tiger) { // Событие 9. Тигр подрался с другим тигром.
        int health = tiger.getHealth();
        int energy = tiger.getEnergy();
        health = health - 10;
        /*if (health < 0) {
            health = 0;
        }*/
        health = tiger.levelCorrector(health);//новый метод
        energy = energy - 20;
       /* if (energy < 0) {
            energy = 0;
        }*/
        energy = tiger.levelCorrector(energy);//новый метод
        tiger.setHealth(health);
        tiger.setEnergy(energy);
        checkEnergy(tiger);
        System.out.println("Тигр подрался с другим тигром! -20 энергии. Текущая энергия: " + tiger.getEnergy() + ". -10 здоровья. Текущее здоровье: " + tiger.getHealth());
    }

    private void hunterAttackEvent(Tiger tiger) { // Событие 10. На тигра напали охотники.
        int health = tiger.getHealth();
        health = health - 20;
       /* if (health < 0) {
            health = 0;
        }*/
        health = tiger.levelCorrector(health);//новый метод
        tiger.setHealth(health);
        checkEnergy(tiger);
        System.out.println("Напали охотники! -20 здоровья. Текущее здоровье: " + tiger.getHealth());
    }

    //true - продолжается симуляция
    //false - умер
    private boolean checkStatus(Tiger tiger) {
        System.out.println("hp: " + tiger.getHealth() + " energy: " + tiger.getEnergy());
        /*if (tiger.getHealth() <= 0) {                   //это надо сделать в одной строке
            return false;
        } else {
            return true;
        }*/
        if (tiger.getHealth() <= 0) return false;
        else return true;                                //сделала в одной строке, Alt+Ctrl+L разбивает на две

    }

    private void checkEnergy(Tiger tiger) { // Если энергия падает до 0, то здоровье уменьшается на 5 пунктов.
        if (tiger.getEnergy() <= 0) {
            int health = tiger.getHealth();
            health = health - 5;
            if (health < 0) {
                health = 0;
            }
            tiger.setHealth(health);
            System.out.println("Энергия упала до 0. -5 здоровья. Текущее здоровье: " + tiger.getHealth());
        }
    }
}

