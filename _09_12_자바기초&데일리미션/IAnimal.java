interface IAnimal {
    void eat();

    void sleep();

    void makeSound();

    default void info() {
        System.out.println("동물입니다.");
    }

}