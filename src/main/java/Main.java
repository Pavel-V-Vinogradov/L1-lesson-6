import model.Animals;
import model.Cat;
import model.Dog;
import model.Tiger;

public class Main {
    public static void main(String[] args) {

        //@formatter:off
        System.out.println(
            "|\\---/|\n" +
            "| o_o |\n" +
            " \\_^_/"
        );
        //@formatter:on
        playAnimals(new String[]{"Барсик", "Васька", "Мурзик", "Мусик", "Плюша", "Мурка"}, Cat.class);

        //@formatter:off
        System.out.println(
                "   / \\__\n" +
                        "  (    @\\___\n" +
                        "  /         O\n" +
                        " /   (_____/\n" +
                        "/_____/   U"
        );
        //@formatter:on
        playAnimals(new String[]{"Палкан", "Дозор", "Лютый", "Дамка", "Багира", "Альма"}, Dog.class);
        playAnimals(new String[]{"Шерхан"}, Tiger.class);

        Animals[] animals = new Animals[]{
                new Cat("Барсик"),
                new Cat("Мурка"),
                new Dog("Палкан"),
                new Dog("Мухтар"),
                new Dog("Бим")
        };


        //@formatter:off
        System.out.printf(
                        " \n" +
                        "/ \\                             \\.\n" +
                        "|   |                            |.\n" +
                        " \\_ |  Всего:                    |.\n" +
                        "    |   животных: %s             |.\n" +
                        "    |   котиков: %s               |.\n" +
                        "    |   пёсиков: %s               |.\n" +
                        "    |                            |.\n" +
                        "    |   из них:                  |.\n" +
                        "    |       \"мальчиков\": %s      |.\n" +
                        "    |          \"девочек\": %s      |.\n" +
                        "    |                            |.\n" +
                        "    |                            |.\n" +
                        "    |   Ни одно из животных      |.\n" +
                        "    |          не пострадало! :) |.\n" +
                        "    |                            |.\n" +
                        "    |   _________________________|___\n" +
                        "    |  /                            /.\n" +
                        "    \\_/____________________________/.",
                Animals.getCount(), Cat.getCount(), Dog.getCount(),
                Animals.getMaleCount(), Animals.getFemaleCount()
        );
        //@formatter:on
    }

    private static void playAnimals(String[] nickNames, Class<? extends Animals> classAnimal) {
        Animals[] animals = getAnimals(nickNames, classAnimal);
        if (animals == null) return;

        int runCoeff = 1;
        int swimCoeff = 10;
        for (Animals animal : animals) {
            if(animal.getClass() == Cat.class) {
                runCoeff = 200;
            } else if(animal.getClass() == Dog.class) {
                runCoeff = 700;
            }
            animal.run((int) ((Math.random() * runCoeff) + Math.random() * 100));
            animal.swim((int) ((Math.random() * swimCoeff) + Math.random() * 10));
        }
    }

    private static Animals[] getAnimals(String[] nickNames, Class<? extends Animals> classAnimal) {
        Animals[] animals = new Animals[nickNames.length];

        for (int i = 0; i < nickNames.length; i++) {
            if (classAnimal == Cat.class) {
                animals[i] = new Cat(nickNames[i]);
            } else if (classAnimal == Dog.class) {
                animals[i] = new Dog(nickNames[i]);
            } else {
                System.out.println("\nВНИМАНИЕ: Класс " + classAnimal + " не поддерживается");
                return null;
            }
        }
        return animals;
    }
}
