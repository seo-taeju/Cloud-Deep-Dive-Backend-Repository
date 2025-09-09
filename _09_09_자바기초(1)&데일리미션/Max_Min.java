import java.util.Arrays;
import java.util.Scanner;

public class Max_Min {
    public static void main(String[] args) {
        int[] array = Ararry_sort.createAndSortArray();

        // 1. 최댓값, 최솟값 변수 선언 및 초기화
        int max = array[0];
        int min = array[0];

        // 2. 반복문을 사용해 최댓값과 최솟값을 찾음
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) { // 현재 요소가 max보다 크면 max 업데이트
                max = array[i];
            }
            if (array[i] < min) { // 현재 요소가 min보다 작으면 min 업데이트
                min = array[i];
            }
        }
        System.out.println("배열에서 최댓값은: " + max);
        System.out.println("배열에서 최솟값은: " + min);
    }
}
