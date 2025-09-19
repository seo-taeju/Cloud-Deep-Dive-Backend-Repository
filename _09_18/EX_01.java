import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * List 예제 문제 (쉬움)
 * 문제: ArrayList를 생성하고, 좋아하는 과일 3가지를 추가한 후, "바나나"를 제거하고, 남은 과일들을 모두 출력하는 코드를 작성해 보세요.
 *
 * 출력 예시: [사과, 딸기]
 * */

public class EX_01 {
    public static void main(String[] args) {

        ArrayList<String> fruits = new ArrayList(Arrays.asList("apple", "orange", "banana", "kiwi", "grapefruit"));
        Collections.addAll(fruits, "apple", "banana", "kiwi", "grapefruit");
        for (String fruit : fruits) {
            System.out.println(fruit);
        }
        
        //하나식 추가
        fruits.add("바나나");
        fruits.add("키위");
        fruits.add("사과");
        fruits.remove("바나나");


        System.out.println("fruits: " + fruits);

    }
}