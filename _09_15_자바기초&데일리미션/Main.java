import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try {
            // 정상적인 나이 테스트
            registerMember("김둘", 25);

            // 음수 나이 테스트
            //registerMember("김하나", -5);

            // 비정상적으로 큰 나이 테스트
            //registerMember("박보검", 200);

            // 이름 입력 안함 테스트
            registerMember(" ", 200);

        } catch (InvalidAgeException | InvalidNameException e) {
            System.out.println("예외 발생: " + e.getMessage());
        }

    }

    public static void registerMember(String name, int age) throws InvalidAgeException, InvalidNameException {
        System.out.printf("회원 등록: %s, 나이: %d → ", name, age);

        if(name == null || name.trim().isEmpty()) {
            throw new InvalidNameException("이름은 필수 입력 항목입니다.");
        }

        if(age < 0) {
                throw new InvalidAgeException("나이는 음수일 수 없습니다.");
        }else if(age > 100) {
                throw new InvalidAgeException("나이가 비정상적으로 큽니다.");
        }
        System.out.println("정상 등록 완료");

    }
}
