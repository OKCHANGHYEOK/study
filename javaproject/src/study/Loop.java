package study;

import java.util.Scanner;

public class Loop {
    public static void main(String[] args) {
        // for(초기식, 조건식, 증감식) {}
        for (int i = 1; i < 10; i++) {
            System.out.println("안녕");
            // i가 1,2,3,4,5,6,7,8,9로 9번 반복
            System.out.println("숫자: " + i);
        }
        // 초기식
        // while(조건식) {반복할코드;증감식}
        // 종료가 정해진 경우, 정해져 있지 않은 경우 존재

        int i = 1;
        while (i < 10) {
            System.out.println("안녕");
            i++;
        }

        Scanner sc = new Scanner(System.in);

        while (true) {
            String input = sc.nextLine();

            if (input.equals("안녕")) {
               break;
            }

            System.out.println("안녕1");
        }

        // do-while 문은 초기 한번은 반드시 실행되어야할때 사용
        // do 블록 -> do { } 을 먼저 실행한 후 조건 검사
        // do { 반복할코드 } while(조건식)

        Scanner sc2 = new Scanner(System.in);
        int number;

        do {
            System.out.println("1부터 5사이의 숫자를 입력해주세요 : ");
            number = sc2.nextInt();
        } while (number > 5 || number < 1);
        System.out.println("조건에 맞는 숫자 입력!");
    }
}
