import java.util.Scanner;

public class For {
    public static void main(String[] args) {
        int counter = 0;
        for (int i = 1; i <= 100; i++) {
            if (i % 3 == 0) {
                System.out.printf("%d ",i);
                counter++;
                if (counter % 10 == 0) { //한줄에 10개씩, 줄 바꿈
                    System.out.println();
                }
            }
        }
        System.out.printf("총 1에서 100까지의 3의 배수의 갯수는 : %d \n\n", counter);

    }
}
