package lesson06;

public class Animal {
    static int animalCount;
    private String name;


    public Animal (String name) {
        this.name = name;
        animalCount++;

    }

    public String getName() {
        return name;
    }

    protected void run(int length) {
        if (length > 0) {
            System.out.println(this.getName() + " пробежал " + length + " м.");
        }
    }

    protected void swim(int length) {
        if (length > 0) {
            System.out.println(this.getName() + " проплыл " + length + " м.");
        }
    }
}


