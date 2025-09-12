import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        IAnimal dog = new Dog();
        Cat cat = new Cat();

        dog.eat();
        dog.sleep();
        dog.makeSound();

        cat.eat();
        cat.sleep();
        cat.makeSound();

        // 선택 심화: default 메소드 호출
        System.out.println("--- default 메소드 info() 호출 ---"); //개행
        dog.info();
        cat.info();
        System.out.println();

        System.out.println("--- 리스트/배열 반복문으로 동물 소리내기 --- \n\t1. 배열");
        //배열
        IAnimal[] animal = {dog, cat};
        for (IAnimal iAnimal : animal) {
            iAnimal.makeSound();
        }
        System.out.println("\t2.리스트");
        List<IAnimal> animalList = new ArrayList<>();
        animalList.add(dog);
        animalList.add(cat);
        for (IAnimal iAnimal : animal) {
            iAnimal.makeSound();
        }
        
    }
}


