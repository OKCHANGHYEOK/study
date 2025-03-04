package study;
// 자바 파일을 만들때는 패키지가 항상 들어가야한다.

public class Test {
    // 모든 자바언어는 클래스안에서 동작한다.
    // 클래스에는 변수선언 및 초기화 들어가고, 그리고 메서드의 기능 설정,
    // 실행이 전부 들어갈 수 있다.
    // ex) 코드는 아래와 같습니다
    private static String name = "옥창혁";
    // 변수를 설정 및 초기화하였다.

    public static void main(String[] args) {
        // 메서드 기능을 설정하고 있는데,
        // 해당 자바 프로그램이 시작될때 항상 실핻된다.
        // 호출이 필요가 없다.

        System.out.println("이름은 무엇인가요?");
        System.out.println("제 이름은 " + name + " 입니다.");
    }
}
