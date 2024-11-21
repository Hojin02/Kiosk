package com.example.kioskLv2_3;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 키오스크 프로그램 작동 클래스
 * 메뉴를 출력하고 사용자의 입력을 받아 메뉴를 선택하거나 프로그램을 종료할 수 있습니다.
 */
public class Kiosk {//키오스크 프로그램의 메뉴를 관리하고 사용자 입력을 처리하는 클래스입니다.
    private static Scanner sc = new Scanner(System.in);// 사용자 입력을 처리하는 Scanner 객체
    private static ArrayList<MenuItem> menuItems; //생성자를 통하여 메뉴 항목 데이터를 가져옴.

    // 메뉴 리스트를 받는 생성자
    public Kiosk(ArrayList<MenuItem> menuItems) {
        this.menuItems = menuItems;
    }

    public void start() { // 입출력 작동 메서드

        int menuNum = 0; // 메뉴 번호 초기화
        while (true) {
            System.out.println("[ SHAKESHACK MENU ]"); 
            for (MenuItem m : menuItems) {// 모든 메뉴의 이름과 가격, 설명 출력
                System.out.println(++menuNum + ". " + m.getName() + "\t| W " + m.getPrice() + " | " + m.getExplain());
            }
            menuNum = 0;// 메뉴 번호 초기화
            System.out.println("0. 종료");
            System.out.print("메뉴를 선택해주세요: ");
            try {
                int input = sc.nextInt(); // 사용자 입력 (메뉴 번호)

                if (input == 0) { // 사용자가 0 입력시 종료
                    System.out.println("프로그램을 종료합니다.");
                    break;
                } else if (input>0&&input <= menuItems.size()) { // 리스트의 해당 메뉴 선택(인덱스)
                    System.out.println("선택한 메뉴: " + menuItems.get(input - 1).getName()
                            + " 가격 : W " + menuItems.get(input - 1).getPrice() + " \n");
                } else { // 메뉴리스트 범위가 아닐경우 출력
                    System.out.println("잘못된 입력입니다. 다시 입력해주세요!\n");
                }
            } catch (Exception e) { //숫자가 아닌 잘못된 값이 입력된 경우 예외처리
                System.out.println("잘못된 입력입니다. 다시 입력해주세요!\n");
                sc.nextLine(); // 잘못입력된 입력버퍼 제거
            }
        }
    }

}
