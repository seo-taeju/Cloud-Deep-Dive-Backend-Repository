class Animals {
    public String name;

    public void makeSound(){
        System.out.println("동물이 소리를  냅니다.");
    }
}

class Dog extends Animals{
    @Override
    public void makeSound(){
        System.out.println("멍멍!");
    }
}

class Cat extends Animals{
    @Override
    public void makeSound(){
        System.out.println("야옹야옹!");
    }
}

public class Main{
    public static void main(String[] args) {
        Animals animals = new Animals();
        Animals dog = new Dog();
        Animals cat = new Cat();

        animals.makeSound();
        dog.makeSound();
        cat.makeSound();
    }
}
