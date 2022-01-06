package model;

import java.util.Locale;

public class Dog extends Animals{
    private static int count;

    public Dog(String name) {
        super(name);
        setMaximumRunningDistance(500);
//        setMaximumSwimmingDistance(10);
        count++;
    }

    public static int getCount() {
        return count;
    }

    @Override
    public String getName() {
        return (isFemale() ? "Сучка" : "Пёсик")+ " \""+ super.getName() + "\"";
    }

    @Override
    public void run(int distanceLength) {
        int factDistance = Math.min(distanceLength, getMaximumRunningDistance());
        System.out.printf("%s пробежал%s %s из %s\n", this.getName(), getGenderSuffix(), factDistance, distanceLength );
    }

    @Override
    public void swim(int distanceLength) {
        int factDistance = Math.min(distanceLength, getMaximumSwimmingDistance());
        if(distanceLength > factDistance) {
            System.out.printf("%s УТОНУЛ%s! :( не доплыв %s из %sм\n",
                    this.getName(), getGenderSuffix().toUpperCase(Locale.ROOT), distanceLength - factDistance, distanceLength);
        } else {
            System.out.printf("%s проплыл%s %s из %s\n",
                    getName(), getGenderSuffix(), factDistance, distanceLength );
        }
    }

}
