import java.util.Arrays;

public class Call_by_Value {
    public static void main(String[] args) {

        //Call by value
        int originalValue = 10;
        System.out.println("원본 값 = " + originalValue);
        changeValue(originalValue);
        System.out.println("→ changeValue() 호출 후 = " + originalValue + " (불변)");

        System.out.println("---");

        //참조 전달
        int[] originalArray = {1, 2, 3};
        System.out.println("원본 배열 = " + Arrays.toString(originalArray));
        changeArray(originalArray);
        System.out.println("→ changeArray() 호출 후 = " + Arrays.toString(originalArray) + " (변경됨)");

        System.out.println("---");

        //배열 복사
        int[] originalArray2 = {1, 2, 3};
        System.out.println("원본 배열 = " + Arrays.toString(originalArray2));
        changeArrayCopy(originalArray2);
        System.out.println("→ changeArrayCopy() 호출 후 = " + Arrays.toString(originalArray2) + " (원본 유지)");
    }

    static void changeValue(int a) {
        a = 20;
    }

    static void changeArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = arr[i] * 2;
        }
    }

    static void changeArrayCopy(int[] arr) {
        int[] newArr = Arrays.copyOf(arr, arr.length);
        changeArray(newArr); //배열 변경
        // 복사본 배열의 현재 상태를 출력하여 수정되었음을 보여줌
        System.out.println("메서드 내 복사본 배열 = " + Arrays.toString(newArr));
    }
}
