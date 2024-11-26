# 🎬️ Jave 두번째 과제 Kiosk Project

#### 키오스크 프로그램을 만들며 객체지향 프로그래밍 패턴을 학습하였습니다.


## 🗒︎ Index
- 🎞️ 클래스 소개
  - Main
  - MenuItem
  - Menu
  - Cart
    
- ⚠️ 트러블 슈팅
  
- 😼 후기

  # Class
  ![image](https://github.com/user-attachments/assets/2236d1fa-d2ad-41c1-b26e-316ba3133d1e)
  
  ## - Main
  > 메인클래스는 프로그램 작동시키는 함수를 호출함.
  > 또 카테고리별 음식들을 세팅해줌.
---
메뉴 세팅
<details>
  <summary>코드 보기</summary>
  
```java
private static Menu getMenu() {
        ArrayList<MenuItem> bugers = new ArrayList<>();
        bugers.add(new MenuItem("ShackBurger", 6.9, "토마토, 양상추, 쉑소스가 토핑된 치즈버거"));
        bugers.add(new MenuItem("SmokeShack", 8.9, "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거"));
        bugers.add(new MenuItem("Cheeseburger", 6.9, "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거"));
        bugers.add(new MenuItem("Hamburger", 5.4, "비프패티를 기반으로 야채가 들어간 기본버거"));

        ArrayList<MenuItem> drinks = new ArrayList<>();
        drinks.add(new MenuItem("Coke", 2.5, "코카콜라 맛있다 맛있으면 또먹어"));
        drinks.add(new MenuItem("Soda", 2.5, "파워 탄산 사이다 목탁~! 켁켁"));
        drinks.add(new MenuItem("MilkShake", 4.5, "감튀 찍먹하면 JMT 다들 아시죵?"));
        drinks.add(new MenuItem("Coffee", 3.5, "우~아하게 최고급 원두로 내린 구수한 커피 향 맡으면서 한잔 어때요?"));
        drinks.add(new MenuItem("Juice", 3.0, "상큼하고 달콤한 생과일 쥬스!"));

        ArrayList<MenuItem> desserts = new ArrayList<>();
        desserts.add(new MenuItem("HotDog", 4.8, "참나무 칩으로 훈연한 비프 소시지와 토종효모 포테이토 번을 사용한 핫도그"));
        desserts.add(new MenuItem("Fries", 4.2, "바삭하고 담백한 크링클 컷 프라이"));
        desserts.add(new MenuItem("Cheese Fries", 4.9, "고소하고 진한 치즈 소스를 듬뿍 올린 크링클 컷 프라이"));

        Menu menuList = new Menu(bugers, drinks, desserts);
        return menuList;
    }
```
</details>


프로그램 동작함수 호출
<details>
  <summary>코드 보기</summary>
  
``` java
    public static void main(String[] args) {
        // 메인에서 데이터 넣고
        // 키오스크에서 넣은데이터 입출력
        Kiosk kiosk = new Kiosk(getMenu()); // 키오스트 객체 생성 Menu를 전달.
        kiosk.start();// 키오스크 동작 메서드
    }
  ```
  </details>


## - MenuItem
> 각 음식을 관리하는 클래스입니다.

<details>
  <summary>코드 보기</summary>
  
``` java
public class MenuItem {
    private String name; // 음식이름
    private double price; // 음식 가격
    private String explain; // 음식 설명
    public MenuItem(String name,double price,String explain) {
        this.name = name;
        this.price = price;
        this.explain = explain;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String getExplain() {
        return explain;
    }
}
  ```
  </details>

  ## - Menu
  > 각 음식(MenuItem)을 카테고리별 분류하여 List로 관리해주는 클래스입니다.

<details>
  <summary>코드 보기</summary>
  
```java
public class Menu {
    private ArrayList<MenuItem> buger = new ArrayList<>(); // 버거종류의 메뉴 리스트
    private ArrayList<MenuItem> drink = new ArrayList<>(); // 음료종류의 메뉴 리스트
    private ArrayList<MenuItem> desserts = new ArrayList<>(); // 디저트 종류의 메뉴 리스트

    public Menu() {} // 기본생성자

    /**
     * ArrayList<MenuItem>으로 각 카테고리별 음식을 넣어줌.
     * @param buger
     * @param drink
     * @param desserts
     */
    public Menu(ArrayList<MenuItem> buger, ArrayList<MenuItem> drink, ArrayList<MenuItem> desserts) {
        this.buger = buger;
        this.drink = drink;
        this.desserts = desserts;
    }

    /**
     *
     * @return 버거종류의 메뉴 리스트반환
     */
    public ArrayList<MenuItem> getBuger() {
        return buger;
    }

    /**
     *
     * @return 음료종류의 메뉴 리스트
     */
    public ArrayList<MenuItem> getDrink() {
        return drink;
    }

    /**
     *
     * @return 디저트 종류의 메뉴 리스트
     */
    public ArrayList<MenuItem> getDesserts() {
        return desserts;
    }

  ```
  </details>
  
  ## - Cart
  > 사용자가 구매 전 음식을 추가한 장바구니를 관리하는 클래스입니다. 음식이름, 수량, 가격이 있습니다. 또 추가된 음식에 따라 수량과 가격을 설정해줌.

  <details>
  <summary>코드 보기</summary>
    
```java
public class Cart {
    private String name;// 장바구니 안 음식이름
    private double price;// 장바구니 안 한개 음식의 총 가격
    private int quantity; // 장바구니 안 한개 음식의 수량

    /**
     * 생성자
     * 생성자를 이용해 장바구니 메뉴를 세팅 (추후 리스트에 넣기 위함)
     * @param name 음식이름
     * @param price 음식가겨
     * @param quantity 음식 수량
     */
    public Cart(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }


    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    /**
     * 같은 음식이 장바구니에 추가될때 객체를 생성하지 않고,
     * 음식의 수량을 +1 한 후 가격도 수량*단가 로 변경해줌.
     * @param unitPrice 음식 원래 가격(음식 단가)
     */
    public void plusQuantityPrice(double unitPrice) {
        this.quantity +=1;
        this.price=quantity*unitPrice;
    }

    /**
     * 장바구니 메뉴 수정 메서드
     * 수량을 입력 받아 해당음식의 수량과 총 가격을 수정.
     * @param quantity 사용자가 입력한 수량(수량 변경시)
     */
    public void modifyQuantity(int quantity) {
        double unitPrice=this.price/(this.quantity*1.0);
        this.quantity = quantity;
        this.price=quantity*unitPrice;
    }
}
  ```

  </details>

  ## - Kiosk
  > 사용자에게 입력을 받아 실질적 동작을 하는 함수와 각 기능별 함수들이 있는 클래스입니다.

### 필드

  <details>
  <summary>코드 보기</summary>
    
```java
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
  ```
  </details>
  
### 동작 함수 start()
  
 <details>
  <summary>코드 보기</summary>
   
``` java
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
  ```
  </details>

###  카테고리 선택 후 음식을 선택하는 함수
  
 <details>
  <summary>코드 보기</summary>
   
``` java
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
```
</details>

### 사용자의 입력을 받고, 잘못된 입력을 예외 처리하는 함수 selectMenu()
  
 <details>
  <summary>코드 보기</summary>
   
```java
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
```
</details>

### 장바구니에 음식을 추가하는 함수 insertCart()
  
<details>
  <summary>코드 보기</summary>
  
```java
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
```
 </details>
 
### 장바구니의 음식을 선택하여 수량을 변경하는 함수 modivyCart()
  
  <details>
  <summary>코드 보기</summary>     
  
```java
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
```
 </details>
 
이외의 장바구니 목록 조회. 장바구니 음식들 구매, 장바구니 초기화 등 이있다   
### Kiosk.java 전체 코드
 <details>
  <summary>Kiosk 전체코드보기</summary>
   
  ```java
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
```
  </details>

  # ⚠️ 트러블 슈팅
  ### double형 계산 문제
  - 여러개의 음식들을 장바구니에 넣은 후 총 가격을 보면 이상하게 출력 되어있었다.
    ![image](https://github.com/user-attachments/assets/e9ab9e27-fc3f-4542-9693-0428a8e39cfb)

    총 금액은 36.7 이 나와야하지만 36.6999999..6 이 나왔다

    ![image](https://github.com/user-attachments/assets/e47d5edb-9777-4fee-a071-800d41f8deaa)
    원인은 GPT를 통해 찾을 수 있었다.

    정확한 소수점 계산을 위해서 여러가지 방법이 있다.
    1. DigDesimal 클래스 사용
       
    ``` java
        BigDecimal totalPrice = BigDecimal.ZERO;

    // 예제 데이터를 BigDecimal로 변환
    BigDecimal item1Price = new BigDecimal("6.9");
    BigDecimal item2Price = new BigDecimal("25.0");
    BigDecimal item3Price = new BigDecimal("4.8");

    totalPrice = totalPrice.add(item1Price);
    totalPrice = totalPrice.add(item2Price);
    totalPrice = totalPrice.add(item3Price);
    ```
    를 사용해 정확한 소수점 계산을 할 수있다고 한다.

    2. Math.round를 사용하여 반올림 하기
    
    ```java
        double totalPrice = 6.9 + 25.0 + 4.8;

    // 반올림하여 소수점 둘째 자리까지만 표시
    totalPrice = Math.round(totalPrice * 100.0) / 100.0;
    ```

    직접 구현하여 해결 하진 않았지만 문제의 원인과 해결 방법을 알게되었다.

  ### 클래스의 활용
    또, 클래스 자체를 리스트에 넣거나 (List<MenuItem>) 어떻게 활용하면 좋을지 잘 몰랐었는데   
    이번 기회로 확실하게 객체지향 언어를 제대로 이해한것 같다!

  ### 장바구니 수량
   원래는 장바구니 추가할 때 MenuItem을 리스트를 이용해 장바구니를 구현했었다.
   하지만 문제점은 동일 메뉴일 경우 여러개가 따로 들어가는 문제가 있었고, 메뉴별 수량을 구현하기가 힘들었다.

   그래서 Cart클래스를 만들어 필드에 메뉴명,수량,가격을 넣고
   장바구니가 추가 될때 이미 리스트에있다면 리스트에서 해당 음식 이름을 찾아 수량과 가격을 변경하도록하였다.
   
   ```java
/**
     * 같은 음식이 장바구니에 추가될때 객체를 생성하지 않고,
     * 음식의 수량을 +1 한 후 가격도 수량*단가 로 변경해줌.
     * @param unitPrice 음식 원래 가격(음식 단가)
     */
    public void plusQuantityPrice(double unitPrice) {
        this.quantity +=1;
        this.price=quantity*unitPrice;
    }
```

   장바구니 항목의 수량을 수정 할 때에도
   해당 음식을 선택 후 수량을 입력받아 해당 음식의 수량과 가격이 변경되도록 하였다.

   ```java
 /**
     * 장바구니 메뉴 수정 메서드
     * 수량을 입력 받아 해당음식의 수량과 총 가격을 수정.
     * @param quantity 사용자가 입력한 수량(수량 변경시)
     */
    public void modifyQuantity(int quantity) {
        double unitPrice=this.price/(this.quantity*1.0);
        this.quantity = quantity;
        this.price=quantity*unitPrice;
    }
```

    
# 😼 후기
이번 과제는 도전 마지막 레벨까지 하지 않았다. 스프링을 학습하던 중이라 빠르게 끝낼 생각이었다.
또, 계산기보단 쉽다고했각했는데 기능이 더 다양해 조금 더 오래 걸렸던것 같다 
(집중만 했어도 금방했을듯..ㅎ)

깃 커밋도 기능별로 브런치를 만들거나 기능별로 커밋을 했어야했는데 이번에도 코드 다 작성 후.. 커밋해버려따...
담엔 꼭 무슨일이 있어도 깃 열씨미 해봐야겠다..

아 이번기회로 객체지향을 많이 이해하게 되었고, 직접 구현하진 않았지만, 콘솔에 출력문 색깔을 직접 지정할 수 있는 방법을 알게되었다.
마크다운언어도..마니 배운듯..
웅엥 귀차니즘만 해결하면 될듯하다..
    
    
