package com.example.kioskLv4_5;


import java.util.ArrayList;
import java.util.Scanner;

/**
 * 키오스크 프로그램의 메뉴를 관리하고 사용자 입력을 처리하는 클래스입니다.
 * 메뉴를 출력하고 사용자의 입력을 받아 메뉴를 선택하거나 프로그램을 종료할 수 있습니다.
 */
public class Kiosk {
    private static Scanner sc = new Scanner(System.in);// 사용자 입력을 처리하는 Scanner 객체

    private static Menu category = new Menu(); // 메뉴 카테고리 항목 데이터를 가져옵니다.

    /**
     * Menu클래스에는 카테고리별 List가 필드로 있음.
     * @param category 메인클래스에서 각 메뉴를 설정하여 생성자로 받습니다.
     */
    public Kiosk(Menu category) {
        this.category = category;
    }

    /**
     * Menu클래스의 해당 카테고리를 반환
     * getCategory().getBugers()..
     * @return 카테고리를 반환
     */
    public static Menu getCategory() {
        return category;
    }

    /**
     * 메인 프로그램 작동 메서드
     * 사용자의 입력의 따라 카테고리 선택 및 종료
     */
    public void start() {
        while (true) {
            System.out.println("\n[ MAIN MENU  ]\n" +
                    "1. Burgers\n" +
                    "2. Drinks\n" +
                    "3. Desserts\n" +
                    "0. 종료");
            System.out.print("메뉴를 선택해주세요: ");
            try { // 잘못된 입력을 예상하여 try
                int input = sc.nextInt(); //사용자의 입력을 받음.
                if (input == 0) { // 메인프로그램 종료
                    System.out.println("프로그램을 종료합니다.");
                    break;
                } else if (input>0 && input <= 3) { // 카테고리 3개 중 입력 받은 값이면 아래 함수 호출
                    subMenu(input); // 사용자가 입력한 카테고리의 해당 메뉴들을 선택하는 메서드 호출
                } else { // 입력한 범위가 잘못 되었을때
                    System.out.println("잘못된 입력입니다. 다시 입력해주세요!\n");
                }
            } catch (Exception e) { // 입력값이 숫자가 아닌 잘못된 값이 입력되었을때 처리
                System.out.println("잘못된 입력입니다. 다시 입력해주세요!\n");
                sc.nextLine(); // 잘못입력된 입력버퍼 제거
            }
        } // <--while
    } // <-- start()


    /**
     * 사용자가 선택한 카테고리의 메뉴들을 선택받는 메서드
     * @param categoryInput 카테고리 넘버
     */
    private static void subMenu(int categoryInput) {
        ArrayList<MenuItem> menuItemList = new ArrayList<>(); //전체 메뉴 리스트 객체 생성
        String title = ""; // 메뉴 카테코리 이름 출력용
        int menuNum = 0; // 메뉴 넘버링 초기화
        while (true) {
            switch (categoryInput){ // 입력한 카테고리의 이름 넣고, 카테고리별 음식항목 리스트에 초기화
                case 1 -> {title="[ BUBERS MENU ]"; menuItemList=getCategory().getBuger();}
                case 2 -> {title = "[ DRINKS MENU ]"; menuItemList=getCategory().getDrink();}
                case 3 -> {title="[ DESSERTS MENU ]"; menuItemList=getCategory().getDesserts();}
            }
            System.out.println("\n"+title); // 카테고리 이름 출력
            for (MenuItem m : menuItemList) { // 선택된 카테고리의 음식들 정보와 선택 넘버 출력
                System.out.printf("%-15s | 💸 W %-5s | %s \n", // 간격 정리를 위해 스트링 포맷이용
                        ++menuNum + ". " + m.getName(),
                        m.getPrice(),
                        m.getExplain());
            }
            System.out.println("0. 메인화면으로 이동");
            System.out.print("메뉴를 선택해주세요: ");
            try {
                int input = sc.nextInt(); // 사용자 입력(음식 선택)

                if (input == 0) { // 0입력시 메인화면으로 이동(서브반복문 종료)
                    System.out.println("메인화면으로 이동합니다.\n");
                    break;
                } else if (input>0&&input <= menuItemList.size()) {//해당 카테고리의 있는 음식 중 메뉴선택 일 경우 선택된 메뉴 출력
                    System.out.println("------------------------------------------------------------");
                    System.out.println("\t\t선택한 메뉴: \uD83D\uDE0B" + menuItemList.get(input - 1).getName()
                            + "\t|\t💸  가격 : W " + menuItemList.get(input - 1).getPrice());
                    System.out.println("------------------------------------------------------------");
                    break;
                } else {
                    System.out.println("잘못된 입력입니다. 다시 입력해주세요!\n"); // 해당 카테고리의 있는 음식 보다 큰 값 입력시.
                }
            } catch (Exception e) { // 숫자가 아닌 잘못된 값이 입력되었을경우
                System.out.println("잘못된 입력입니다. 다시 입력해주세요!\n");
                sc.nextLine(); // 잘못입력된 입력버퍼 제거
            }
        }

    }


}
