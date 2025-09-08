import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //입력과 출력 기본 실습
        Input_Output();
        If_Else_Switch();
        SumGugudan();
        Arrays();

        add_sum_avg();
    }

    //(Java) 입력과 출력 기본 실습
    static void Input_Output(){
        Scanner sc = new Scanner(System.in);

        /*이름를 입력하세요*/
        System.out.printf("이름 : ");
        String name = sc.nextLine();

        /*나이를 입력하세요*/
        System.out.printf("나이: ");
        int age  = sc.nextInt();

        System.out.printf("입력값 출력 성공 : 이름 = %s, 나이 = %d \n\n", name, age);
    }


    //(Java) 조건문 활용 프로그램
    static void If_Else_Switch() {

        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("짝수/홀수 판별 1번, 학점 판별 2번, 종료 3번");
            System.out.printf("숫자를 입력하세요(1,2,3): ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    /*짝수 홀수 판별*/
                    System.out.printf("숫자 입력하세요(짝수/홀수 판별):");

                    int num = sc.nextInt();
                    if (num % 2 == 0) {
                        System.out.println("짝수\n");
                    } else {
                        System.out.println("홀수\n");
                    }
                    break;

                case 2:
                    /*학점(A-F) 판별*/
                    System.out.printf("점수를 입력하세요: ");
                    int score = sc.nextInt();

                    String grade; //학점 변환 로직
                    if (score >= 90) {
                        grade = "A";
                    } else if (score >= 80) {
                        grade = "B";
                    } else if (score >= 70) {
                        grade = "C";
                    } else if (score >= 60) {
                        grade = "D";
                    } else {
                        grade = "F";
                    }
                    System.out.printf("grade : %s\n\n", grade);
                    break;

                case 3:
                    System.out.println("!!프로그램을 종료합니다.!!");
                    break;
            }
        } while (choice != 3);
    }

    //(Java) 반복문 활용 프로그램
    static void SumGugudan() {
        //1부터 100까지 합계 계산
        int sum = 0;
        for (int i = 1; i <= 100; i++) {
            sum += i;
        }
        System.out.printf("1부터 100까지 총합 %d",sum);

        //2단 부터 9단 까지 출력
        for (int j = 2; j <= 9; j++) {
            System.out.printf("  %5d단   ",j);
        }
        System.out.println();

        for (int i = 1; i <= 9; i++) {
            for (int j = 2; j <= 9; j++) {
                System.out.printf("%d * %d = %2d  ",j , i, i * j);
            }
            System.out.println();
        }
    }

    //(Java) 배열과 정렬 실습
    static void Arrays() {
        Scanner sc = new Scanner(System.in);

        int[] arr = new int[5];

        // 반복문을 이용해 배열에 값 할당
        System.out.println("\ninput: ");
        for (int i = 0; i < arr.length ; i++) {
            arr[i] = sc.nextInt();
        }

        //입력받은 값 확인
        System.out.println("\n입력된 배열의 값:");
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("%d ",arr[i]);
        }

        System.out.println("\n정렬후");
        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("%d ",arr[i]);
        }
    }

    static int add(int a, int b) {
        return a + b;
    }
    static int sub(int a, int b) {
        return a - b;
    }
    static double avg(double a, double b) {
        return 2 / (a+b);
    }

    static void add_sum_avg(){
        Scanner input = new Scanner(System.in);
        System.out.println("\n두 정수를 입력하세요:");
        int num1 = input.nextInt();
        int num2 = input.nextInt();

        int sum =  add(num1, num2);
        int minus = sub(num1, num2);
        int average = sum/minus;
        System.out.printf("%d와 %d 입력시 합 = %d, 차 =%d, 평균 =%d\n", num1,num2,sum,minus,average);
    }
}