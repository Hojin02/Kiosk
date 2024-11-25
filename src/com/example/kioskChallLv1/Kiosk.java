package com.example.kioskChallLv1;


import java.util.ArrayList;
import java.util.Scanner;

/**
 * 키오스크 프로그램의 메뉴를 관리하고 사용자 입력을 처리하는 클래스입니다.
 * 메뉴를 출력하고 사용자의 입력을 받아 메뉴를 선택하거나 프로그램을 종료할 수 있습니다.
 */
public class Kiosk {
    private static Scanner sc = new Scanner(System.in);// 사용자 입력을 처리하는 Scanner 객체

    private static Menu category = new Menu(); // 메뉴 카테고리 항목 데이터를 가져옵니다.

    private static ArrayList<Cart> cartList = new ArrayList<>();// 장바구니의 항목들을 넣을 리스트.

    /**
     * Menu클래스에는 카테고리별 List가 필드로 있음.
     *
     * @param category 메인클래스에서 각 메뉴를 설정하여 생성자로 받습니다.
     */
    public Kiosk(Menu category) {
        this.category = category;
    }

    /**
     * Menu클래스의 해당 카테고리를 반환
     * getCategory().getBugers()..
     *
     * @return 카테고리를 반환
     */

    /**
     * 메인 프로그램 작동 메서드
     * 사용자의 입력의 따라 카테고리 선택 및 종료
     */
    public void start() {
        while (true) {
            String selectMessege = ""; // 입력 전 보여줄 메세지.
            selectMessege +=
                    "\n[ MAIN MENU  ]\n" +
                            "1. Burgers\n" +
                            "2. Drinks\n" +
                            "3. Desserts\n";
            if (!cartList.isEmpty()) { // 장바구니 안 음식 이 존재한다면 같이 출력할 메시지
                selectMessege +=
                        "\n[ ORDER MENU  ]\n" +
                                "4. Orders\n" +
                                "5. Modify\n" +
                                "6. Cancel\n";
            }
            selectMessege +=
                    "0. 종료\n" +
                            "메뉴를 선택해주세요: ";
            int input = selectMenu(selectMessege); //사용자의 입력을 받음.
            if (input == 0) { // 메인프로그램 종료
                System.out.println("프로그램을 종료합니다.");
                break;
            } else if (input > 0 && input <= 3) { // 카테고리 3개 중 입력 받은 값이면 아래 함수 호출
                subMenu(input); // 사용자가 입력한 카테고리의 해당 메뉴들을 선택하는 메서드 호출
            } else if (!cartList.isEmpty() && input > 0 && input <= 6) {
                // 장바구니 로직 (장바구니 추가, 삭제(초기화) , 수량 수정
                processCart(input);
            } else { // 입력한 범위가 잘못 되었을때
                System.out.println("잘못된 입력입니다. 다시 입력해주세요!\n");
            }
        } // <--while
    } // <-- start()


