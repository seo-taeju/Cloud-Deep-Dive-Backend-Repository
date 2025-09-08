import java.util.Scanner;

public class Star_Print {
    public static void main(String[] args) {
        System.out.printf("input : ");
        Scanner sc = new Scanner(System.in);
        int stars = sc.nextInt(); //사용자 값 입력

        for (int i = 1; i <= stars; i++) {
            for (int j = 0; j < i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
