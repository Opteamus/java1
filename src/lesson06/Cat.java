package lesson06;

public class Cat extends Animal {
    static int catsCount;

    public Cat (String name) {
        super(name);
        catsCount++;
    }

    @Override
    protected void run(int length) {
         if (length > 200) {
             length = 200;
         }
            super.run(length);

    }

    @Override
    protected void swim(int length) {
        System.out.println(this.getName() + " не умеет плавать");;
    }
}
