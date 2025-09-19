import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.StringTokenizer;
import java.util.Map;
import java.util.Iterator;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        HashMap<String, Integer> wordCountMap = new HashMap<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        try {
            int numberOfLines = Integer.parseInt(reader.readLine());
            for (int i = 0; i < numberOfLines; i++) {
                String line = reader.readLine();
                StringTokenizer tokenizer = new StringTokenizer(line);
                while (tokenizer.hasMoreTokens()) {
                    String word = tokenizer.nextToken().toLowerCase();
                    wordCountMap.put(word, wordCountMap.getOrDefault(word, 0) + 1);
                }
            }
        } catch (IOException e) {
            System.err.println("입력 오류가 발생했습니다: " + e.getMessage());
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                System.err.println("리더 닫기 오류: " + e.getMessage());
            }
        }

        // Iterator를 이용한 출력
        StringBuilder iteratorOutput = new StringBuilder("(Iterator 순회)\n");
        Iterator<Map.Entry<String, Integer>> iterator = wordCountMap.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Integer> entry = iterator.next();
            iteratorOutput.append(entry.getKey()).append(" : ").append(entry.getValue()).append("\n");
        }
        System.out.print(iteratorOutput.toString());

        // Stream을 이용한 정렬 출력
        StringBuilder streamOutput = new StringBuilder("\n(Stream 정렬)\n");
        wordCountMap.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .forEach(entry -> streamOutput.append(entry.getKey()).append("=").append(entry.getValue()).append("\n"));
        System.out.print(streamOutput.toString());

        // 선택 심화
        // A) 최다 등장 단어 찾기
        Optional<Map.Entry<String, Integer>> mostFrequentWord = wordCountMap.entrySet().stream()
                .max(Map.Entry.comparingByValue());
        mostFrequentWord.ifPresent(entry ->
                System.out.println("\n[최다 등장 단어] : " + entry.getKey() + " (" + entry.getValue() + "회)"));

        // B) 단어 길이 평균
        double averageLength = wordCountMap.keySet().stream()
                .mapToInt(String::length)
                .average()
                .orElse(0.0);
        System.out.printf("[단어 길이 평균] : %.2f\n", averageLength);
    }
}