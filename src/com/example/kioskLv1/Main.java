package com.example.kioskLv1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Scanner 객체를 생성하여 사용자 입력을 받습니다.
        Scanner sc = new Scanner(System.in);

        /**
         * while : 메뉴 선택을 반복하는 루프
         * 프로그램은 Lv1 요구사항에 따라 절차지향적으로 설계되었습니다.
         * 사용자는 메뉴를 선택하면 해당 메뉴의 정보를 출력하며,
         * '0'을 입력하면 프로그램이 종료됩니다.
         */
        while (true) {
            // 메뉴 출력
            System.out.println("[ SHAKESHACK MENU ]");
            System.out.println("1. ShackBurger   | W 6.9 | 토마토, 양상추, 쉑소스가 토핑된 치즈버거\n" + "2. SmokeShack    | W 8.9 | " +
                    "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거\n" + "3. Cheeseburger  | W 6.9 | 포테이토 번과 비프패티, 치즈가 토핑된 치즈버거\n" + "4. " +
                    "Hamburger     | W 5.4 | 비프패티를 기반으로 야채가 들어간 기본버거\n" + "0. 종료");

            // 사용자 입력 요청
            System.out.print("메뉴를 선택해주세요: ");
            String input = sc.nextLine(); // 사용자로부터 메뉴 선택 입력 받음

            // '0' 입력 시 프로그램 종료
            if (input.equals("0")) {
                System.out.println("프로그램을 종료합니다.");
                break;
            }
            // 사용자가 선택한 메뉴에 따라 출력
            else if (input.equals("1")) {
                System.out.println("선택한 메뉴: ShackBurger 가격 : W 6.9 \n");
            } else if (input.equals("2")) {
                System.out.println("선택한 메뉴: SmokeShack 가격 : W 8.9 \n");
            } else if (input.equals("3")) {
                System.out.println("선택한 메뉴: Cheeseburger 가격 : W 6.9 \n");
            } else if (input.equals("4")) {
                System.out.println("선택한 메뉴: Hamburger 가격 : W 5.4 \n");
            }
            // 잘못된 입력 처리
            else {
                System.out.println("잘못된 입력입니다. 다시 입력해주세요!\n");
            }
        }
    }
}