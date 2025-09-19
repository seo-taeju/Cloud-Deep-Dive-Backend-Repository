import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;


static final Map<Integer, String> members = new HashMap<>();
static final StringBuilder output = new StringBuilder();

void main() {
    BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    try {
        int N = Integer.valueOf(input.readLine().trim());

        for (int i = 0; i < N; i++) {
            String line = input.readLine().trim();
            processCommand(line);
        }

        // 최종 출력
        System.out.println(output);

    } catch (IOException e) {
        e.printStackTrace();
    } catch (NumberFormatException e) {
        output.append("잘못된 입력 형식입니다.\n");
    }

}

void processCommand(String line) {
    if (line == null || line.trim().isEmpty()) {
        output.append("빈명령어입니다.\n");
        return;
    }

    String[] parts = line.trim().split("\\s+", 3);
    //3개로 쪼꺳었음.
    String command = parts[0].toUpperCase(); // 명령어 string으로 들어감.
    switch (command) {
        case "ADD":
            handleAdd(parts);
            break;
        case "GET":
            handleGet(parts);
            break;
        case "DELETE":
            handleDelete(parts);
            break;
        case "LIST":
            handleList();
            break;
        default:
            output.append("알수없는 명령어: ").append(parts[0]).append("\n");

    }
}
/**
 * ADD 명령어: 회원 등록
 * 형식: ADD id name
 */
void handleAdd(String[] parts) {
    if (parts.length < 3) {//파라미터 개수 체크
        output.append("ADD 명령어 형식 오류: ADD id name\n");
        return;
    }
    try {
        int id = Integer.valueOf(parts[1].trim());
        String name = parts[2];

        if (members.containsKey(id)) { //중복 id 체크
            output.append("이미 존재하는 회원입니다.\n");
        }else {
            members.put(id, name);
            output.append("회원 등록 완료 : ").append(id).append("-").append(name).append("\n");
        }
    } catch (NumberFormatException e) {
        output.append("id는 정수어야 합니다.\n");
    }

}
/**
 * GET 명령어: 회원 조회
 * 형식: GET id
 */
void handleGet(String[] parts) {
    if (parts.length < 2) {//파라미터 개수 체크
        output.append("GET 명령어 형식 오류: GET id\n");
        return;
    }

    try {
        int id = Integer.valueOf(parts[1].trim());
        String name = members.get(id); //회원 id 가져오기

        if (name != null) {
            output.append("조회 결과: ").append(name).append("\n");
        }else {
            output.append("회원 없음\n");
        }
    }catch (NumberFormatException e) {
        output.append("ID 정수어야 합니다.\n");
    }
}

/**
 * DELETE 명령어: 회원 삭제
 * 형식: DELETE id
 */
void handleDelete(String[] parts) {
    if (parts.length < 2) {
        output.append("DELETE 명령어 형식 오류: DELETE id\n");
        return;
    }

    try {
        int id = Integer.valueOf(parts[1].trim());
        if (members.remove(id) != null) {
            output.append("회원 삭제 완료: ").append(id).append("\n");
        }else {
            output.append("삭제할 회원 없음\n");
        }

    } catch (NumberFormatException e) {
        output.append("ID 정수어야 합니다.");
    }
}

/**
 * LIST 명령어: 전체 회원 목록 출력
 * 형식: LIST
 */
void handleList() {
    output.append("전체 회원");
    if (members.isEmpty()) {
        output.append("회원 정보가 없습니다.\n");
    }else  {
        for (Map.Entry<Integer, String> entry : members.entrySet()) {
            output.append(entry.getKey()).append(":").append(entry.getValue()).append("\n");
        }
    }
}


