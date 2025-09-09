import java.util.Arrays;
import java.util.Scanner;

public class Ararry_sort {
    public static void main(String[] args) {

        int[] array = createAndSortArray();

        // 배열의 총합과 평균 구하기
        int sum = 0;
        double avg = 0.0;

        // 배열의 총합 만들기
        for (int i = 0; i < array.length; i++) {
            sum += array[i];
        }// 배열의 평균구하기
        avg = sum / array.length;

        System.out.println("배열의 총합 : "+sum);
        System.out.printf("평균: %.2f", avg);

    }

    static int[] createAndSortArray(){
        Scanner scanner = new Scanner(System.in);

        System.out.printf("배열의 크기 입력 (숫자 입력): ");
        int number = scanner.nextInt(); //배열의 평균 구할떄도 사용할꺼임
        int[] array = new int[number]; //배열 크기 선언

        System.out.println("배열의 요소를 " + number + "개 입력하세요:");
        for (int i = 0; i < number; i++) {
            System.out.print((i + 1) + "번째 요소: ");
            array[i] = scanner.nextInt();
        }System.out.println();

        Arrays.sort(array); //배열 정렬 오른차순

        System.out.println("배열 출력");
        System.out.println(Arrays.toString(array));

        return array;
    }
}
/* 최적화된 코드
* import java.util.Arrays;
import java.util.Scanner;

public class Array_sort_optimized {
    public static void main(String[] args) {
        int[] array = createAndSortArray();

        // 스트림 API를 사용하여 총합과 평균 계산
        int sum = Arrays.stream(array).sum();
        double avg = Arrays.stream(array).average().orElse(0.0); // 배열이 비어있을 경우 0.0 반환

        System.out.println("배열의 총합: " + sum);
        System.out.printf("평균: %.2f%n", avg);
    }

    static int[] createAndSortArray() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("배열의 크기 입력 (숫자 입력): ");
        int number = scanner.nextInt();
        int[] array = new int[number];

        System.out.println("배열의 요소를 " + number + "개 입력하세요:");
        for (int i = 0; i < number; i++) {
            System.out.print((i + 1) + "번째 요소: ");
            array[i] = scanner.nextInt();
        }

        Arrays.sort(array);

        System.out.print("정렬된 배열: ");
        for (int i = 0; i < number; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();

        return array;
    }
}
* */

