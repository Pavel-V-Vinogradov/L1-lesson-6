package model;

public abstract class Animals {

    private final String name;
    /**
     * пол животного
     */
    private final boolean male;
    /**
     * гендерный суффикс в обращении
     */
    private final String genderSuffix;

    /**
     * кол-во особей мужского пола
     */
    private static int maleCount;

    private static final String FEMALE_SUFFIX = "а";

    private static int MAXIMUM_RUNNING_DISTANCE;
    private static int MAXIMUM_SWIMMING_DISTANCE;

    private static final int DEFAULT_RUNNING_DISTANCE = 200;
    private static final int DEFAULT_SWIMMING_DISTANCE = 10;

    /**
     * кол-во экземпляров класса
     */
    private static int count;

    public Animals(String name) {

        this.name = name;
        MAXIMUM_RUNNING_DISTANCE = DEFAULT_RUNNING_DISTANCE;
        MAXIMUM_SWIMMING_DISTANCE = DEFAULT_SWIMMING_DISTANCE;
        count++;
        male = !name.endsWith(FEMALE_SUFFIX);
        if(male) {
            maleCount++;
            genderSuffix = "";
        } else {
            genderSuffix = isFemale() ? FEMALE_SUFFIX : "";
        }
    }

    public static int getMaximumRunningDistance() {
        return MAXIMUM_RUNNING_DISTANCE;
    }

    public static int getMaximumSwimmingDistance() {
        return MAXIMUM_SWIMMING_DISTANCE;
    }

    public String getName() {
        return name;
    }

    public static void setMaximumRunningDistance(int maximumRunningDistance) {
        MAXIMUM_RUNNING_DISTANCE = maximumRunningDistance;
    }

    public static void setMaximumSwimmingDistance(int maximumSwimmingDistance) {
        MAXIMUM_SWIMMING_DISTANCE = maximumSwimmingDistance;
    }

    public static int getMaleCount() {
        return maleCount;
    }

    public static int getFemaleCount() {
        return count - maleCount;
    }

    public String getGenderSuffix() {
        return genderSuffix;
    }

    public boolean isMale() {
        return male;
    }

    public boolean isFemale() {
        return !isMale();
    }

    public static int getCount() {
        return count;
    }

    /**
     * Абстрактный метод
     * @param distanceLength -  заданная дистанция для бега
     */
    public abstract void run(int distanceLength);
    /**
     * Абстрактный метод
     * @param distanceLength -  заданная дистанция для плавания
     */
    public abstract void swim(int distanceLength);

}
