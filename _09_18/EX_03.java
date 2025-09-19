import java.util.Arrays;
import java.util.HashSet;
void main(){
    //easy(); //쉬움문제
    //normal(); //보통문제
    hard();

}

void easy(){ //쉬움문제
    HashSet<String> set = new HashSet<>(Arrays.asList("사자", "코끼리", "펭귄"));
    set.add("사자");
    System.out.println("Set의 크기: "+ set.size());
}

void normal(){ //보통문제
    HashSet<String> set = new HashSet<>(Arrays.asList("Java", "Python", "C++", "Java"));
    LinkedHashSet<String> linkedSet = new LinkedHashSet<>(Arrays.asList("Java", "Python", "C++", "Java"));
    System.out.println("set : "+set);
    System.out.println("linkedSet : "+linkedSet);
    /** 출력결과
     * set : [Java, C++, Python], 순서X
     * linkedSet : [Java, Python, C++] 순서o
     * */
}

void hard(){
    HashSet<String> set1 = new HashSet<>(Arrays.asList("사과", "바나나", "체리"));
    HashSet<String> set2 = new HashSet<>(Arrays.asList("바나나", "체리", "딸기"));

    Set<String> result1 = new HashSet<>(set1);
    result1.retainAll(set2);
    System.out.println("교집합 :"+ result1); //교집합

    Set<String> result2 = new HashSet<>(set1);
    result2.addAll(set2);
    System.out.println("합집합 :"+ result2); //교집합

    set1.addAll(set2);
    System.out.println(set1);
    set1.removeAll(set2);
    System.out.println(set1);


}
