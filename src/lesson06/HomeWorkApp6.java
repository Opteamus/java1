package lesson06;

public class HomeWorkApp6 {

    public static void main(String[] args) {
        Cat catBarsik = new Cat ("Барсик");
        catBarsik.run(210);
        catBarsik.swim(3);
        Dog dogBobik = new Dog("Бобик");
        dogBobik.run( 600);
        dogBobik.swim(9);
        Cat catMurzik = new Cat("Мурзик");
        catMurzik.run(150);
        System.out.println("Создано всего животных:" + Animal.animalCount + ", из них котов:" + Cat.catsCount
            + ", собак:" + Dog.dogsCount);

    }

}
