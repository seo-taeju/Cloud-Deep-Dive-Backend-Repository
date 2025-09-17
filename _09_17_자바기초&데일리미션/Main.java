import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        List<String> memberList = new ArrayList<String>();

        System.out.println("회원 이름을 5명 이상 입력하세요. (종료:'q')");
        int count =0; //회원 인원

        while(true){
            System.out.printf("이름 : " + (count+1)+": ");
            String name = input.nextLine();

            if(name.equals("q") && count >=5){
                break;
            } else if (name.equals("q") && count < 5) {
                System.out.println("최소 5명의 이름을 입력해야 합니다.");
                continue;
            }
            memberList.add(name);
            count++;
        }

        //조회 : 전체 회원 목록 출력
        System.out.println("\n--- 전체 회원 목록 ---");
        for (String member : memberList) {
            System.out.print(member);
        }
        System.out.println();

        // 검색: 특정 이름 검색
        System.out.print("\n검색할 이름을 입력하세요: ");
        String searchName = input.nextLine();
        if(memberList.contains(searchName)){
            System.out.println("검색 결과: \"" + searchName + "\"이(가) 존재합니다.");
        } else {
            System.out.println("검색 결과: \"" + searchName + "\"이(가) 존재하지 않습니다.");
        }

        // 삭제: 특정 이름 삭제
        System.out.print("삭제할 이름을 입력하세요: ");
        String deleteName = input.nextLine();
        if(memberList.remove(deleteName)){
            System.out.println("삭제 결과: \"" + deleteName + "\"이(가) 삭제되었습니다.");
            System.out.println("\n--- 삭제 후 전체 회원 목록 ---");
            System.out.println(memberList);
        } else {
            System.out.println("삭제 결과: \"" + deleteName + "\"이(가) 존재하지 않습니다.");
        }

        // 삭제 후 전체 회원 목록 다시 출력



        // 선택 심화
        // Collections.sort()를 활용해 리스트를 오름차순 정렬
        System.out.println("\n--- 정렬 후 회원 목록 ---");
        java.util.Collections.sort(memberList);
        System.out.println(memberList);


    }
}