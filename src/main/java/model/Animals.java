package model;

import lombok.Getter;
import lombok.Setter;

@Getter
public abstract class Animals {

    private final String name;
    /**
     * пол животного
     */
    private final boolean male;
    private final boolean female;

    /**
     * гендерный суффикс в обращении
     */
    @Getter
    private final String genderSuffix;

    /**
     * кол-во особей мужского пола
     */
    @Getter
    private static int maleCount;

    private static final String FEMALE_SUFFIX = "а";

    @Getter
    @Setter
    private static int maximumRunningDistance;
    @Getter
    @Setter
    private static int maximumSwimmingDistance;

    private static final int DEFAULT_RUNNING_DISTANCE = 200;
    private static final int DEFAULT_SWIMMING_DISTANCE = 10;

    /**
     * кол-во экземпляров класса
     */
    @Getter
    private static int count;

    public Animals(String name) {

        this.name = name;
        maximumRunningDistance = DEFAULT_RUNNING_DISTANCE;
        maximumSwimmingDistance = DEFAULT_SWIMMING_DISTANCE;
        count++;
        female = name.endsWith(FEMALE_SUFFIX);
        male = !female;
        if (male) {
            maleCount++;
            genderSuffix = "";
        } else {
            genderSuffix = isFemale() ? FEMALE_SUFFIX : "";
        }
    }

    public static int getFemaleCount() {
        return count - maleCount;
    }

    /**
     * Абстрактный метод
     *
     * @param distanceLength -  заданная дистанция для бега
     */
    public abstract void run(int distanceLength);

    /**
     * Абстрактный метод
     *
     * @param distanceLength -  заданная дистанция для плавания
     */
    public abstract void swim(int distanceLength);

}