    /**
     * 사용자가 선택한 카테고리의 메뉴들을 선택받는 메서드
     * (1번이 Bugers 이고 입력이 1 이라면, Bugers의 모든 음식 출력 및 선택)
     *
     * @param categoryInput 카테고리 넘버
     */
    private static void subMenu(int categoryInput) {
        ArrayList<MenuItem> menuItemList = new ArrayList<>(); //메뉴 리스트 객체 생성
        String selectMessege = ""; // 입력 전 출력 메시지
        String title = ""; // 메뉴 카테코리 이름 출력용
        int menuNum = 0; // 메뉴 넘버링 초기화
        while (true) {
            switch (categoryInput) { // 입력한 카테고리의 이름 넣고, 카테고리별 음식항목 리스트에 초기화
                case 1 -> {
                    title = "[ BUBERS MENU ]";
                    menuItemList = category.getBuger(); // menuItemList를 Buger카테고리의 음식들로 초기화
                }
                case 2 -> {
                    title = "[ DRINKS MENU ]";
                    menuItemList = category.getDrink(); // menuItemList를 Drink 카테고리의 음식들로 초기화
                }
                case 3 -> {
                    title = "[ DESSERTS MENU ]";
                    menuItemList = category.getDesserts(); // menuItemList를 Dessser 카테고리의 음식들로 초기화
                }
            }
            System.out.println("\n" + title); // 카테고리 이름 출력
            for (MenuItem m : menuItemList) { // 선택된 카테고리의 음식들 정보와 선택 넘버 출력
                selectMessege += String.format(
                        "%-15s | 💸 W %-5s | %s \n",
                        ++menuNum + ". " + m.getName(),  // 메뉴 번호와 이름
                        m.getPrice(),                   // 메뉴 가격
                        m.getExplain()                  // 메뉴 설명
                );
            }
            selectMessege += "0. 메인화면으로 이동\n" + "메뉴를 선택해주세요: ";

            int input = selectMenu(selectMessege); // 사용자 입력(음식 선택)
            if (input == 0) { // 0입력시 메인화면으로 이동(서브반복문 종료)
                System.out.println("메인화면으로 이동합니다.\n");
                break;
            } else if (input > 0 && input <= menuItemList.size()) {//해당 카테고리의 있는 음식 중 메뉴선택 일 경우 선택된 메뉴 출력
                System.out.println("------------------------------------------------------------");
                System.out.println("\t\t선택한 메뉴: \uD83D\uDE0B" + menuItemList.get(input - 1).getName()
                        + "\t|\t💸  가격 : W " + menuItemList.get(input - 1).getPrice());
                System.out.println("------------------------------------------------------------");
                insertCart(menuItemList.get(input - 1)); // 장바구니 추가메소드 호출 (MenuItem을 파라미터로 넣음)
                break;
            } else {
                System.out.println("잘못된 입력입니다. 다시 입력해주세요!\n"); // 해당 카테고리의 있는 음식 보다 큰 값 입력시.
            }
        }
    }//  <-- subMenu()

    /**
     * 추가된 장바구니의 음식들 구매 메서드
     */
    private static void orderCart() {
        while (true) {
            double totPrice = 0; // 음식의 총 가격
            System.out.println("[ Orders ]");
            System.out.println("------------------------------------------------------------");
            for (Cart cart : cartList) { //장바구니의 모든 음식들을 출력(메뉴이름, 수량, 총 가격)
                System.out.printf("\t\t선택한 메뉴:\uD83D\uDE0B %-15s | 수량 : %-5d 💸  가격 : W %.1f\n", cart.getName(),
                        cart.getQuantity(), cart.getPrice());
                totPrice += cart.getPrice();
            }
            System.out.println("------------------------------------------------------------");
            System.out.println("[ Total ]");
            System.out.println("💸  가격 : W " + totPrice);
            String selectMessege = "1. 주문\t\t\t2. 메뉴판\n" +
                    "선택해주세요: ";

            int orderSelect = selectMenu(selectMessege); // 입력 메소드 호출
            if (orderSelect == 1) { // 사용자가 1입력시 주문 후 장바구니 초기화
                System.out.println("주문이 완료되었습니다 금액은. 💸W " + totPrice + " 입니다.");
                cartList.clear();
                break;
            } else if (orderSelect == 2) { // 2입력시 메인메뉴로 이동 구매X 장바구니 초기화 X
                System.out.println("메인 화면으로 이동합니다.");
                break;
            }
            //// 1번을 누르면 나오는 메뉴입니다.
//주문이 완료되었습니다. 금액은 W 8.9 입니다.
        }
    }

    /**
     * 장바구니의 모든 기능을 관리하는 메서드
     *
     * @param input 사용자 입력값.
     */
    private static void processCart(int input) {
        if (input == 4) {
            orderCart();// 장바구니 음식들 출력 및 구매
        } else if (input == 5) {
            modifyCart();// 장바구니 안 음식의 수량을 수정
        } else if (input == 6) {
            System.out.println("장바구니를 초기화합니다."); // 장바구니 초기화
            cartList.clear();
        }

    }

