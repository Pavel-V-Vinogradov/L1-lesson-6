package model;

import lombok.Getter;

public class Cat extends Animals {

    @Getter
    private static int count;

    public Cat(String name) {
        super(name);
//        setMaximumRunningDistance(200);
        setMaximumSwimmingDistance(0);
        count++;
    }

    @Override
    public void run(int distanceLength) {
        int factDistance = Math.min(distanceLength, getMaximumRunningDistance());
        System.out.printf("\"%s\" пробежал%s %s из %s\n", getName(), getGenderSuffix(), factDistance, distanceLength);
    }

    @Override
    public void swim(int distanceLength) {
        System.out.printf("\"%s\" не умеет плавать\n", getName());
    }
}
