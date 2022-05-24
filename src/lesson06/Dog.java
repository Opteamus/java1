package lesson06;

public class Dog extends Animal {
    static int dogsCount;

    public Dog (String name) {
        super(name);
        dogsCount++;
    }

    @Override
    protected void run(int length) {
        if (length > 500) {
            length = 500;
        }
        super.run(length);
    }

    @Override
    protected void swim(int length) {
        if (length > 10) {
            length = 10;
        }
        super.swim(length);
    }
}
