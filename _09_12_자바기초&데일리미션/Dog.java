
// Dog.java
class Dog implements IAnimal {
    private final String name = "강아지";

    @Override
    public void eat() {
        System.out.println(name + "가 밥을 먹습니다");
    }

    @Override
    public void sleep() {
        System.out.println(name + "가 잠을 잡니다");
    }

    @Override
    public void makeSound() {
        System.out.println("멍멍!");
    }
}