    /**
     * 장바구니 수정 메서드
     * 장바구니의 사용자가 선택한 음식의 수량을 사용자가 직접 수정
     * int input : 장바구니 안 메뉴선택
     * int selectQuantity : 수량입력
     */
    private static void modifyCart() {
        while (true) {
            int menuNum = 0; // 장바구니 음식들 넘버링
            double totPrice = 0; // 장바구니 음식의 총 가격
            String msg = ""; // 사용자 입력 전 출력 메시지
            msg += "[ Cart Modify ]\n";
            for (Cart cart : cartList) { // 장바구니의 모든 음식 정보 출력
                msg += String.format("%d\t\uD83D\uDE0B %-15s | 수량: %-5d💸  가격 :\t%.1f\n", ++menuNum, cart.getName(),
                        cart.getQuantity(), cart.getPrice());
                totPrice += cart.getPrice();
            }
            msg += "[ Total ]\n💸  가격 : W " + totPrice + "\n" +
                    "0. 메인화면으로 이동\n" +
                    "------------------------------------------------------------\n" +
                    "장바구니에서 변경할 항목을 선택해주세요: ";
            if (cartList.isEmpty()) { // 수정으로 인해 모든 메뉴의 수량이 0일때(장바구니가 비어있게 되면)
                break;
            }
            int input = selectMenu(msg); //사용자 입력 메서드( 수정 할 음식 선택)
            if (input == 0) {
                System.out.println("메인화면으로 이동합니다.");
                break;
            } else if (input > 0 && input <= cartList.size()) { // 입력한 값이 장바구니 리스트 범위안에 있다면.
                while (true) {
                    msg = "[수량 변경]\n선택된 항목: " + cartList.get(input - 1).getName() + " 수량: " + cartList.get(input - 1).getQuantity()
                            + "\n선택된 메뉴의 수량을 입력해주세요 : "; // 사용자 입력 전 출력 메시지
                    int selectQuantity = selectMenu(msg); // 사용자 입력 메소드 호출 ( 수량 입력)
                    if (selectQuantity == 0) { // 수량:0 입력시
                        cartList.remove(input - 1); // 리스트에서 해당음식 제거
                        break;
                    } else if (selectQuantity > 0) {
                        cartList.get(input - 1).modifyQuantity(selectQuantity);// 해당 음식의 수량 변경(수량과 가격이 변경됨)
                        break;
                    } else {
                        System.out.println("잘못된 입력입니다. 다시 입력해주세요!\n");
                    }
                }
            } else {
                System.out.println("잘못된 입력입니다. 다시 입력해주세요!\n");
            }
        }
    }


    /**
     * 장바구니 추가 메서드
     *
     * @param menuItem 사용자가 선택한 음식 정보
     */
    private static void insertCart(MenuItem menuItem) {
        while (true) {
            String selectMessege = // 사용자 입력 전 출력 메시지
                    "위 메뉴를 장바구니에 추가하시겠습니까?\n" +
                            "1. 확인\t\t\t2. 취소\n" +
                            "선택해주세요: ";
            int input = selectMenu(selectMessege); // 입력 메소드 호출
            if (input == 1) {
                // 카트에 넣기
                boolean already = false; // 이미 장바구이 안에 있음 음식인지 판별
                for (Cart cart : cartList) { // 장바구니 리스트 안 모든 음식 탐색
                    if (cart.getName().equals(menuItem.getName())) { // 장바구니 리스트에 사용자가 선택한 음식이 이미 존재한다면
                        cart.plusQuantityPrice(menuItem.getPrice()); // 장바구니 리스트 안에 있음 해당 음식의 수량을 +1 후 음식의 총 가격 수정
                        already = true;
                    }
                }
                if (!already) { // 사용자가 선택한 음식이 장바구니 리스트에 존재 하지 않는다면,
                    cartList.add(new Cart(menuItem.getName(), menuItem.getPrice(), 1));
                    // 장바구니 리스트에 해당 음식 추가
                }
                System.out.println(menuItem.getName() + " 메뉴가 장바구니에 추가되었습니다.\n");
                break;
            } else if (input == 2) { // 장바구니 추가 XX
                // 취소
                System.out.println("메인화면으로 이동합니다.\n");
                break;
            } else {
                System.out.println("잘못된 입력입니다. 다시 입력해주세요!\n"); // 선택 메뉴 외 다른 입력 시.
            }
        }
    } // <-- InsertCart()

    /**
     *
     * @param selectMessege 입력 전 출력할 메시지를 받음.
     * @return 사용자가 올바른 숫자 입력 시 입력값을 반환.
     */
    private static int selectMenu(String selectMessege) {
        while (true) {
            System.out.print(selectMessege); // 입력 전 메시지 호출
            try {
                int select = sc.nextInt();
                return select;
            } catch (Exception e) { // int형 문자가 아닐 경우(문자 또는 실수일 경우) 예외 처리
                System.out.println("잘못된 입력입니다. 다시 입력해주세요!\n");
                sc.nextLine(); // 잘못입력된 입력버퍼 제거
            }
        }
    } // <-- selectMenu()


}
