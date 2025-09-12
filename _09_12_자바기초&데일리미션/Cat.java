


// Cat.java
class Cat implements IAnimal {
    private final String name = "고양이";

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
        System.out.println("야옹~");
    }
}