package study;

public class IfAndSwitch {
    public static void main(String[] args) {
        String today = "목요알";
        // if문
        if (today == "월요일") {
            System.out.println("오늘은 월요일입니다.");
        }
        else if (today == "화요일") {
            System.out.println("오늘은 화요일입니다.");
        }
        else {
            System.out.println("오늘은 월요일 또는 화요일이 아닙니다.");
        }

        String book = "비트코인";

        switch (book) {
            case "주식":
                System.out.println("이 책은 주식책입니다.");
                break;
            case "비트코인":
                System.out.println("이 책은 비트코인책입니다.");
                break;
            case "정치":
                System.out.println("이 책은 정치책입니다.");
                break;
            default:
                System.out.println("해당하는 책 종류가 없습니다.");
        }
    }
}
