package OverrideAndOverload;

class Animal {
    public void move() {
        System.out.println("动物可以移动");
    }
}

class Dog extends Animal {
    public void move() {
        super.move();
        System.out.println("狗可以移动");
    }
}

public class Override {
    public static void main(String[] args) {
        Animal animal = new Animal();
        Animal dog = new Dog();
        animal.move();
        dog.move();
    }
}
